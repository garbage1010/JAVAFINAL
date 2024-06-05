import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SaveAndLoad {
    private static int currentLevel = 1;
    private static final String FILE_NAME = "levelData.txt";

    public static void main(String[] args) {

        // Create Save button
        JButton saveButton = new JButton("Save Level");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveLevel();
            }
        });
        panel.add(saveButton);

        // Create Load button
        JButton loadButton = new JButton("Load Level");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadLevel();
            }
        });
        panel.add(loadButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    private static void saveLevel() {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)))) {
            out.println(currentLevel);
            JOptionPane.showMessageDialog(null, "Level saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving level: " + e.getMessage());
        }
    }

    private static void loadLevel() {
        try (BufferedReader in = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = in.readLine();
            if (line != null) {
                currentLevel = Integer.parseInt(line);
                System.out.println(null, "Level loaded successfully! Current Level: " + currentLevel);
            } else {
                System.out.println(null, "No level data found.");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(null, "Error loading level: " + e.getMessage());
        }
    }
}
