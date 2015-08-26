
import java.net.*;
import java.io.*;
import java.awt.*;
import java.util.*;
import chess.*;

public class ChessPlayer extends EditableChessboard implements Runnable {
  private String fen;
  private String chessplayer;
  private String pending_move;

  private TextField text;

  private Stack old_states;

  public void init() {
    super.init();

    text = new TextField(40);
    text.setEditable(false);
    this.add(text);

    old_states = new Stack();
    fen = getParameter("fen");
    chessplayer = getParameter("chessplayer");
  }

  public void showStatus(String msg) {
    if(text != null) {
      text.setText(msg);
    } else {
      super.showStatus(msg);
    }
  }

  public synchronized void reset() {
    stop();
    super.reset();

    if(old_states != null) old_states.removeAllElements();
    fen = getParameter("fen");
  }

  public synchronized void go_back() {
    stop();

    if(!old_states.empty()) {
      fen = (String) old_states.pop();
      display.getBoard().setFEN(fen);
      showStatus("Undo!");
    } else {
      showStatus("Nothing to go back to.");
    }
  }

  private Thread move_fetcher;

  public void stop() {
    if(move_fetcher != null && move_fetcher.isAlive()) {
      move_fetcher.stop();
    }
    pending_move = null;
    move_fetcher = null;
  }

  public boolean keyDown(Event e, int key) {
    char k = ((char ) key);
    if(e.id == Event.KEY_PRESS) {
      if(k == 'g') {
	this.do_computer_move();
	display.flip();
	return true;
      } else if(k == 'b') {
	this.go_back();
	return true;
      }
    }
    /* else */
    return super.keyDown(e, key);
  }

  public void do_computer_move() {
    showStatus("Ok, I'll make the next move...");
    send_move("go");
  }


  public synchronized boolean send_move(String s) {
    if(pending_move != null) {
      showStatus("It isn't your move!");
      return false;
    }


    pending_move = s;


    move_fetcher = new Thread(this);
    move_fetcher.start();

    return true;
  }

  public synchronized void move(Square from, Square to) {
    String move;

    if(from.equals(to)) {
      return;
    }


    move = from.toString() + to.toString();


    if(display.getBoard().pieceAt(from).getType() == Piece.PAWN
       && (to.getRank() == 0 || to.getRank() == Board.SIZE - 1)) {
      move = move + 'q';
    }

    if(send_move(move)) {
      super.move(from, to);
      showStatus("Your move: " + move);
    }
  }

  public void run() {
    URL url;


    if(fen != null && chessplayer != null) {
      String new_fen;


      try {
	synchronized(this) {
	  url = new URL(getDocumentBase(),
			chessplayer + "?"
			+ fen.replace(' ', '+')
			+ ":"
			+ pending_move);
	}


	URLConnection c = url.openConnection();
	DataInputStream in = new DataInputStream(c.getInputStream());
	new_fen = in.readLine();

	synchronized(this) {
	  if(!new_fen.equals(fen)) {
	    old_states.push(fen);
	    fen = new_fen;
	  }

	  display.getBoard().setFEN(fen);
	  pending_move = null;
	}

	try {
	  showStatus(in.readLine());
	} catch (IOException e) { ; }
      } catch (IOException e) {
	System.err.println("ChessPlayer.move: " + e);
      }
    }
  }
}

