    private void StartBackgroundMusic(String filepath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(WavPlayer.class.getResourceAsStream(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.setMicrosecondPosition(0); // Reset position to the beginning
                    clip.start(); // Restart playback
                }
            });

            clip.start();
            Thread.sleep(Long.MAX_VALUE); // Keep the thread alive to allow continuous playback
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }
