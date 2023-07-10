package Main;

import inputs.Keyboard2;
import inputs.MenuMouse;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class menufp extends JFrame {

    // private Total_Map total_map ;
    public JFrame frame ;
    Music mu;
    public int framedispose = 0 ;

    private BufferedImage img ;
    private boolean m = true;
    private BufferedImage[] menu;
    private int anitick , aniindex , anispeed = 300 ;
    JButton b = new JButton();
    JPanel panel =new JPanel();
    public int gg=0 , optioncount=0 , run =2;

    Image option , option1 , option2, option3 , option4 ;
    public menufp(){
        importimage();
        loadanimation();
        mu = new Music();


        option = new ImageIcon("option.png").getImage();
        option1 = new ImageIcon("map2.jpg").getImage();
        option2 = new ImageIcon("option2.png").getImage();
        option3 = new ImageIcon("Loginback1.gif").getImage();
        option4 = new ImageIcon("Logininformal.gif").getImage();


        addMouseListener(new MenuMouse(this));
        addKeyListener(new Keyboard2(this));
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1112 , 834);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        panel.setBounds(0 , 0 ,1112 ,834);
        panel.setVisible(true);
        this.add(panel);
        this.setVisible(true);



    }

    private void loadanimation() {
        menu = new BufferedImage[10];
        for (int i=0 ; i < menu.length ; i++){
//            if(i == 7){
//                System.out.printf("l");
//            }
            menu[i]= img.getSubimage(i*2224 , 0 , 2224 , 1668);
        }

    }
    private void importimage(){


        InputStream is = getClass().getResourceAsStream("/MENU.png");

        try {
            img = ImageIO.read(is);
        }catch (IOException e){
            throw new RuntimeException();
        }finally {
            try {
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
    private void updateanimationtic() {
        anitick++ ;
        if(anitick >= anispeed){
            anitick = 0 ;
            aniindex++;
            if(aniindex >= menu.length){
                aniindex=0;
            }
        }

    }

    public void paint(Graphics g){


        if(run == 0){


            g.drawImage(option4, 0, 0, 1112, 834, null);
        }
        else if(run == 1){
            g.drawImage(option3, 0, 0, 1112, 834, null);
        }

        else if(run == 2 ) {
            if(m){
                mu.setFile("l.wav");
                mu.loop();
                m = false;
            }
            updateanimationtic();
            g.drawImage(menu[aniindex], 0, 0, 1112, 834, null);
            g.drawImage(option, 720, 120, 420, 700, null);
            //g.drawRect(820, 243, 220, 50);
        }

        else if(optioncount == 1 && run ==2){
            g.drawImage(option, 720, 120, 420, 700, null);

        }
        else if (run == 4){
            g.drawImage(option1,0,0,1112,834,null);
            Font font = new Font("Serif",Font.PLAIN,40);
            g.setFont(font);
            g.setColor(Color.lightGray);
            g.fillRect(0,0,250,150);
            g.setColor(Color.gray);
            g.fillRect(25,25,200,100);
            g.setColor(Color.black);
            g.drawString("BACK",25,25);


        }
        repaint();
        if(framedispose == 1){
            mu.stop();
            System.out.println("frame disposed");
            this.setVisible(false);
            framedispose++;
        }





    }


}