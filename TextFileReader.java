import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TextFileReader extends JFrame implements KeyListener {
    private JLabel label;
    private ArrayList<String> lines; // ArrayList to store lines from the text file
    private int currentIndex; // Index to keep track of current line
    private String filePath; // File path to read

    public TextFileReader(String filePath) {
        this.filePath = filePath; // Store the file path
        setTitle("Text File Reader");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();
        label.setFont(new Font("Arial", Font.PLAIN, 25));
        label.setForeground(Color.WHITE);
        add(label);

        lines = new ArrayList<>(); // Initialize ArrayList to store lines
        currentIndex = 0; // Initialize index to 0

        try (Scanner in = new Scanner(new File(filePath))) {
            ArrayList<String[]> wholeText = new ArrayList<>(); // ArrayList to store lines broken into words

            // read the file
            while (in.hasNextLine()) {
                // create temp variable to store a line
                String theLine = in.nextLine();
                // split the line on spaces 
                String[] words = theLine.split(" ");
                // add the array of strings to wholeText
                wholeText.add(words);
                // add the line to lines ArrayList (if you want to store lines as well)
                lines.add(theLine);
            }

            // Process words or wholeText ArrayList here if needed

            updateLabel(); // Update the label with the first line 
        } catch (IOException e) {
            e.printStackTrace();
        }

        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
    }

    // Method to update the label with the current line
    private void updateLabel() {
        if (currentIndex < lines.size()) {
            label.setText(lines.get(currentIndex)); // Set text of the label to current line
        } else {
            label.setText("End of file"); // Display message when end of file is reached
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            currentIndex++; // Move to the next line
            updateLabel(); // Update the label with the new line
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        // Provide the file path as a command-line argument or manually, delete when put in level class 
        String filePath = "input.txt";
        new TextFileReader(filePath);
    }
}