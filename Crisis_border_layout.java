import java.awt.*;
import javax.swing.*;
public class Crisis_border_layout extends JFrame{
	JButton panicButton;
	JButton dontpanicButton;
	JButton blameButton;
	JButton mediaButton;
	JButton saveButton;
	public Crisis_border_layout()
	{
		super("Crisis_border_layout");
		setLookAndFeel();
		setSize(348,128);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout crisislayout=new BorderLayout();
		setLayout(crisislayout);
		panicButton=new JButton("panic");
		dontpanicButton=new JButton("Dont panic!");
		blameButton=new JButton("Blame others");
		mediaButton=new JButton("Notify the Media");
		saveButton=new JButton("Save Button");
		add(panicButton,BorderLayout.NORTH);
		add(dontpanicButton,BorderLayout.SOUTH);
		add(blameButton,BorderLayout.EAST);
		add(mediaButton,BorderLayout.WEST);
		add(saveButton,BorderLayout.CENTER);
		setVisible(true);
	}
	private void setLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception exc){
			//ignore error
		}	
	}
	public static void main(String[] arguments)
	{
		Crisis_border_layout cr= new Crisis_border_layout();		
	}
	
}