import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TextFileReader implements KeyListener {
    private ArrayList<String> lines; // ArrayList to store lines from the text file
    public int currentIndex; // Index to keep track of current line
    public boolean allowprogress = true;
    private String filePath; // File path to read
    
    // Make text box button
    private JButton text = new JButton();

    public TextFileReader(String filePath, int x, int y, int dx, int dy) {
        this.filePath = filePath; // Store the file path

        // Button characteristics 
        text.setBounds(x, y, dx, dy); 
        text.setFont(new Font("Agency FB", Font.PLAIN, 20));
        text.setForeground(Color.WHITE);
        text.setBackground(Color.BLACK);
        text.setFocusPainted(false);
        text.setFocusable(false);

        lines = new ArrayList<>(); // Initialize ArrayList to store lines
        currentIndex = 0; // Initialize index to 0

        try (Scanner in = new Scanner(new File(filePath))) {
            // Read the file
            while (in.hasNextLine()) {
                // Add the line to lines ArrayList
                lines.add(in.nextLine());
            }

            // Update the button with the first line
            updateLabel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        text.addKeyListener(this);
        text.setFocusable(true);
    }

    // Method to update the button text with the current line
    public void updateLabel() {
        if (currentIndex < lines.size()) {
            text.setText(lines.get(currentIndex)); // Set text of the button to current line
        } else {
            text.setText("End of file"); // Display message when end of file is reached
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && allowprogress) {
            currentIndex++; // Move to the next line
            updateLabel(); // Update the button with the new line
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    // Method to get the button for adding to a container
    public JButton getButton() {
        return text;
    }
    
    public void setProgress(boolean allowprogress){
        this.allowprogress = allowprogress;
    }

    public static void main(String[] args) {
        // Example usage
        JFrame frame = new JFrame("Text File Reader");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        TextFileReader reader = new TextFileReader("example.txt", 50, 50, 500, 50);
        frame.add(reader.getButton());

        frame.setVisible(true);
    }
}
