import javax.swing.*;
import java.io.*;

public class SaveThat {
    private static final String FILE_NAME = "levelData.txt";

    public static void saveLevel(int currentLevel) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)))) {
            out.println(currentLevel);
            JOptionPane.showMessageDialog(null, "Level saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving level: " + e.getMessage());
        }
    }
}
