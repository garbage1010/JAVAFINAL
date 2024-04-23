import java.awt.Graphics; // allows us to use graphics 
import java.awt.Graphics2D;
public class TestLevel { 
  public static void main (String [] args) { 


  }
  public void doDrawing(Graphics h)
  {
    Graphics2D g = (Graphics2D) h; 
    g.drawString("Hello", 10, 10); //write hello, place at (10,10) 
  }
}
