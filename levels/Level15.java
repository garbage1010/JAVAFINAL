import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Level15 extends JFrame implements ActionListener, KeyListener {

    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Frame3-1redo.PNG");
    Image sprite = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Sprite.PNG");
    
    JLabel bg = new JLabel();
    int spriteX = 200;  // Initial X position of the sprite
    int spriteY = 200;  // Initial Y position of the sprite
    boolean movementAllowed = true; // Variable to control movement
    
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
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite, spriteX, spriteY, this);
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
                    break;
                case KeyEvent.VK_A:
                    spriteX -= 5;
                    break;
                case KeyEvent.VK_S:
                    spriteY += 5;
                    break;
                case KeyEvent.VK_D:
                    spriteX += 5;
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
