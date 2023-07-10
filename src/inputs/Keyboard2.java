package inputs;

import Main.menufp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard2 implements KeyListener {
    private menufp menufp ;

    public Keyboard2(menufp menufp){
        this.menufp = menufp;
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:

                menufp.run=1;
                System.out.println("Ok");

                break;
            case KeyEvent.VK_M:

                System.out.println("Ok2");
                menufp.run=2;

                break;
            case KeyEvent.VK_A:

                break;
            case KeyEvent.VK_S:

                break;
            case KeyEvent.VK_D:

                break;
        }


    }


    @Override
    public void keyReleased(KeyEvent e) {}

}
