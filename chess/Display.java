
package chess;

import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class Display extends Canvas implements Observer {
    public Mover mover;	

    private Board board;

    private boolean flip; 

    private int size;	
    private Image palette;

    private Image[][][] pieces;
   
    private Image[] empty;

    private int sq_rgb[];
    private int piece_rgb[];

    private Image recolor(Image i, int black, int white) {
	ImageFilter color = new BW2ColorFilter(black, white);
	ImageProducer p = new FilteredImageSource(i.getSource(), color);
	return this.createImage(p);
    }


    private void break_palette(byte sq_color, byte piece_color) {
	byte p;
	ImageFilter color =
	    new BW2ColorFilter(sq_rgb[sq_color], piece_rgb[piece_color]);
	ImageProducer colored =
	    new FilteredImageSource(palette.getSource(), color);

	pieces[sq_color][piece_color] = new Image[Piece.KING+1];

	for(p = Piece.PAWN; p <= Piece.KING; p++) {
	    ImageFilter crop = new CropImageFilter(size * p, 0, size, size);
	    ImageProducer prod = new FilteredImageSource(colored, crop);
	    pieces[sq_color][piece_color][p] = this.createImage(prod);
	}
    }

    public Board getBoard() {
	return board;
    }

    public void setBoard(Board b) {
	if(board != null) {
	    board.deleteObserver(this);
	}
	board = b;
	board.addObserver(this);
	flip = false;
	this.repaint();
    }

	public void flip() {
	flip = !flip;
	this.repaint();
	}

    public Display(Image palette, int size, int[] sq_rgb, int[] piece_rgb) {
	this.flip = false;

	this.palette = palette;
	this.size = size;

	this.sq_rgb = sq_rgb;
	this.piece_rgb = piece_rgb;

	pieces = new Image[2][2][];

	
	break_palette(Square.LIGHT, Piece.WHITE);
	break_palette(Square.LIGHT, Piece.BLACK);
	break_palette(Square.DARK, Piece.WHITE);
	break_palette(Square.DARK, Piece.BLACK);


	empty = new Image[2];
	empty[Square.DARK] =
	    recolor(pieces[Square.DARK][Piece.BLACK][Piece.PAWN],
		    sq_rgb[Square.DARK], sq_rgb[Square.DARK]);
	empty[Square.LIGHT] =
	    recolor(pieces[Square.LIGHT][Piece.BLACK][Piece.PAWN],
		    sq_rgb[Square.LIGHT], sq_rgb[Square.LIGHT]);

	this.resize(this.preferredSize());
	this.repaint();
    }

    private void paintSquare(Graphics g, Square sq) {

	int x = sq.getFile() * size;
	int y = ((Board.SIZE - 1) - sq.getRank()) * size;

	if (flip) {
	  x = (Board.SIZE - 1) * size - x;
	  y = (Board.SIZE - 1) * size - y;
	}

	Piece p;

	if(board == null || (p = board.pieceAt(sq)) == null) {

	    g.drawImage(empty[sq.color()], x, y, this);
	} else {

	    g.drawImage(pieces[sq.color()][p.getColor()][p.getType()],
			x, y, this);
	}
    }

    public Dimension preferredSize() {
	return new Dimension(Board.SIZE * size, Board.SIZE * size);
    }

    public Dimension minimumSize() { return preferredSize(); }

    public void update(Graphics g) {

	AllSquares as = new AllSquares();

	while(as.hasMoreElements()) {
	    Square s = as.nextSquare();

	    paintSquare(g, s);
	}
    }

    public void paint(Graphics g) { this.update(g); }

    public void update(Observable obs, Object arg) {

	if(obs == board) {
	    if(arg == null) {
		this.repaint();
	    } else {
		Square s = (Square) arg;
		paintSquare(this.getGraphics(), s);
	    }
	}
    }

    private Square move_from;

    public boolean mouseDown(Event e, int x, int y) {
      if(x >= 0 && x < Board.SIZE * size
	 && y >= 0 && y < Board.SIZE * size) {
	if(!flip) {
	move_from = new Square((Board.SIZE - 1) - (y / size), x / size);
	} else {
	move_from = new Square(y / size, (Board.SIZE - 1) - (x / size));
	}
	if(getBoard().pieceAt(move_from) == null) {
	  move_from = null;
	  return false;
	} else {
	  return true;
	}
      } else {
	return false;
      }
    }

    public boolean mouseUp(Event e, int x, int y) {
	if(move_from != null
	   && x >= 0 && x < Board.SIZE * size
	   && y >= 0 && y < Board.SIZE * size) {
	    Square move_to;
		if(!flip) {
		move_to = new Square((Board.SIZE - 1) - (y / size), x / size);
		} else {
		move_to = new Square(y / size, (Board.SIZE - 1) - (x / size));
		}
		mover.move(move_from, move_to);
		return true;
	} else {
	    return false;
	}
    }
}

class BW2ColorFilter extends RGBImageFilter {
  private int black;
  private int white;

  public BW2ColorFilter(int black, int white) {
    canFilterIndexColorModel = true;
    this.black = black;
    this.white = white;
  }

  public int filterRGB(int x, int y, int rgb) {
    rgb = rgb & 0x00ffffff;
    if(rgb != 0) {
      return white;
    } else {
      return black;
    }
  }
}
