package Main;

import javax.swing.*;
import java.awt.*;

public class Quest {

    Image sword , Crown , ring , shield , row , key , scroll , glass ;

    //public final int[] quest = {0,1,2,3,4,5,6,7};
    // 1 => sword , 2 => Crown , 3 => ring , 4 => shield ,5 => row , 6 => key , 7 =>scroll , 8 => glass ;

    Quest(){
        sword = new ImageIcon("sword.png").getImage();
        Crown = new ImageIcon("Crown.png").getImage();
        ring = new ImageIcon("ring.png").getImage();
        shield = new ImageIcon("shield.png").getImage();
        row = new ImageIcon("row.png").getImage();
        key = new ImageIcon("key.png").getImage();
        scroll = new ImageIcon("scroll.png").getImage();
        glass = new ImageIcon("glass.png").getImage();

    }



}
