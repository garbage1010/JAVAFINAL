import javax.swing.*;
import java.io.*;

public class LoadThat {
    private static final String FILE_NAME = "levelData.txt";

    public static int loadLevel() {
        try (BufferedReader in = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = in.readLine();
            if (line != null) {
                int currentLevel = Integer.parseInt(line);
                JOptionPane.showMessageDialog(null, "Level loaded successfully! Current Level: " + currentLevel);
                return currentLevel;
            } else {
                JOptionPane.showMessageDialog(null, "No level data found.");
                return 1; // Default level
            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error loading level: " + e.getMessage());
            return 1; // Default level
        }
    }
}
