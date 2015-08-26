
import java.applet.*;
import java.awt.*;
import java.net.*;
import java.media.*;
public class PlayerApplet extends Applet implements ControllerListener {
    Player Player = null;
    public void init() {
          setLayout(new BorderLayout());
          String mediaFile = getParameter("FILE");
          try {
               URL mediaURL = new URL(getDocumentBase(),
                                       mediaFile);
               Player = Manager.createPlayer(mediaURL);
               Player.addControllerListener(this);
          } catch (Exception e) {
               System.err.println("Got exception "+e);
        }
    }
    public void start() {
          Player.start();
    }
    public void stop() {
          Player.stop();
          Player.deallocate();
    }
    public synchronized void controllerUpdate(ControllerEvent
                                               event) {
          if (event instanceof RealizeCompleteEvent) {
              Component comp;
          if ((comp = Player.getVisualComponent()) != null)
              add ("Center", comp);
          if ((comp = Player.getControlPanelComponent()) != null)
                add ("South", comp);	
          validate();
       }
    }
}