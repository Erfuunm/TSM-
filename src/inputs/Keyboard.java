package inputs;

import Main.Panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener {
    private Panel panel;

    public Keyboard(Panel panel){
        this.panel = panel;
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        }




    @Override
    public void keyReleased(KeyEvent e) {}

}
