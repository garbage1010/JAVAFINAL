import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
class TextFileReader implements KeyListener {
    ArrayList<String> lines; // ArrayList to store lines from the text file
    public int currentIndex; // Index to keep track of the current line
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
        text.setFocusable(true); // Allow the button to gain focus to receive key events

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
    }

    // Method to update the button text with the current line
    public void updateLabel() {
        System.out.println("Updating label. Current index: " + currentIndex); // Debug print
        if (currentIndex < lines.size()) {
            text.setText(lines.get(currentIndex)); // Set text of the button to the current line
        } else {
            text.setText("End of file"); // Display message when the end of the file is reached
        }
        System.out.println("Label updated to: " + text.getText()); // Debug print
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && allowprogress) {
            System.out.println("Enter key pressed. Current index: " + currentIndex); // Debug print
            currentIndex++; // Move to the next line
            updateLabel(); // Update the button with the new line
            System.out.println("Index after pressing Enter: " + currentIndex); // Debug print
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

    public void setProgress(boolean allowprogress) {
        this.allowprogress = allowprogress;
        System.out.println("Allow progress set to: " + allowprogress); // Debug print
    }
}
