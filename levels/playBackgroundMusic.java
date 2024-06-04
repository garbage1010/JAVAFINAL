import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

    public static void playBackgroundMusic(String filePath) {
        try {
            // Open an audio input stream
            File musicFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);

            // Get a sound clip resource
            Clip clip = AudioSystem.getClip();

            // Open audio clip and load samples from the audio input stream
            clip.open(audioStream);

            // Start the clip in a loop
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Start playing the music
            clip.start();

            // Keep the program running to play the music
            // You can use a mechanism to keep your game running
            // This is a simple way to keep the application alive
            Thread.sleep(clip.getMicrosecondLength() / 1000);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
