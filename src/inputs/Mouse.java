package inputs;

import Main.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;


public class Mouse implements MouseListener  {
    private Panel panel;
    private Player playerred;
    private Player playerblue;
    private Sound sound;
    private Sound buttonss;
    Music mu;
    Music main;
    boolean audio = true;

    private Map map ;
    private Market market;
    public int Dice;
    public Mouse(Panel panel , Player playerred,Player playerblue){
        this.panel =  panel;
        this.playerred =  playerred;
        this.playerblue =  playerblue;
       // market = new Market();
        map = new Map();


        mu = new Music();
        main = new Music();
        sound = new Sound("woosh.wav");
        main.setFile("music.wav");
        main.play();



    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX()>0 && e.getX()<150 && e.getY()>0 && e.getY()<150){
            System.out.printf("clicked");
            if(audio) {
                audio = false;

                Music.ply = false;
                main.stop();
            }
            else if(!audio){
                audio = true;
                Music.ply = true;
                main.setFile("music.wav");
                main.loop();}
        }
        if(Game.roundr){

            ontreasure(e, playerred);
        }
            else {
            ontreasure(e, playerblue);
        }


        //******NEW******
        for(int i=0 ; i<5 ; i++) {
            if(Game.roundr){
                market(e, i, playerred);
            }
            else {
                market(e, i, playerblue);

            }}
        //***************


        //****************

        if(e.getX()>700 && e.getX()<800 && e.getY()>625 && e.getY()<725){


            System.out.println("dice rolled");
            if(Game.roundr && playerred.turn){
//                sound.playe();
//                sound.so();
                mu.setFile("diceroll.wav");
                mu.play();

            playerred.Dice();
            Dice = playerred.moves;
            playerred.turn =false;
            playerblue.turn = true;}
            else if(!Game.roundr && playerblue.turn ){
                mu.setFile("diceroll.wav");
                mu.play();
//                sound.playe();
//                sound.so();

                playerblue.Dice();
                Dice = playerred.moves;
                playerblue.turn = false;
                playerred.turn = true;
            }
        }
        if(e.getX()>945 && e.getX()<1000 && e.getY()>585 && e.getY()<640){
            if(Game.roundr)
                playerred.changex(10);
            else
                playerblue.changex(10);

            System.out.println("up");
        }
        if(e.getX()>945 && e.getX()<1000 && e.getY()>685 && e.getY()<738){
            if(Game.roundr)
                playerred.changex(-10);
            else
                playerblue.changex(-10);


            System.out.println("down");
            }
        if(e.getX()>1000 && e.getX()<1055 && e.getY()>635 && e.getY()<695){
            if(Game.roundr)
                playerred.changex(1);
            else
                playerblue.changex(1);


            System.out.println("right");
            }
        if(e.getX()>895 && e.getX()<945 && e.getY()>635 && e.getY()<695){
            if(Game.roundr)
                playerred.changex(-1);
            else
                playerblue.changex(-1);

            System.out.println("left");
            }
        if(e.getX()>700 && e.getX()<800 && e.getY()>590 && e.getY()<615){
            mu.setFile("buttons.wav");
            mu.play();
            if(Game.roundr)
            Game.roundr= false;
            else Game.roundr = true;
            System.out.println("turn changed");
        }
        if(e.getX()>770 && e.getX()<820 && e.getY()>590 && e.getY()<615 ){
            mu.setFile("buttons.wav");
            mu.play();
            AI ai  = new AI(playerblue);
            if(Game.roundr) {
                Game.roundr = false;
           playerblue.turn = false;
           playerred.turn =true;
            }
            else

                System.out.println("kkkkkkkkkkkkkk");
            System.out.println("turn changed");
        }
        if (e.getX() > 930 && e.getX() < 970 && e.getY() > 20 && e.getY() < 60) {
            try {
                FileWriter save = new FileWriter("save.txt");


                String deta = MessageFormat.format("{0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12},{13} ", Map.Market[0], Map.Market[1], Map.Market[2], Map.Market[3], Map.Market[4]
                        , playerblue.power/10 , playerred.power/10, playerblue.money/10 , playerred.money/10 , playerblue.cord , playerred.cord ,Map.WALLS[0],Map.WALLS[1],0);
                save.write(deta);
                save.close();

            } catch (FileNotFoundException e2) {
                throw new RuntimeException(e2);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("baste shod");

            System.exit(0);

        }

    }

    private void ontreasure(MouseEvent e, Player player) {
        if(e.getX()>400 && e.getX()< 710 && e.getY()>190 && e.getY()<650&& player.ontreasure){
            player.obtained.add(player.q.get( playerred.tindex));
            player.ontreasure=false;}
        player.Castle();
        if(e.getX()>265 && e.getX()< 300 && e.getY()>570 && e.getY()<600&& player.incastle) {
        Castle castle =new Castle(player);}
    }

    private void market(MouseEvent e, int i, Player playerred) {
        playerred.market();
        if ((e.getX() > (map.cords[map.Market[i]][1] - 15) && e.getX() < (map.cords[map.Market[i]][1] + 15 )&& playerred.inmarket
                && e.getY() > (map.cords[map.Market[i]][0] - 15) && e.getY() < (map.cords[map.Market[i]][0] + 15))) {
            Market market = new Market(playerred);
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
