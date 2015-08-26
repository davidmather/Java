import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
public class LinkRotator extends JApplet implements Runnable, ActionListener{
	String[] pageTitle=new String[6];
	URL[] pageLink=new URL[6];
	Color butterscotch=new Color(255,204,156);
	int Current=0;
	Thread runner;
	public void init(){
		pageTitle=new String[]{
		"Sun's Java site",
		"Cafe au Lait",
		"JavaWorld",
		"Java in 24 Hours",
		"Sams Publishing",
		"Workbench"
		};
		pageLink[0]=getURL("http://java.sun.com");
		pageLink[1]=getURL("http://www.ibiblio.org/javafaq");
		pageLink[2]=getURL("http://www.javaworld.com");
		pageLink[3]=getURL("http://www.java24hours.com");
		pageLink[4]=getURL("http://www.samspublishing.com");
		pageLink[5]=getURL("http://workbench.cadenheart.org");
		Button goButton=new Button("Go");
		goButton.addActionListener(this);
		FlowLayout flow=new FlowLayout();
		setLayout(flow);
		add(goButton);
	}
	URL getURL(String urlText){
		URL pageURL=null;
		try{
			pageURL=new URL(getDocumentBase(), urlText);
		}catch(MalformedURLException m){ }
		return pageURL;
	}
	public void paint(Graphics screen){
		Graphics2D screen2D=(Graphics2D) screen;
		screen2D.setColor(butterscotch);
		screen2D.fillRect(0, 0, getSize().width, getSize().height);
		screen2D.setColor(Color.black);
		screen2D.drawString(pageTitle[Current],5,60);
		screen2D.drawString("                                    "+pageLink[Current],5,60);
	}
	public void start()
	{
		if(runner==null){
			runner=new Thread(this);
			runner.start();
		}
	}
	public void run(){
		Thread thisThread=Thread.currentThread();
		while(runner==thisThread){
			Current++;
			if(Current>5){
				Current=0;
			}
			repaint();
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				//do nothing
			}
		}
	}
	public void stop()
	{
		if(runner!=null){
			runner=null;
		}
	}
	public void actionPerformed(ActionEvent event){
		if(runner !=null){
			runner=null;
		}
		AppletContext browser=getAppletContext();
		if(pageLink[Current]!=null){
			browser.showDocument(pageLink[Current]);
		}
	}
}
