
import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.net.*;
import java.util.*;
import chess.*;

public class ChessBoard extends Applet {
  public String getAppletInfo() {
    return "Chessboard Applet";
  }

  Display display;

  public void init() {
      MediaTracker tracker = new MediaTracker(this);
      int size;
      Image palette;

      try {
	  size = Integer.parseInt(getParameter("size"));
      } catch (NumberFormatException e) {
	  this.showStatus("Bad or missing SIZE parameter");
	  return;
      }

      /* load up palette */
      String palette_name = getParameter("palette");
      if(palette_name == null) {
	  this.showStatus("Missing PALETTE parameter");
	  return;
      }

      palette = getImage(getDocumentBase(), palette_name);

      this.showStatus("Loading piece images from " + palette_name);

      tracker.addImage(palette, 0);
      try { tracker.waitForID(0); } catch (InterruptedException e) { ; }

      if(tracker.isErrorID(0)) {
	  this.showStatus("Error loading " + palette_name + "--- giving up!");
	  return;
      }

      int[] sq_rgb = new int[2];
      int[] piece_rgb = new int[2];

      try {
      sq_rgb[0] = Integer.parseInt(getParameter("dark"), 16) + 0xff000000;
      }
      catch (Exception e) {
      sq_rgb[0] = 0xff77a26d;
      }

      try {
      sq_rgb[1] = Integer.parseInt(getParameter("light"), 16) + 0xff000000;
      }
      catch (Exception e) {
      sq_rgb[1] = 0xffc8c365;
      }

      try {
      piece_rgb[0] = Integer.parseInt(getParameter("black"), 16) + 0xff000000;
      }
      catch (Exception e) {
      piece_rgb[0] = 0xff202020;
      }

      try {
      piece_rgb[1] = Integer.parseInt(getParameter("white"), 16) + 0xff000000;
      }
      catch (Exception e) {
      piece_rgb[1] = 0xffffffcc;
      }

      /* else we got it */
      /* build the Display */
      display = new Display(palette, size, sq_rgb, piece_rgb);
      this.add(display);

      /* create board */
      reset();
  }

  public void reset() {
      /* create the board and load up fen */
      String fen = getParameter("fen");
      if(fen != null) {
	  display.setBoard(new Board(fen));
      }
  }
}

