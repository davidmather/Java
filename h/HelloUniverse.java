package h;

import java.awt.*;
import javax.swing.*;

import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.ColorCube;
import javax.media.j3d.*;
import javax.vecmath.*;


public class HelloUniverse extends JFrame
{

  public HelloUniverse()
  {
    // create a Swing panel inside the JFrame
    JPanel p = new JPanel();
    p.setLayout( new BorderLayout() );
    p.setPreferredSize( new Dimension(250, 250) );
    getContentPane().add(p, BorderLayout.CENTER);

    // add the 3D canvas to panel
    Canvas3D c3d = createCanvas3D();
    p.add(c3d, BorderLayout.CENTER);

    // configure the window (JFrame)
    setTitle("HelloUniverse");
    setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    pack();
    setVisible(true);
  }  // end of HelloUniverse()



  private Canvas3D createCanvas3D()
  /* Build a 3D canvas holding a SimpleUniverse which contains
     our 3D scene (a rotating colored cube) */
  {
    // get the preferred graphics configuration for the default screen
    GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();

    // create a Canvas3D using the preferred configuration
    Canvas3D c3d = new Canvas3D(config);

    // create a simple universe
    SimpleUniverse univ = new SimpleUniverse(c3d);

    // move the camera back a bit so the cube can be seen
    univ.getViewingPlatform().setNominalViewingTransform();

    // ensure at least one redraw every 5 ms
    univ.getViewer().getView().setMinimumFrameCycleTime(5);

    // add the scene to the universe
    BranchGroup scene = createSceneGraph();
    univ.addBranchGraph(scene);

    return c3d;
  }  // end of createCanvas3D()


  public BranchGroup createSceneGraph()
  /* The scene graph is:
         scene ---> tg ---> colored cube
               |
               ---> rotator
  */
  { 
    BranchGroup scene = new BranchGroup();

    /* Create a TransformGroup node. Enable its TRANSFORM_WRITE 
       capability so it can be affected at run time */
    TransformGroup tg = new TransformGroup();
    tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    scene.addChild(tg);   // add to the scene 

    // connect a coloured cube to the TransformGroup
    tg.addChild( new ColorCube(0.4) );

    /* Create a rotation behaviour (a rotation interpolator) which will
       make the cube spin around its y-axis, taking 4 secs to do one
       rotation. */
    Transform3D yAxis = new Transform3D();
    Alpha rotationAlpha = new Alpha(-1, 4000);   // 4 secs
    RotationInterpolator rotator = 
                new RotationInterpolator(rotationAlpha, tg, 
                                    yAxis, 0.0f, (float) Math.PI*2.0f);
    rotator.setSchedulingBounds(
                         new BoundingSphere( new Point3d(0,0,0), 100.0) );
    scene.addChild(rotator);    // add to the scene

    // optimize the scene graph
    scene.compile();
    return scene;
  }  // end of createSceneGraph()



  // ------------------------------------------------------------

  public static void main(String args[])
  {  new HelloUniverse();  }
    
    
} // end of HelloUniverse class