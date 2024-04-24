/*This program draws points and "animates" them with the clock
 * @version 1.0
 * @date 4/24/24
 */
import java.awt.*; //graphics
import java.awt.event.*;
import java.util.Random; //Random functionality
import javax.swing.*; //Jpanel, JFrame, Timer

class Surface extends JPanel implements ActionListener{
  private final int DELAY = 150;
  private Timer timer;
  
  public Surface(){
    initTimer();
  }
  private void initTimer(){
  // A javax.swing.Timer is used to create animation. It fires ActionEvents at the specified interval (DELAY).
    timer = new Timer(DELAY, this);
    timer.start();
  }

  public Timer getTimer(){
    return timer;
  }
  private void doDrawing(Graphics g){
    
    Graphics2D g2d = (Graphics2D) g;

    g2d.setPaint(Color.blue);

    int w = getWidth();
    int h = getHeight();

    Random r = new Random();

    for(int i = 0; i < 50000; i++){
      int x = Math.abs(r.nextInt()) % w;
      int y = Math.abs(r.nextInt()) % h;
      g2d.drawLine(x, y, x, y);
    } 
  }
  @Override
  public void paintComponent(Graphics g) {
  
      super.paintComponent(g);
      doDrawing(g);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
      repaint();
  }
}

public class PointDrawing extends JFrame{
   
   public PointDrawing() {
   
      initUI();
   }
   
   private void initUI(){
     final Surface surface = new Surface();
     add(surface);

     addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
             Timer timer = surface.getTimer();
             timer.stop();
         }
     });
     setTitle("Points");
     setSize(350, 250);
     setLocationRelativeTo(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public static void main(String[]args){
   
      EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
   
          PointDrawing ex = new PointDrawing();
          ex.setVisible(true);
      }
     });
   }
}
