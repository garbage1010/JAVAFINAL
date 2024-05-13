import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimingMinigame {
    private boolean playable = true;
    private boolean reset = false;
    private Timer timer;

    public TimingMinigame() {
        timer = new Timer(1000, e -> {
            if (playable) {
                // Your logic for each second goes here
                // For example, update a JLabel to display the remaining time
            }
        });
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimingMinigame());
    }
}
