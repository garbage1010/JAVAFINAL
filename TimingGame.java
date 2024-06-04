import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimingGame extends JFrame implements ActionListener {

    private JButton button; // Button that the player interacts with
    private Timer timer; // Timer to change the button's state
    private boolean isGreen = false; // Flag to track if the button is green

    public TimingGame() {
        // Create the button
        button = new JButton("Wait...");
        button.setFont(new Font("Agency FB", Font.BOLD, 20));
        button.setBackground(Color.RED);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.addActionListener(this);

        // Add button to the frame
        add(button, BorderLayout.CENTER);

        // Set up the timer to change the button color
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Randomly change button color and text
                if (Math.random() < 0.5) {
                    button.setBackground(Color.GREEN);
                    button.setText("TAKE THE SHOT!");
                    isGreen = true;
                } else {
                    button.setBackground(Color.RED);
                    button.setText("Wait...");
                    isGreen = false;
                }
            }
        });

        // Start the timer
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the button is green when pressed
        if (isGreen) {
            JOptionPane.showMessageDialog(this, "You win!");
        } else {
            JOptionPane.showMessageDialog(this, "Game Over! You pressed too soon.");
        }
        // Restart the game
        resetGame();
    }

    private void resetGame() {
        // Reset button to red and update text
        isGreen = false;
        button.setBackground(Color.RED);
        button.setText("Wait...");
    }

    // Example usage 
    public static void main(String[] args) {
        // Ensure the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TimingGame();
            }
        });
    }
}

