
package chess;

public final class Piece {

  public static final byte PAWN = 0;
  public static final byte KNIGHT = 1;
  public static final byte BISHOP = 2;
  public static final byte ROOK = 3;
  public static final byte QUEEN = 4;
  public static final byte KING = 5;    
  public static final byte BLACK = 0;
  public static final byte WHITE = 1;

  static private final char piece_names[][] = {
    { 'p', 'n', 'b', 'r', 'q', 'k' },
    { 'P', 'N', 'B', 'R', 'Q', 'K' }
  };

 
  public static final Piece p = new Piece('p');
  public static final Piece n = new Piece('n');
  public static final Piece b = new Piece('b');
  public static final Piece r = new Piece('r');
  public static final Piece q = new Piece('q');
  public static final Piece k = new Piece('k');
  public static final Piece P = new Piece('P');
  public static final Piece N = new Piece('N');
  public static final Piece B = new Piece('B');
  public static final Piece R = new Piece('R');
  public static final Piece Q = new Piece('Q');
  public static final Piece K = new Piece('K');

  private byte type;
  private byte color;

  public Piece(int type, int color) {
    if(type < 0 || type > KING) {
      throw new IllegalArgumentException("bad piece type");
    }
    if(color != BLACK && color != WHITE) {
      throw new IllegalArgumentException("bad piece color");
    }
    this.type = (byte) type;
    this.color = (byte) color;
  }

  public byte getType() { return type; }
  public byte getColor() { return color; }

  public char toChar() {
    return piece_names[color][type];
  }

  public String toString() {
    return String.valueOf(this.toChar());
  }

  public Piece(char name) throws IllegalArgumentException {
    byte t;
    byte c;

  escape:
    for(c = BLACK; c <= WHITE; c++) {
      for(t = PAWN; t <= KING; t++) {
	if(piece_names[c][t] == name) {
	  type = t;
	  color = c;
	  break escape;
	}
      }
    }
	  
    if(c > WHITE) {
      throw new IllegalArgumentException("bad piece name " + name);
    }
  }

  public boolean equals(Object p2) {
      return (p2 instanceof Piece
	      && type == ((Piece) p2).type
	      && color == ((Piece) p2).color);
  }
}
