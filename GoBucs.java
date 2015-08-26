import java.awt.*;
import javax.swing.*;
public class GoBucs extends JPanel{
Color lightOrange=new Color(230,220,0);
Color darkRed=new Color(235,50,50);
public void paintComponent(Graphics comp){
Graphics2D comp2D=(Graphics2D)comp;
comp2D.setColor(darkRed);
comp2D.fillRect(0,0,200,100);
comp2D.setColor(lightOrange);
comp2D.drawString("Go Bucaneers!",5,50);
}
}