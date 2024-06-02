import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ButtonMashingMinigame extends JPanel implements KeyListener, ActionListener {
    private Timer timer;
    private int timeLeft;
    private int mashCount;
    private boolean isRunning;
    private JLabel label;

    private static final int GAME_DURATION = 10; // Duration of the game in seconds
    private static final int TIMER_INTERVAL = 1000; // Timer interval in milliseconds

    public ButtonMashingMinigame() {
        setLayout(null);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        mashCount = 0;
        timeLeft = GAME_DURATION;

        label = new JLabel("Mash the Enter key!");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Agency FB", Font.PLAIN, 24));
        label.setBounds(100, 100, 600, 50);
        add(label);

        timer = new Timer(TIMER_INTERVAL, this);
    }

    public void startGame() {
        isRunning = true;
        mashCount = 0;
        timeLeft = GAME_DURATION;
        timer.start();
        requestFocusInWindow();
    }

    public void endGame() {
        isRunning = false;
        timer.stop();
        label.setText("Game Over! You mashed the button " + mashCount + " times.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timeLeft--;
        if (timeLeft <= 0) {
            endGame();
        } else {
            label.setText("Time left: " + timeLeft + " seconds. Mash count: " + mashCount);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (isRunning && e.getKeyCode() == KeyEvent.VK_ENTER) {
            mashCount++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public int getMashCount() {
        return mashCount;
    }
}
