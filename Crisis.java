import java.awt.*;
import javax.swing.*;
public class Crisis extends JFrame{
	JButton panicButton;
	JButton dontpanicButton;
	JButton blameButton;
	JButton mediaButton;
	JButton saveButton;
	public Crisis()
	{
		super("Crisis");
		setLookAndFeel();
		setSize(348,128);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid=new GridLayout(1,5);
		setLayout(grid);
		panicButton=new JButton("panic");
		dontpanicButton=new JButton("Dont panic!");
		blameButton=new JButton("Blame others");
		mediaButton=new JButton("Notify the Media");
		saveButton=new JButton("Save Button");
		add(panicButton);
		add(dontpanicButton);
		add(blameButton);
		add(mediaButton);
		add(saveButton);
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
		Crisis cr= new Crisis();		
	}
	
}
