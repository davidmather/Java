import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class keyviewer extends JFrame implements KeyListener
{
	JTextField keytext=new JTextField(80);
	JLabel keyLabel=new JLabel("Press any key in the text field.");
	keyviewer()
	{
		super("keyviewer");
		setLookAndFeel();
		setSize(350,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keytext.addKeyListener(this);
		BorderLayout bord=new BorderLayout();
		setLayout(bord);
		add(keyLabel,BorderLayout.NORTH);
		add(keytext,BorderLayout.CENTER);
		setVisible(true);
	}
	public void keyTyped(KeyEvent input){
		char key=input.getKeyChar();
		keyLabel.setText("You pressed "+key);
		
	}
	public void keyPressed(KeyEvent txt){
		//do nothing
		
	}
	public void keyReleased(KeyEvent txt){
		//do nothing
		
	}
	private void setLookAndFeel(){
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception exc){
			//ignore error
		}	
		
	}
	public static void main(String[] arguments){
		keyviewer frame=new keyviewer();
		
	}
}
