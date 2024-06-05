import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

public class Level15 extends JFrame implements ActionListener, KeyListener {

    TextFileReader reader = new TextFileReader("levels\\images\\texts\\halldialogue.txt", 0, 560, 430, 200);

    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Frame3-1redo.PNG");
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Frame3-2redo.PNG");
    Image sprite = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Sprite.PNG");

    Timer posTimer;
    Timer timer;
    
    JLabel bg = new JLabel();
    int spriteX = 200;  // Initial X position of the sprite
    int spriteY = 200;  // Initial Y position of the sprite
    final int SPEED = 10;

    boolean movementAllowed = true; // Variable to control movement
    double angle = 0; // Angle to rotate the sprite

    public Level15(){
        bg.setIcon(new ImageIcon(frame1));
        bg.setBounds(0,0,430,560);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 760);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        add(bg);
        add(reader.getButton());
        
        addKeyListener(this);
        setFocusable(true);
        posCheck();
        startPolling();
    }

    private void posCheck(){
        posTimer = new Timer(250, e-> {
            try{
                //System.out.println("Sprite Position: " + spriteX + ", " + spriteY); // Debug print
                if (Math.abs(spriteX - 250) <= 50 && Math.abs(spriteY - 400) <= 50) {
                    movementAllowed = false;
                    posTimer.stop();
                    reader.setProgress(false);
                    System.out.println("Position reached, movement stopped."); // Debug print
                }
            }
            catch(Exception ge){
                System.out.println("Error: " + ge);
            }
        });
        posTimer.start();
    }

    private void startPolling(){
        timer = new Timer(500, e-> {
            try{
                switch(reader.currentIndex){
                    case 2:
                        // Handle any specific actions needed for reader index 2
                        break;
                    default:
                        break;
                }
            }
            catch(Exception ge){
                System.out.println("Error: " + ge);
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform transform = new AffineTransform();
        transform.translate(spriteX + sprite.getWidth(this) / 2, spriteY + sprite.getHeight(this) / 2);
        transform.rotate(Math.toRadians(angle));
        transform.translate(-sprite.getWidth(this) / 2, -sprite.getHeight(this) / 2);
        g2d.drawImage(sprite, transform, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events if necessary
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed events if necessary
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (movementAllowed) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_W:
                    spriteY -= SPEED;
                    angle = 0;
                    break;
                case KeyEvent.VK_A:
                    spriteX -= SPEED;
                    angle = -90;
                    break;
                case KeyEvent.VK_S:
                    spriteY += SPEED;
                    angle = 180;
                    break;
                case KeyEvent.VK_D:
                    spriteX += SPEED;
                    angle = 90;
                    break;
            }
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key released events if necessary
    }

    public static void main(String[] args){
        new Level15();
    }
}
