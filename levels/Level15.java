import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

public class Level15 extends JFrame implements ActionListener, KeyListener {

    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Frame3-1redo.PNG");
    Image sprite = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Sprite.PNG");

    Timer posTimer;
    
    JLabel bg = new JLabel();
    int spriteX = 200;  // Initial X position of the sprite
    int spriteY = 200;  // Initial Y position of the sprite
    boolean movementAllowed = true; // Variable to control movement
    double angle = 0; // Angle to rotate the sprite

    public Level15(){
        bg.setIcon(new ImageIcon(frame1));
        bg.setBounds(0,0,430,564);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 564);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        add(bg);
        
        addKeyListener(this);
        setFocusable(true);
    }

    private void posCheck(){
        posTimer = new Timer(250, e-> {
            try{
                //switch(){

                }

            catch(Exception ge){
                System.out.println("Error" +ge);
            }
        });
        posTimer.start();
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

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (movementAllowed) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_W:
                    spriteY -= 5;
                    angle = 0;
                    break;
                case KeyEvent.VK_A:
                    spriteX -= 5;
                    angle = -90;
                    break;
                case KeyEvent.VK_S:
                    spriteY += 5;
                    angle = 180;
                    break;
                case KeyEvent.VK_D:
                    spriteX += 5;
                    angle = 90;
                    break;
            }
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args){
        new Level15();
    }
}
