import java.io.*; //see

public class GameSaveManager {
    private static final String SAVE_FILE_PATH = "savedata.dat";

    // Save game data to a file
    public static void saveGame(GameSaveData data) {
        try (FileOutputStream fileOut = new FileOutputStream(SAVE_FILE_PATH);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(data);
            System.out.println("Game data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving game data: " + e.getMessage());
        }
    }

    // Load game data from a file
    public static GameSaveData loadGame() {
        GameSaveData data = null;
        try (FileInputStream fileIn = new FileInputStream(SAVE_FILE_PATH);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            data = (GameSaveData) objectIn.readObject();
            System.out.println("Game data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading game data: " + e.getMessage());
        }
        return data;
    }
}
