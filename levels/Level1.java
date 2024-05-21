import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Level1 extends JFrame implements ActionListener {

    int framecounter = 1;
    int textcounter = 1;

    Timer timer;

    // Assuming TextFileReader is a valid class
    TextFileReader reader = new TextFileReader("levels\\images\\texts\\lv1dialogue.txt", 0, 600, 800, 200);

    // Images used
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-1.PNG");
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-2-1.PNG");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-2-2.PNG");
    Image frame4 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-2-3.png");
    Image frame5 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-3.png");
    Image frame6 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-4.png");

    JLabel bg = new JLabel(); // Label to be used as background
    JButton errorbutton = new JButton();

    // Constructor
    public Level1() {
        // Setup the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(null);
        setVisible(true);
        setResizable(false);

        // Setup background label
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));
        add(bg);

        // Add the reader button
        add(reader.getButton());

        // Start the timer
        startPolling();
    }

    private void startPolling() {
        timer = new Timer(500, e -> {
            try {
                int currentIndex = reader.currentIndex;
                switch (currentIndex) {
                    case 4:
                        updateFrame(reader, frame2, 385, 240, 30, 30, 5);
                        break;
                    case 5:
                        updateFrame(reader, frame3, 449, 351, 30, 30, 6);
                        break;
                    case 7:
                        updateFrame(reader, frame4, 441, 237, 50, 50, 8);
                        break;
                    case 8:
                        bg.setIcon(new ImageIcon(frame5));
                        timer.stop();
                        break;
                    case 9:
                        bg.setIcon(new ImageIcon(frame6));
                        timer.stop();
                        break;
                    default:
                        System.out.println(reader.currentIndex);
                }
            } catch (Error er) {
                System.out.println(er);
            }
        });
        timer.start();
    }

    private void updateFrame(TextFileReader reader, Image frame, int x, int y, int width, int height, int nextIndex) {
        timer.stop();
        reader.setProgress(false);
        bg.setIcon(new ImageIcon(frame));
        add(errorbutton);
        errorbutton.setBounds(x, y, width, height);
        errorbutton.addActionListener(l -> {
            reader.setProgress(true);
            reader.currentIndex = nextIndex;
            reader.updateLabel();
            remove(errorbutton);
            timer.start();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions if necessary
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Level1());
    }
}
