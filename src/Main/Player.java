package Main;

import inputs.MenuMouse;

import java.util.ArrayList;
import java.util.Random;



public class Player {
    private Random rand = new Random();
    public  int randomtrea = -1;
    public int moves =0;
    private  Panel panel;
    public  int money= 4000;
    public int power;
    public  int cord;
    public  int tindex;
    public  int index;
    public  boolean inmarket = false;
    public  boolean incastle = false;
    public int quest = rand.nextInt(7)+1;
    public boolean ontreasure;
    public boolean outofbound;
    public boolean rmove;
    private int counter = 0;
    private int[] quests = {0,0,0,0,0,0,0,0};
    public int[] trea = {0,0,0,0,0,0,0,0};
    public ArrayList<Integer> q = new ArrayList();
    public ArrayList<Integer> obtained = new ArrayList();

    public ArrayList<Integer> movecheck = new ArrayList();
    public int[] dont = {0,1,2,3,4,5,6,7,8,9,10,19,20,29,30,39,40,49,50,59,60,69,70,79,80,89,99,98,97,96,95,94,93,92,91,90};
    public boolean turn = false;
    private Sound sound;
    Music mu;

    private int m = 1;

    public Player(Panel panel){
        for(int i = 0 ; i< 8; i++){
            movecheck.add(Map.WALLS[0]);
            movecheck.add(Map.WALLS[1]);


                while(q.contains(m))
                    m = rand.nextInt(8)+1;



            q.add(m) ;




        }


        this.panel = panel;
        sound = new Sound("woosh.wav");
        mu = new Music();




    }
    public void changex(int value){

        if(moves >0){
            if(movecheck.contains(cord+value) ){
                rmove=true;

            }
            if ( MenuMouse.gamemode == 2 && search(dont,cord+ value) != -1){
                outofbound = true;
                rmove = true;
            }
            if((cord+ value) < 0 || (cord+ value) >= 100 )
                outofbound = true;
            else if (!rmove ) {
                movecheck.add(cord);
                cord += value;
                mu.setFile("woosh.wav");
                mu.play();
                movecheck.add(cord);
                moves --;
            }

           loot();
           treasures();
           if (moves == 0) {

               panel.battle();
                movecheck.clear();
           }
        }
   }

    public void Dice(){
        moves = rand.nextInt(7)+1;
        System.out.println(moves);
//       for(int i = 0 ; i<q.size();i++)
//            System.out.println(q.get(i));

    }
    public void treasures(){
         index = search(Map.TREASURES,cord);
        if(index != -1 && moves == 0){
            ontreasure = true;
            tindex = index;
            mu.setFile("trea.wav");
            mu.play();
            System.out.println(tindex);


        }
        else ontreasure = false;

    }
    public void loot(){
        int index = search(Map.Loott,cord);

        if(index != -1 && moves == 0){
            Map.Loott[index] = -1;
            money +=1000;
            mu.setFile("coins.wav");
            mu.play();

            System.out.println( money );
        }}
        public  void market(){
            int index = search(Map.Market,cord);
            if(index != -1 && moves == 0){
                inmarket = true;

            }
            else inmarket = false;
    }
    public void NewQuest(){
        quests[counter] = quest;
        counter++;
        while(search(quests,quest) != -1){
            quest = rand.nextInt(8)+1;
        }

    }

    public  void Castle(){

        if(cord == 44 && moves == 0){
            incastle = true;

        }
        else incastle = false;
    }





    public static int search(int[] array , int value){
        int i ;
        for( i = 0 ; i<array.length ; i++){
            if(array[i]==value)
                return i;

        }
        return -1;
    }

}
