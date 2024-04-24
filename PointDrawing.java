/*This program draws points and "animates" them with the clock
 * @version 1.0
 * @date 4/24/24
 */
import java.awt.*; //graphics
import java.util.*; //Random functionality
import javax.swing.*; //Jpanel, JFrame, Timer

class Surface extends JPanel implements ActionListener{
  private final int DELAY = 150;
  private Timer timer;
  
  public Surface(){
    initTimer();
  }

  public Timer getTimer(){
    return timer;
  }
  private void doDrawing(Graphics g){
    
    Graphics2D g2d = (Graphics2D) g;

    g2d.setPaint(Color.blue);

    int w = getWidth();
    
  }
  private initTimer(){
    // A javax.swing.Timer is used to create animation. It fires ActionEvents at the specified interval (DELAY).
      timer = new Timer(DELAY, this);
      timer.start();
  }
}
