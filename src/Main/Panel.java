package Main;


import inputs.Keyboard;
import inputs.MenuMouse;
import inputs.Mouse;
import inputs.Mousemo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Panel extends JPanel {
    private Random rand;
    private Map map;
    private Button up;
    private Player playerred;
    private Player playerblue;
    private int plyrsizex,plyrsizey,plyrsizex1,plyrsizey1;

    private int cordred =0,cordblue = 5;
    private BufferedImage img;
    private BufferedImage updown;
    private BufferedImage plyred;
    private BufferedImage plyblue;
    private BufferedImage marketp;
    private BufferedImage castle;
    private BufferedImage[] background;
    private BufferedImage[] red;
    private BufferedImage[] blue;
    private BufferedImage[] market;
    private long stime = System.currentTimeMillis()/1000;
    private long etime;
    private Sound error;
    private Map64 map64;
    public Music mu;


    Image Quest ;
    Image sound ;
    Image nosound;
    Image option4;
    Image wall;

    Quest questt ;
    public static int save=0;

    private int anitick,aniindex,anred,anmark,anispeed= 14;

    public Panel(){
        rand = new Random();
        wall = new ImageIcon("tree.PNG").getImage();

        Quest = new ImageIcon("Quest.png").getImage();
        sound= new ImageIcon("sou.png").getImage();
        nosound= new ImageIcon("x.png").getImage();


        questt = new Quest();
        map = new Map();
        map64 = new Map64();
        playerred = new Player(this);
        playerblue = new Player(this);
        playerred.cord = 99;
        playerred.turn = true;
        option4 = new ImageIcon("Logininformal.gif").getImage();

        mu = new Music();
        if(MenuMouse.gamemode == 2){
            playerblue.cord = 11;
            playerred.cord =88;
        }
        if(save == 1 ){
            //**********
            File save = new File(new File("").getAbsolutePath()+"/save.txt");
            try {
                Scanner scanner = new Scanner(save);
                while (scanner.hasNextLine()) {
                    String deta = scanner.nextLine();
                    String[] arraysave = deta.split(",");
                    //******************************
                    playerblue.power = Integer.parseInt(arraysave[5])*10;
                    playerred.power = Integer.parseInt(arraysave[6])*10;
                    playerblue.money = Integer.parseInt(arraysave[7])*10;
                    playerred.money = Integer.parseInt(arraysave[8])*10;
                    playerblue.cord = Integer.parseInt(arraysave[9]);
                     playerred.cord = Integer.parseInt(arraysave[10]);

                }
            } catch (FileNotFoundException e2) {
                throw new RuntimeException(e2);
            }}









        importimage();
        loadanimations();
        setpanelsize();
        addKeyListener(new Keyboard(this));
        addMouseListener(new Mouse(this,playerred,playerblue));
        addMouseMotionListener(new Mousemo(this));

    }

    private void loadanimations() {
        background = new BufferedImage[20];
        red = new BufferedImage[7];
        blue = new BufferedImage[7];
        market = new BufferedImage[11];


        for(int i = 0; i< background.length; i++)
        background[i] = img.getSubimage(i*2224,0,2224,1668);
        for(int i = 0; i< market.length; i++)
            market[i] = marketp.getSubimage(i*2224,0,2224,1668);
        for(int i = 0; i< red.length; i++){
            red[i] = plyred.getSubimage(i*1668,0,1668,2224);
            blue[i] = plyblue.getSubimage(i*1668,0,1668,2224);
        }
       // for(int i = 0; i< background.length; i++)
            //background[i] = img.getSubimage(i*2224,0,2224,1668);
    }

    private void importimage(){
        InputStream is = getClass().getResourceAsStream("/backg.png");
        InputStream ris = getClass().getResourceAsStream("/redsprite.png");
        InputStream bis = getClass().getResourceAsStream("/blue.png");
        InputStream jis = getClass().getResourceAsStream("/market.png");
        InputStream cas = getClass().getResourceAsStream("/castle.png");
        InputStream ud = getClass().getResourceAsStream("/updown.png");

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
        }
        try {
            plyred = ImageIO.read(ris);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                ris.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            plyblue = ImageIO.read(bis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            marketp = ImageIO.read(jis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                jis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            castle = ImageIO.read(cas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                cas.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            updown = ImageIO.read(ud);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                ud.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void setpanelsize(){
        Dimension size = new Dimension(1112,843);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

   private void Plyrsize(int cord){
        switch (cord){
            case (720):
            case (680):
                plyrsizex = 52;
                plyrsizey = 70;
                plyrsizex1 = 26;
                plyrsizey1 = 35;
                break;
            case (639):
            case (607):
                plyrsizex = 51;
                plyrsizey = 69;
                plyrsizex1 = 25;
                plyrsizey1 = 35;
                break;
            case (575):
            case (546):
                plyrsizex = 50;
                plyrsizey = 68;
                plyrsizex1 = 25;
                plyrsizey1 = 35;
                break;
            case (519):
            case (494):
                plyrsizex = 49;
                plyrsizey = 67;
                plyrsizex1 = 24;
                plyrsizey1 = 35;
                break;
             case (471):
             case (448):
               plyrsizex = 48;
               plyrsizey = 66;
                 plyrsizex1 = 24;
                 plyrsizey1 = 37;
               break;}
    }

    public void battle(){
        if(playerblue.cord == playerred.cord && playerblue.moves == 0 && playerred.moves == 0){
            if(playerred.power > playerblue.power){
                playerblue.cord = 0;
                playerblue.power = 0;
                playerred.power -= playerblue.power;
                playerred.money += ((playerred.money - playerblue.money)/(playerred.money + playerblue.money))* playerblue.money;
                playerblue.money -= ((playerred.money - playerblue.money)/(playerred.money + playerblue.money))* playerblue.money;
                System.out.println("red won");

            }
            else if(playerred.power < playerblue.power && playerblue.moves == 0 && playerred.moves == 0){
                playerred.cord = 0;
                playerred.power = 0;
                playerblue.power -= playerred.power;
                playerblue.money += ((playerblue.money - playerred.money)/(playerred.money + playerblue.money))* playerred.money;
                playerred.money  -= ((playerblue.money - playerred.money)/(playerred.money + playerblue.money))* playerred.money;
                System.out.println("blue won");

            }
            else{
                playerblue.cord = 0;
                playerblue.power = 0;
                playerred.power -= playerblue.power;
                playerred.money += ((playerred.money - playerblue.money)/(playerred.money + playerblue.money))* playerblue.money;
                playerblue.money -= ((playerred.money - playerblue.money)/(playerred.money + playerblue.money))* playerblue.money;
                System.out.println("red won unjustly");}
        }
    }

    private void updateanimationtick() {
        anitick++;
        if(anitick >= anispeed) {
            anitick = 0;
            aniindex++;
            anred++;
            anmark++;
            if(aniindex >= background.length)
                aniindex = 0;
            if(anred >= red.length)
                anred = 0;
            if(anmark >= market.length -1)
                anmark = 0;
        }
    }
    public  void updategame(){
        updateanimationtick();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        etime = System.currentTimeMillis()/1000;





       g.drawImage(background[aniindex],0,0,1112,843,null);
        g.setColor(new Color(108,106,163));
        g.fillRect(700,590,100,25);
        g.setColor(Color.white);
        g.fillRect(700,625,100,100);


        g.setColor(Color.white);
        g.drawImage(castle,0,0,1112,843,null);
        g.drawImage(updown,0,0,1112,843,null);
        Font font = new Font("Serif",Font.PLAIN,40);
        g.setFont(font);
        g.drawString("EXIT" , 930,35);


        g.drawString( String.valueOf(((etime-stime)/60)/60)+":"+ String.valueOf(((etime-stime)/60)%60)+":" + String.valueOf((etime-stime)%60),815,135);
        //g.drawString(android.text.format.DateUtils.formatElapsedTime(System.currentTimeMillis()/1000),805,135);
        g.setColor(Color.WHITE);

        g.drawString("     red       blue ",800,300);
        g.drawString("money : " + String.valueOf(playerred.money) +"    "+String.valueOf(playerblue.money),700,350);
        g.drawString("power :   " + String.valueOf(playerred.power) +"         " +String.valueOf(playerblue.power),700,400);

        g.setColor(new Color(0,0,100));


   for(int i = 4; i> -1;i--){
       Plyrsize(map.cords[map.Market[i]][0] );
        g.drawImage(market[anmark],map.cords[map.Market[i]][1] -(plyrsizex1+24),map.cords[map.Market[i]][0] -(plyrsizey1+40),plyrsizex+48,plyrsizey+64,null);}
        Plyrsize(map.cords[map.WALLS[1]][0] );
        g.drawImage(wall,map.cords[map.WALLS[1]][1] -(plyrsizex1+40),map.cords[map.WALLS[1]][0] -(plyrsizey1+40),plyrsizex+24,plyrsizey+32,null);
        Plyrsize(map.cords[map.WALLS[0]][0] );
        g.drawImage(wall,map.cords[map.WALLS[0]][1] -(plyrsizex1+40),map.cords[map.WALLS[0]][0] -(plyrsizey1+40),plyrsizex+24,plyrsizey+32,null);






        if(MenuMouse.gamemode==2) {
         //  System.out.printf("");
           for (int i = 0; i < 36; i++) {
               //g.drawImage(wall,map64.Dltcords[i][1] -(plyrsizex1+40),map64.Dltcords[i][0] -(plyrsizey1+40),plyrsizex+24,plyrsizey+32,null);


               g.setColor(Color.black);
               g.fillOval(map64.Dltcords[i][1] - 5, map64.Dltcords[i][0] + 1, 15, 15);
           }
       }
        g.setColor(Color.white);
        g.fillOval(10,10, 50, 50);
        g.drawImage(sound , 15 ,15,40,40,null);
        if(!mu.ply){

            g.drawImage(nosound , 15 ,15,40,40,null);}


        g.setColor(Color.WHITE);

     if(playerblue.turn){

          g.drawString("player blues turn",700,250);

         g.setColor(new Color(90,0,0));
         g.drawString(String.valueOf(playerred.moves),740,690);

       }
     else{
          g.drawString("player reds turn",700,250);
         g.setColor(new Color(0,0,100));
         g.drawString(String.valueOf(playerblue.moves),740,690);


     }
        g.setColor(Color.white);

        if(Game.roundr){
            Plyrsize(map.cords[playerred.cord][0]);

            g.drawImage(red[anred] ,map.cords[ playerred.cord][1] - plyrsizex1,map.cords[ playerred.cord][0] - plyrsizey1,plyrsizex,plyrsizey,null);
            if(playerred.randomtrea > 0  ){
                g.fillRect(map.cords[map.TREASURES[playerred.randomtrea]][1]-10,map.cords[map.TREASURES[playerred.randomtrea]][0]-15,10,10);}

            g.drawString("player reds map",700,450);
            if(playerred.outofbound  || playerred.rmove){

                mu.setFile("error.wav");
                mu.play();
                g.drawString("invalid",110,390);
                playerred.outofbound = false;
                playerred.rmove = false;

            }
            //g.drawString("player reds turn",700,250);
            if(playerred.ontreasure){
                quest(g, playerred.q.get( playerred.tindex),0, 0, 1112, 843);



            }

            quest(g, playerred.quest,110, 90, 150, 160);
        }
        else{
            Plyrsize(map.cords[playerblue.cord][0]);
            g.drawImage(blue[anred] ,map.cords[ playerblue.cord][1] - plyrsizex1,map.cords[playerblue.cord][0] - plyrsizey1,plyrsizex,plyrsizey,null);
            if(playerblue.randomtrea > 0  ){
                g.fillRect(map.cords[map.TREASURES[playerblue.randomtrea]][1]-10,map.cords[map.TREASURES[playerblue.randomtrea]][0]-15,10,10);}
            g.drawString("player blues map",700,450);
            if(playerblue.outofbound ||playerblue.rmove)
            {
                mu.setFile("error.wav");
                mu.play();
                g.drawString("invalid",110,390);
                playerblue.rmove= false;
                playerblue.outofbound =false;}
            //g.drawString("player blues turn",700,250);
            if(playerblue.ontreasure){
                quest(g, playerblue.q.get( playerred.tindex),0, 0, 1112, 843);


            }

            quest(g, playerblue.quest,110, 90, 150, 160);
        }
        g.drawImage(Quest , 0 ,0,240,320,null);


    }

    private void quest(Graphics g, int q,int x,int y,int w,int h) {
        if(q == 1) {
            g.drawImage(questt.sword, x, y, w, h, null);
        }
        if(q  == 2) {
            g.drawImage(questt.Crown,  x, y, w, h, null);
        }
        if(q  == 3) {
            g.drawImage(questt.ring,  x, y, w, h, null);
        }
        if( q == 4) {
            g.drawImage(questt.shield,  x, y, w, h,  null);
        }
        if(q  == 5) {
            g.drawImage(questt.row,  x, y, w, h, null);
        }
        if(q== 6) {
            g.drawImage(questt.key,  x, y, w, h, null);
        }
        if(q  == 7) {
            g.drawImage(questt.scroll,  x, y, w, h, null);
        }
        if(q  == 8) {
            g.drawImage(questt.glass,  x, y, w, h, null);
        }
    }


}
