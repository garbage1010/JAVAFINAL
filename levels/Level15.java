import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Level15 extends JFrame implements ActionListener, KeyListener {

    ArrayList<String> lines; // ArrayList to store hardcoded lines
    public int currentIndex; // Index to keep track of the current line
    public boolean allowprogress = false;
    private JButton textButton; // Button to display text

    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Frame3-1redo.PNG");
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Frame3-2redo.PNG");
    Image sprite = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Sprite.PNG");

    Timer posTimer;

    JLabel bg = new JLabel();
    int spriteX = 200;  // Initial X position of the sprite
    int spriteY = 200;  // Initial Y position of the sprite
    final int SPEED = 10;

    boolean movementAllowed = true; // Variable to control movement
    double angle = 0; // Angle to rotate the sprite

    public Level15() {
        // Setup frame
        bg.setIcon(new ImageIcon(frame2));
        bg.setBounds(0, 0, 430, 560);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 760);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        add(bg);

        // Initialize text button
        textButton = new JButton();
        textButton.setBounds(0, 560, 430, 200);
        textButton.setFont(new Font("Agency FB", Font.PLAIN, 20));
        textButton.setForeground(Color.WHITE);
        textButton.setBackground(Color.BLACK);
        textButton.setFocusPainted(false);
        textButton.setFocusable(true); // Allow the button to gain focus to receive key events
        textButton.addKeyListener(this);
        add(textButton);
        textButton.requestFocusInWindow(); // Request focus for the button

        lines = new ArrayList<>(); // Initialize ArrayList to store lines
        currentIndex = 0; // Initialize index to 0

        // Hardcoded lines
        lines.add("Hey, Mr. Landa! I need help on my Calculus homework…");
        lines.add("Okay. Let me see.");
        lines.add("Thanks!");
        lines.add("No shame in asking for help.");
        lines.add("Mr. Landa! Mr. Landa!");
        lines.add("What?");
        lines.add("My program keeps saying “SyntaxError: missing curly bracket”. Can you fix it?");
        lines.add("THIS is why I tell you to comment them. THIS.");
        lines.add("Sorry…");
        lines.add("All you need to do is type in the number of the line where the bracket is missing.");

        // Update the button with the first line
        updateLabel();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false); // Disable default focus traversal keys

        posCheck();
    }

    private void updateLabel() {
        System.out.println("Updating label. Current index: " + currentIndex); // Debug print
        if (currentIndex < lines.size()) {
            textButton.setText(lines.get(currentIndex)); // Set text of the button to the current line
        } else {
            textButton.setText("End of dialog"); // Display message when the end of the dialog is reached
        }
        System.out.println("Label updated to: " + textButton.getText()); // Debug print
    }

    private void posCheck() {
        posTimer = new Timer(250, e -> {
            try {
                System.out.println("Sprite Position: " + spriteX + ", " + spriteY); // Debug print
                if (Math.abs(spriteX - 250) <= 50 && Math.abs(spriteY - 400) <= 50) {
                    movementAllowed = false;
                    posTimer.stop();
                    allowprogress = true;
                    System.out.println("Position reached, movement stopped."); // Debug print
                    updateLabel();
                }
            } catch (Exception ge) {
                System.out.println("Error: " + ge);
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
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER && allowprogress) {
            System.out.println("Enter key pressed. Current index: " + currentIndex); // Debug print
            currentIndex++; // Move to the next line
            updateLabel(); // Update the button with the new line
            System.out.println("Index after pressing Enter: " + currentIndex); // Debug print
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key released events if necessary
    }

    public static void main(String[] args) {
        new Level15();
    }
}
