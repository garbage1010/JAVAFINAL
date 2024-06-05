import javax.swing.*;
import java.io.*;

public class SaveThat {
    private static final String FILE_NAME = "levelData.txt";

    public static void saveLevel(int currentLevel) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)))) {
            out.println(currentLevel);
            System.out.println("level saved successfully."); 
        } catch (IOException e) {
            System.out.println(null, "Error saving level: " + e.getMessage());
        }
    }
}
