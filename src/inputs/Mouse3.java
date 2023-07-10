package inputs;

import Main.Music;
import Main.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Mouse3 implements MouseListener {

    public Castle castle;
    Player player;
    Music mu;
    public Mouse3(Player player){
        mu = new Music();
        this.player = player;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX()>260 && e.getX()<330 && e.getY()>300 && e.getY()<430) {
            mu.setFile("buttons.wav");
            mu.play();

            if(player.obtained.contains(player.quest)){
            System.out.println("YEAH BABY");
                mu.setFile("coins.wav");
                mu.play();
            player.money += 4000;
            player.NewQuest();}
            else System.out.println("lying bitch");
        }
        }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
