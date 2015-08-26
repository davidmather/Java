// SlidePuzzle.java - Puzzle to slide pieces to correct position.
// Fred Swartz, 2003-May, 2004-May
//   The SlidePuzzle program consists of three files:
//   SlidePuzzle.java      - this file with main to create window.
//   SlidePuzzleGUI.java   - implements the GUI interface.
//   SlidePuzzleModel.java - the logical functioning.

import javax.swing.*;

///////////////////////////////////////////// class SlidePuzzle
class SlidePuzzle {
    //============================================= method main
    public static void showFrame(String string) {
 
        JFrame window = new JFrame("Slide Puzzle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new SlidePuzzleGUI());
        window.setDefaultLookAndFeelDecorated(true);
        window.pack();  // finalize layout
        window.show();  // make window visible
        window.setResizable(false);
    }//end main
    
    public static void main(String[] args) {
        
        showFrame(UIManager.getCrossPlatformLookAndFeelClassName());
        showFrame("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
}//endclass SlidePuzzle