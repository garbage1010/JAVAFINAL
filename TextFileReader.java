import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader extends JFrame implements KeyListener {
    private JLabel label; // JLabel to display text
    private BufferedReader reader; // BufferedReader to read lines from the text file
    private String currentLine; // String to store the current line being read

    // Constructor to initialize the JFrame and set up the UI
    public TextFileReader() {
        setTitle("Text File Reader"); // Set the title of the JFrame
        setSize(400, 300); // Set the size of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation

        label = new JLabel(); // Initialize the JLabel
        label.setFont(new Font("Cambria", Font.PLAIN, 40)); // Set font of the JLabel
        label.setForeground(Color.WHITE); // Set text color of the JLabel to white
        add(label); // Add JLabel to the JFrame

        try {
            // Create BufferedReader to read from the text file
            reader = new BufferedReader(new FileReader("input.txt"));
            currentLine = reader.readLine(); // Read the first line from the text file
            label.setText(currentLine); // Set the text of the JLabel to the first line
        } catch (IOException e) {
            e.printStackTrace();
        }

        addKeyListener(this); // Add KeyListener to the JFrame to listen for key events
        setFocusable(true); // Set the JFrame to be focusable
        setVisible(true); // Make the JFrame visible
    }

    // Method called when a key is pressed
    public void keyPressed(KeyEvent e) {
        // Check if the pressed key is Enter
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                currentLine = reader.readLine(); // Read the next line from the text file
                if (currentLine != null) {
                    label.setText(currentLine); // Set the text of the JLabel to the next line
                } else {
                    // End of file reached, exit the program
                    System.exit(0);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Unused method from the KeyListener interface
    public void keyTyped(KeyEvent e) {}

    // Unused method from the KeyListener interface
    public void keyReleased(KeyEvent e) {}

    // Main method to start the application, in this case we'd just call a method similar to this in the lvl class I THINK
    public static void main(String[] args) {
        new TextFileReader(); // Create an instance of TextFileReader
    }
}
