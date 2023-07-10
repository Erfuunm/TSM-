package inputs;

import Main.Map;
import Main.Market;
import Main.Music;
import Main.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class Mouse2 implements MouseListener  {
    private Market panel;
    private Random rand = new Random();

    private Map map ;
    private Player player;
    public Market market;
    Music mu;



    public Mouse2(Market panel ,Player player){
        this.panel =  panel;
        this.player =  player;
        // market = new Market();
        mu = new Music();
        map = new Map();




    }
    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getX()>120 && e.getX()<170 && e.getY()>150 && e.getY()<260){
            mu.setFile("buttons.wav");
            mu.play();

            System.out.println(market.knife);
            market.knife=1;
            market.Wow =1 ;
        }
        if(e.getX()>155 && e.getX()<210 && e.getY()>315 && e.getY()<430){
            mu.setFile("buttons.wav");
            mu.play();

            market.Ax = 1;
            market.Wow =1 ;

        }

        if(e.getX()>350 && e.getX()<410 && e.getY()>200 && e.getY()<420){
            mu.setFile("buttons.wav");
            mu.play();

            market.Spear = 1;
            market.Wow =1 ;

        }
        if(e.getX()>410 && e.getX()<460 && e.getY()>320 && e.getY()<430){
            mu.setFile("buttons.wav");
            mu.play();


            market.scroll = 1;
            market.Wow =1 ;

        }

        if(e.getX()>350 && e.getX()<510 && e.getY()>455 && e.getY()<535){
            mu.setFile("buttons.wav");
            mu.play();

            market.Wow =0;
            market.Spear = 0;
            market.Ax = 0;
            market.knife = 0;
            market.scroll = 0 ;


        }


        if(e.getX()>360 && e.getX()<500 && e.getY()>352 && e.getY()<422){
            if(market.knife == 1){
                if(player.money >= 1500){
                    mu.setFile("coins.wav");
                    mu.play();
                    player.power += 7;
                    player.money-= 1500;
                    System.out.println("Pool dari ");
                }
                else {
                    mu.setFile("error.wav");
                    mu.play();
                }
            }
            if(market.Ax == 1){
                if(player.money >= 2000){
                    mu.setFile("coins.wav");
                    mu.play();
                    player.power += 10;
                    player.money-= 2000;
                }
                else {
                    mu.setFile("error.wav");
                    mu.play();
                }

            }
            if(market.Spear == 1){
                if(player.money >= 2500){
                    mu.setFile("coins.wav");
                    mu.play();
                    player.power += 13;
                    player.money-= 2500;
                }
            else {
                mu.setFile("error.wav");
                mu.play();
            }}
                if(market.scroll == 1){
                    if(player.money >= 3000){
                        mu.setFile("coins.wav");
                        mu.play();
                        player.randomtrea = rand.nextInt(7)+1;
                        System.out.println("Pool dari ");

                        player.money-= 3000;
                    }
                    else {
                        mu.setFile("error.wav");
                        mu.play();
                    }
            }

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
