import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FadeOutOverlay extends JLabel {
    private float opacity;
    private Timer fadeInTimer;

    public FadeOutOverlayLabel(JLabel label) {
        this.opacity = 1.0f;
        setBounds(0, 0, label.getWidth(), label.getHeight());
        setOpaque(false);

        fadeInTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.05f; // Decrease opacity
                if (opacity <= 0) {
                    opacity = 0;
                    fadeInTimer.stop(); // Stop timer when fully transparent
                    Container parent = getParent();
                    if (parent != null) {
                        parent.remove(FadeOutOverlayLabel.this); // Remove the overlay from the parent container
                        parent.revalidate(); // Revalidate the parent container
                        parent.repaint(); // Repaint the parent container to reflect changes
                    }
                }
                repaint(); // Repaint overlay with new opacity
            }
        });

        label.add(this); // Add the overlay to the label's parent container
        fadeInTimer.start(); // Start the fade-in effect
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0, (int) (opacity * 255)));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Hello, World!");
        label.setBounds(0, 0, 800, 600);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        frame.add(label);

        frame.setVisible(true);

        new FadeOutOverlayLabel(label);
    }
}
