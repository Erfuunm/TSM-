package inputs;


import Main.Player;

import javax.swing.*;
import java.awt.*;


public class Castle extends JFrame {

    Image castle ;
    Player player;
    JPanel panel = new JPanel();
    Castle(Player player){
        this.player = player;
        this.setSize(600 , 600);
        addMouseListener(new Mouse3(player));
        castle = new ImageIcon("Castleroom.png").getImage();
        this.setLayout(null);
        this.setVisible(true);
        panel.setBounds(0 , 0 ,600 ,600);
        panel.setVisible(true);
        this.add(panel);

    }
    public void paint (Graphics g){

        g.drawImage(castle, 0, 0, 600, 600, null);

        //repaint();
    }


}

