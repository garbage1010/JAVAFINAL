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
  private initTimer(){
    
      timer = new Timer(DELAY, this);
      timer.start();
  }
}
