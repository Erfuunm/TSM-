package Main;

import java.util.concurrent.ThreadLocalRandom;


public class AI {
    private Map map ;
    public int dice ;
    private boolean sw =true;

    private Player playerblue;
    private int mo;

    int[] Aimove ={10 , -10 , 1 ,-1};
    public AI(){

    }
    public AI(Player playerblue) {
        this.playerblue = playerblue;
        map = new Map();
        dice= ThreadLocalRandom.current().nextInt(3, 5);
        playerblue.moves=4;
      if (playerblue.moves > 0) {
            if(  playerblue.obtained.contains(playerblue.quest)  && playerblue.cord+ dice ==46){
                playerblue.cord+= dice;
            sw = false;}
            for(int i =0 ; i<5;i++)
            if(playerblue.cord+ dice == Map.Market[i]){
                playerblue.cord+=dice;
                sw = false;}

            for (int i = 0; i < 2*dice && sw; i++) {

                int in = ThreadLocalRandom.current().nextInt(0, 3);
                mo =playerblue.moves;


                playerblue.changex(Aimove[in]);
//                if(mo == playerblue.moves)
//                    i--;




            }
            playerblue.moves =0;
            if (playerblue.inmarket) {

                if (playerblue.money >= 2000) {
                    playerblue.money -= 2000;
                    playerblue.power += 10;
                }


            }
            if (playerblue.ontreasure) {
                System.out.println("I found it");
            }
            if(playerblue.incastle){

            if(playerblue.obtained.contains(playerblue.quest)){
                System.out.println("YEAH BABY");
                playerblue.money += 4000;
                playerblue.NewQuest();}
            else System.out.println("lying bitch");
        }
            sw = true;

        }
    }
}
