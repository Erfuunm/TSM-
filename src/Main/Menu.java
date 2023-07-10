package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Menu extends JFrame {
    private BufferedImage img;
    private  BufferedImage[] background;

    JFrame frame;
    JPanel pm;
    private int anitick,aniindex,anispeed= 14;
    Menu(){

        pm = new JPanel();
        frame = new JFrame();

        pm.setBackground(new Color(4,7,9));

        importimage();
        loadanimations();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1112, 834);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.add(pm);
        pm.setVisible(true);
        frame.setVisible(true);


    }
    private void loadanimations() {
        background = new BufferedImage[10];


        for(int i = 0; i< background.length; i++)
            background[i] = img.getSubimage(i*2224,0,2224,1668);

    }
    private void importimage(){
        InputStream is = getClass().getResourceAsStream("/MENU.png");


        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }}
    @Override
    public void paint (Graphics g){
        super.paint(g);


        //updateanimationtick();
        System.out.println("KLKLK");

        g.drawImage(background[aniindex],0,0,1112,843,null);
//        repaint();
    }
    private void updateanimationtick() {
        anitick++;
        if(anitick >= anispeed) {
            anitick = 0;
            aniindex++;

            if(aniindex >= background.length)
                aniindex = 0;

        }

    }


}
