import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FadeOutOverlayPanel extends JPanel {
    private float opacity;
    private Timer fadeInTimer;
    private JComponent parent;

    public FadeOutOverlayPanel(JComponent parent) {
        this.opacity = 1.0f;
        this.parent = parent;
        setBounds(0, 0, parent.getWidth(), parent.getHeight());

        fadeInTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.05f; // Decrease opacity
                if (opacity <= 0) {
                    opacity = 0;
                    fadeInTimer.stop(); // Stop timer when fully transparent
                    parent.remove(FadeOutOverlayPanel.this); // Remove the overlay from the parent container
                    parent.revalidate(); // Revalidate the parent container
                    parent.repaint(); // Repaint the parent container to reflect changes
                }
                repaint(); // Repaint overlay with new opacity
            }
        });
        parent.add(this); // Add the overlay to the parent container
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

        JPanel menu = new JPanel();
        menu.setBounds(0, 0, 800, 600);
        menu.setLayout(null);
        frame.add(menu);

        frame.setVisible(true);

        new FadeOutOverlayPanel(menu);
    }
}
