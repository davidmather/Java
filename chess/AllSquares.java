
package chess;

import java.util.*;



public class AllSquares implements Enumeration {
  private byte rank;
  private byte file;

  public AllSquares() {
    rank = 0;
    file = 0;
  }

  public boolean hasMoreElements() {
    return rank < Board.SIZE;
  }

  public Square nextSquare() {
    Square s;

    if(!this.hasMoreElements()) {
      throw new NoSuchElementException();
    }
    
    /* else */
    s = new Square(rank, file);
    file++;
    if(file >= Board.SIZE) {
      file = 0;
      rank++;
    }

    return s;
  }
    
  public Object nextElement() { return this.nextSquare(); }
}

    
