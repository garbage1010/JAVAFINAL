import java.io.Serializable;

public class GameSaveData implements Serializable {
    private static final long serialVersionUID = 1L;

    private int playerLevel;

    // Constructor
    public GameSaveData(int level) {
        this.playerLevel = level;
    }

    // Getter and setter methods
    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }
}
