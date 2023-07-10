package Main;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    public static Clip clip;

    public Sound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static void playe() {
        clip.start();
    }
    public static void stop(){
        clip.stop();
    }
    public static void so(){
        clip.setFramePosition(0);
        clip.start();
    }
}
