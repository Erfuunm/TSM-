package Main;

import inputs.Mouse2;

import javax.swing.*;
import java.awt.*;


public class Market extends JFrame {

    Image image ;

    Image knifeimg ;

    Image Aximg ;
    Image scrollimg;

    Image Speraimg ;
    JPanel panel = new JPanel();
    public static int knife = 0;
    public static int Ax = 0;
    public static int Spear = 0;
    public static int scroll = 0;
    public static int Wow = 0;
    private Player player;
    public Market(Player player){
        this.player =  player;

        addMouseListener(new Mouse2(this,player));
        image = new ImageIcon("Marketin.png").getImage();
        knifeimg =new ImageIcon("Knife.png").getImage();
        Aximg =new ImageIcon("Ax.png").getImage();
        Speraimg =new ImageIcon("spear.png").getImage();
        scrollimg = new ImageIcon("scrolll.png").getImage();


        //frame.setDefaultCloseOperation(.EXIT_ON_CLOSE);
        this.setSize(600 , 600);

        this.setLayout(null);
        this.setVisible(true);
        panel.setBounds(0 , 0 ,600 ,600);
        panel.setVisible(true);
        this.add(panel);


    }

    public void paint(Graphics g){


        if(Wow == 0) {
            g.drawImage(image, 0, 0, 600, 600, null);

            // in rect ha ro keshidam k moqtasat dar biaram
//            g.drawRect(120, 150, 50, 110);
//            g.drawRect(155, 315, 55, 115);
//            g.drawRect(350, 200, 60, 220);
//            g.drawRect(350 , 352 , 160 , 80 );
//            g.drawRect(350, 455 , 160 ,80);
            repaint();

        }
        else if (knife == 1 && Wow == 1){
            g.drawImage(knifeimg, 0, 0, 600, 600, null);
            repaint();
        }
        else if (Ax == 1 && Wow == 1){
            g.drawImage(Aximg, 0, 0, 600, 600, null);
            repaint();
        }
        else if (Spear == 1 && Wow == 1){
            g.drawImage(Speraimg, 0, 0, 600, 600, null);
            repaint();
        }
        else if (scroll == 1 && Wow == 1){

            g.drawImage(scrollimg, 0, 0, 600, 600, null);
            repaint();
        }

    }
}
