
package chess;

import java.util.*;

public class Board extends Observable implements Mover {
  public static final int SIZE = 8;

  protected Piece b[][];

  public Board() {
    b = new Piece[SIZE][SIZE];
  }

  public Board(String fen) {
    this();

    this.setFEN(fen);
    this.clearChanged();
  }

  public Object clone() {
      int i;
      int j;

      Board b2 = new Board();
      for(i = 0; i < SIZE; i++) {
	  for(j = 0; j < SIZE; j++) {
	      b2.b[i][j] = this.b[i][j];
	  }
      }

      return b2;
  }

  public void setFEN(String fen) throws IllegalArgumentException {
    int file = 0;
    int rank = SIZE - 1;

    for(int p = 0;
	rank >= 0 && p < fen.length() && fen.charAt(p) != ' ';
	p++) {
      char c = fen.charAt(p);
      if(c == '/') {

	while(file < SIZE) {
	  b[rank][file++] = null;
	}
	rank--;
	file = 0;
      } else if(Character.isDigit(c)) {
	
	int skip = Character.digit(c, 10);
	for(int count = 0; count < skip; count++) {
	  if(file >= SIZE) {
	    break;
	  } else {
	    b[rank][file++] = null;
	  }
	}
      } else {

	b[rank][file++] = new Piece(c);
      }
    }

    if(rank >= 0) {
      while(file < SIZE) b[rank][file++] = null;
      while(--rank >= 0) {
	for(file = 0; file < SIZE; file++) {
	  b[rank][file] = null;
	}
      }
    }

    this.setChanged();
    this.notifyObservers();
  }

  public Piece pieceAt(Square s) {
    return b[s.getRank()][s.getFile()];
  }

  public void setPieceAt(Square s, Piece p) {
    b[s.getRank()][s.getFile()] = p;
    this.setChanged();
    this.notifyObservers(s);
  }

  public void move(Square from, Square to) {
      if(!from.equals(to)) {
	  Piece p = pieceAt(from);
	  setPieceAt(from, null);
	  setPieceAt(to, p);

	  
	  if(p.equals(Piece.K) && from.equals(Square.E1)) {
	      if(to.equals(Square.G1)) {
		 
		  move(Square.H1, Square.F1);
	      } else if(to.equals(Square.C1)) {
		  
		  move(Square.A1, Square.D1);
	      }
	  } else if(p.equals(Piece.k) && from.equals(Square.E8)) {
	      if(to.equals(Square.G8)) {
		
		  move(Square.H8, Square.F8);
	      } else if(to.equals(Square.C8)) {
	
		  move(Square.A8, Square.D8);
	      }
	  }
      }
  }
}
