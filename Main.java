import java.io.*;

// This class represents the game save data
class GameSaveData implements Serializable {
    private int currLevel;
    
    // Constructor
    public GameSaveData(int level, int score) {
        this.playerLevel = level;
        this.playerScore = score;
    }
    
    // Getter and setter methods
    public int getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(int currLevel) {
        this.currLevel = currLevel;
    }

// This class handles saving and loading the game data
class GameSaveManager {
    private static final String SAVE_FILE_PATH = "savedata.dat";
    
    // Save game data to a file
    public static void saveGame(GameSaveData data) {
        try {
            FileOutputStream fileOut = new FileOutputStream(SAVE_FILE_PATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(data);
            objectOut.close();
            fileOut.close();
            System.out.println("Game data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving game data: " + e.getMessage());
        }
    }
    
    // Load game data from a file
    public static GameSaveData loadGame() {
        GameSaveData data = null;
        try {
            FileInputStream fileIn = new FileInputStream(SAVE_FILE_PATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            data = (GameSaveData) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Game data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading game data: " + e.getMessage());
        }
        return data;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage
        
        // Create some game data
        GameSaveData saveData = new GameSaveData(10, 5000);
        
        // Save the game data
        GameSaveManager.saveGame(saveData);
        
        // Load the game data
        GameSaveData loadedData = GameSaveManager.loadGame();
        
        // Display loaded game data
        if (loadedData != null) {
            System.out.println("Player level: " + loadedData.getPlayerLevel());
            System.out.println("Player score: " + loadedData.getPlayerScore());
            // Display more loaded data as needed
        }
    }
}
