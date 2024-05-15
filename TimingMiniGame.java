import java.awt.*;
import java.awt.event.*;

public class TimingMiniGame extends Frame implements KeyListener {
    private int targetX = 300; // X-coordinate of the target circle, can be changed
    private int targetY = 300; // Y-coordinate of the target circle, can be changed 
    private int targetRadius = 50; // Radius of the target circle
    private int movingX = 100; // Initial X-coordinate of the moving circle, can be changed
    private int movingY = 100; // Initial Y-coordinate of the moving circle, can be changed
    private int movingRadius = 50; // Radius of the moving circle
    private int step = 1; // Step by which the moving circle moves towards the target
    private boolean gameOver = false; // Flag to indicate game over
    private boolean match = false; // Flag to indicate whether the moving circle matches the target

    public TimingMiniGame() {
        setSize(600, 600);
        setTitle("Timing Mini Game");
        addKeyListener(this);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        // Start the game loop
        new Thread(() -> {
            while (!gameOver) {
                moveCircle();
                repaint();
                try {
                    Thread.sleep(20); // Adjust the speed of the moving circle
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void paint(Graphics g) {
        if (!match) {
            // Draw target circle
            g.setColor(Color.BLUE);
            g.fillOval(targetX - targetRadius, targetY - targetRadius, 2 * targetRadius, 2 * targetRadius);

            // Draw moving circle
            g.setColor(Color.RED);
            g.fillOval(movingX - movingRadius, movingY - movingRadius, 2 * movingRadius, 2 * movingRadius);
        } else {
            g.drawString("Congratulations! You matched the circles!", 200, 300);
        }
    }

    public void moveCircle() {
        if (!match) {
            // Move the moving circle towards the target
            if (movingX < targetX)
                movingX += step;
            else if (movingX > targetX)
                movingX -= step;

            if (movingY < targetY)
                movingY += step;
            else if (movingY > targetY)
                movingY -= step;

            // Check if moving circle matches target circle
            if (Math.abs(movingX - targetX) <= 5 && Math.abs(movingY - targetY) <= 5) {
                match = true;
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        // Check if space bar is pressed and moving circle matches target circle
        if (e.getKeyCode() == KeyEvent.VK_SPACE && match) {
            gameOver = true;
            // Placeholder event 
            System.out.println("Congratulations! You matched the circles!");
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        // Example usage, call in level 3
        new TimingMiniGame();
    }
}
