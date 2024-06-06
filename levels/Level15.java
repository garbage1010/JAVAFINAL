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
    private JButton advanceButton; // Button to advance dialog at specific points
    private JButton q1Button;

    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Frame3-1redo.PNG");
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Frame3-2redo.PNG");
    Image q1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\q1.png");
    Image sprite = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Sprite.PNG");
    Image blondegone = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Frame3-4redo.PNG");

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

        // Initialize advance button
        advanceButton = new JButton("Next");
        advanceButton.setBounds(150, 300, 130, 50);
        advanceButton.setFont(new Font("Agency FB", Font.PLAIN, 20));
        advanceButton.setForeground(Color.WHITE);
        advanceButton.setBackground(Color.BLACK);
        advanceButton.setFocusPainted(false);
        advanceButton.setFocusable(false);
        advanceButton.setVisible(false); // Initially invisible
        advanceButton.addActionListener(this);
        //add(advanceButton); // Ensure the button is added to the frame

        q1Button = new JButton(new ImageIcon(q1));
        q1Button.setBounds(160, 335, 110, 120);
        q1Button.setVisible(false);
        q1Button.addActionListener(u -> {
            currentIndex++;
            updateLabel();
            allowprogress = true;
            remove(q1Button);
        });
        add(q1Button); // Ensure the button is added to the frame

        lines = new ArrayList<>(); // Initialize ArrayList to store lines
        currentIndex = 0; // Initialize index to 0

        // Hardcoded lines
        lines.add("Hey, Mr. Landa! I need help on my Calculus homework…");
        lines.add("Okay. Let me see.");
        lines.add("Thanks!");
        lines.add("No shame in asking for help.");
        lines.add("They asked me to go to the server room, better check it out.");
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
                //System.out.println("Sprite Position: " + spriteX + ", " + spriteY); // Debug print
                if (currentIndex == 0 && Math.abs(spriteX - 250) <= 50 && Math.abs(spriteY - 400) <= 50) {
                    movementAllowed = false;
                    allowprogress = true;
                    System.out.println("Position reached, movement stopped."); // Debug print
                    updateLabel();
                }
                if(currentIndex == 1){
                    bg.setIcon(new ImageIcon(q1));
                    //add(q1);
                    q1Button.setVisible(true);
                }
                if(currentIndex == 2){
                    bg.setIcon(new ImageIcon(blondegone));
                    allowprogress = true;
                }
                if (currentIndex == 4 && Math.abs(spriteX - 214) <= 75 && Math.abs(spriteY - 12) <= 50) {
                    allowprogress = false;
                    movementAllowed = false;
                    PreCalcPanic.increment();
                    SaveThat.saveLevel(2);
                    PreCalcPanic.timerChange();
                    System.exit(0);
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
        if (e.getSource() == advanceButton) {
            currentIndex++;
            updateLabel();
            allowprogress = true;
            remove(advanceButton); // Remove the advance button from the frame
            movementAllowed = true;
            if (currentIndex == 5) {
                movementAllowed = false;
                allowprogress = false;
            }
            repaint();
        }
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
        if (e.getKeyCode() == KeyEvent.VK_ENTER && allowprogress) {
            if (currentIndex == 0) {
                currentIndex++;
                updateLabel();
                allowprogress = false;
                movementAllowed = true;
            } else if (currentIndex == 1) {
                allowprogress = false;
                movementAllowed = false;
            } else if (currentIndex == 2) {
                //allowprogress = false;
                movementAllowed = true;
                currentIndex++;
                updateLabel();
            } else if (currentIndex == 3){
                currentIndex++;
                updateLabel();
                allowprogress = false;
            } else if (currentIndex == 4) {

                allowprogress = false;
                movementAllowed = true;
            } else if (currentIndex == 5) {
                allowprogress = false;
                movementAllowed = false;
            } else {
                currentIndex++;
                updateLabel();
            }
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
