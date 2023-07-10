package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {
    Clip clip;
    AudioInputStream sound;
    public static boolean ply = true;

    public void setFile(String soundFileName) {
        try {
            File file = new File(soundFileName);
            sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {

        }
    }

    public void play() {

        if(ply)
            clip.start();
    }

    public void stop(){

        clip.close();

        clip.stop();
    }
    public void  loop(){
        clip.loop(10);

    }

}