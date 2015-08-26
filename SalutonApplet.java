import java.awt.*;
public class SalutonApplet extends javax.swing.JApplet {
	String greeting;
	
	public void init(){
		greeting="Saluton Mondo!";
	}
	public void paint(Graphics screen){
		Graphics2D screen2D=(Graphics2D) screen;
		screen2D.drawString(greeting, 25, 50);
		
	}
}
