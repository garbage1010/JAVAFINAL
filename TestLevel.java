/*
 * This is a test of surface creation and drawing graphics onto the surfaces
 * @version 1.0
 * @date 4/23/24
 */
import java.awt.*; // allows us to use graphics 
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel{ //THis creates the panel or window that we draw on which we refer to as "surface" 
//by writing "extends JPanel" it means we allow methods from JPanel to beused
  private void doDrawing(Graphics g) {
    /*
     * FROM https://zetcode.com/gfx/java2d/introduction/ :
     * The Graphics2D class is a fundamental class for rendering graphics in Java 2D. 
     * It represents number of devices in a generic way. It extends the old Graphics object. 
     * This casting is necessary to get access to all advanced operations.
     */
    Graphics2D g2d = (Graphics2D) g; 
    g2d.drawString("Hello", 10, 10); //write hello, place at (10,10) using drawstring method
  }
  @Override //this prevents calling the Jpanel method paintcomponent
  public void paintComponent(Graphics g){ //this method makes it ready? it doesn't actually draw but this needs to be done prior to drawing
      super.paintComponent(g); //super means that we use the parent (JPanel) method. idk why we didn't do that in the first place but that's what the website jas
      //this is the method that draws
      doDrawing(g);
  }
}

public class TestLevel extends JFrame{ //extends jframe so we can use its' methods like settitle
  //constructor I guess? not sure why needed but website had it. Whatever 😒
  public TestLevel(){
    initUI();
  }
  private void initUI(){ //initializes the surface I think
    add( new Surface());
    setTitle("TEST LEVEL!!!!");
    setSize(500, 400);
    setLocationRelativeTo(null); //don't know what this does! 😁
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public static void main (String [] args) { 
    /* FROM WEBSITE:
     * We create an instance of our code example and make it visible on the screen. 
     * The invokeLater method places the application on the Swing Event Queue. 
     * It is used to ensure that all UI updates are concurrency-safe.
     */
      EventQueue.invokeLater(new Runnable(){

        @Override
        public void run(){
          TestLevel lvTest = new TestLevel();
            lvTest.setVisible(true);
        }
      });
  }
}
