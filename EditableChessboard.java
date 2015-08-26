
import java.applet.*;
import java.awt.*;
import chess.*;


public class EditableChessboard extends Chessboard implements Mover {
    public void init() {
	super.init();

	display.mover = this;
    }

    public boolean keyDown(Event e, int key) {
	if(e.id == Event.KEY_PRESS && ((char) key) == 'r') {
	    this.reset();
	    return true;
	}

	return false;
    }	    

    public void move(Square from, Square to) {
	display.getBoard().move(from, to);
    }
}
