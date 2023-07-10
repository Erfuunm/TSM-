package Main;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;




public class Map {

//    public static  int marketloc1 ;
//
//    public static  int marketloc2 ;
//
//
//    public static  int marketloc3 ;
//
//// while(marketloc3 != )
//
//
//    public static  int marketloc4 ;
//
//
//    public static  int marketloc5 ;


//    public Map(){
//        if(MenuMouse.gamemode==2) {
//            marketloc1 = ThreadLocalRandom.current().nextInt(12, 16); //new
//            marketloc2 = ThreadLocalRandom.current().nextInt(24, 28);
//            marketloc3 = ThreadLocalRandom.current().nextInt(42, 45); //new
//            marketloc4 = ThreadLocalRandom.current().nextInt(60, 65); //new
//            marketloc5 = ThreadLocalRandom.current().nextInt(84, 89); //new (Shansi ye ja inam bndaze)
//        }
//        else {
//            marketloc1 = ThreadLocalRandom.current().nextInt(5, 10); //new
//            marketloc2 = ThreadLocalRandom.current().nextInt(21, 36);
//            marketloc3 = ThreadLocalRandom.current().nextInt(46, 49); //new
//            marketloc4 = ThreadLocalRandom.current().nextInt(60, 65); //new
//            marketloc5 = ThreadLocalRandom.current().nextInt(94, 99); //new (Shansi ye ja inam bndaze)
//        }
//    }

    public static final int[][] cords = {
            {720 , 88 } , {720 , 140} , {720 , 193} , {720 , 245} , {720 , 296}
            , {720 , 348} , {720 , 398} , {720 , 450} , {720 , 504} , {720 , 556}
            , {680 , 72 } , {680 , 120} , {680 , 170} , {680 , 220} , {680 , 270}
            , {680 , 320} , {680 , 370} , {680 , 420} , {680 , 470} , {680 , 520}
            , {639 , 102} , {639 , 150} , {639 , 198} , {639 , 245} , {639 , 293}
            , {639 , 341} , {639 , 381} , {639 , 435} , {639 , 483} , {639 , 532}
            , {607 , 88 } , {607 , 132} , {607 , 179} , {607 , 222} , {607 , 270}
            , {607 , 316} , {607 , 362} , {607 , 406} , {607 , 453} , {607 , 498}
            , {575 , 116} , {575 , 161} , {575 , 205} , {575 , 248} , {575 , 292}
            , {575 , 336} , {575 , 379} , {575 , 420} , {575 , 467} , {575 , 510}
            , {546 , 102} , {546 , 142} , {546 , 186} , {546 , 226} , {546 , 271}
            , {546 , 312} , {546 , 353} , {546 , 394} , {546 , 442} , {546 , 481}
            , {519 , 127} , {519 , 168} , {519 , 209} , {519 , 250} , {519 , 290}
            , {519 , 330} , {519 , 372} , {519 , 411} , {519 , 453} , {519 , 491}
            , {494 , 113} , {494 , 152} , {494 , 191} , {494 , 229} , {494 , 271}
            , {494 , 307} , {494 , 347} , {494 , 388} , {494 , 428} , {494 , 466}
            , {471 , 135} , {471 , 174} , {471 , 212} , {471 , 250} , {471 , 287}
            , {471 , 327} , {471 , 364} , {471 , 401} , {471 , 442} , {471 , 479}
            , {448 , 122} , {448 , 151} , {448 , 196} , {448 , 231} , {448 , 270}
            , {448 , 306} , {448 , 343} , {448 , 380} , {448 , 419} , {448 , 454}
    };




    public static Random  rand =new Random(); // new

    //***********MARKETS*************************
    public static  int  marketloc1 = ThreadLocalRandom.current().nextInt(12, 16); //new
    public static  int  marketloc2 = ThreadLocalRandom.current().nextInt(24, 28);
    public static  int  marketloc3 = ThreadLocalRandom.current().nextInt(42, 44); //new
    public static  int  marketloc4 = ThreadLocalRandom.current().nextInt(60, 65); //new
    public static  int  marketloc5 = ThreadLocalRandom.current().nextInt(84, 89); //new (Shansi ye ja inam bndaze)



    //*************TRAPS*************

    public static int Trap1 = rand.nextInt(25);// new

    public static int Trap2 = ThreadLocalRandom.current().nextInt(25,50); //new

    public static int Trap3 = ThreadLocalRandom.current().nextInt(50,75); //new


    //*************WALLS*************



    public static int wall2 = ThreadLocalRandom.current().nextInt(50,75); //new

    public static int wall3 = ThreadLocalRandom.current().nextInt(75,100); //new

    //********TREAURES*******
    public static int TRE1 = ThreadLocalRandom.current().nextInt(0,12); //new
    public static int TRE2 = ThreadLocalRandom.current().nextInt(13,25); //new
    public static int TRE3 = ThreadLocalRandom.current().nextInt(26,38); //new
    public static int TRE4 = ThreadLocalRandom.current().nextInt(39,53); //new
    public static int TRE5 = ThreadLocalRandom.current().nextInt(54,66); //new
    public static int TRE6 = ThreadLocalRandom.current().nextInt(67,79); //new
    public static int TRE7 = ThreadLocalRandom.current().nextInt(80,90); //new
    public static int TRE8 = ThreadLocalRandom.current().nextInt(91,99); //new

    //****************************************************
    //loots
    public static int Loot1 = ThreadLocalRandom.current().nextInt(11,20); //new
    public static int Loot2 = ThreadLocalRandom.current().nextInt(25,50); //new
    public static int Loot3 = ThreadLocalRandom.current().nextInt(50,75); //new
    public static int Loot4 = ThreadLocalRandom.current().nextInt(75,100); //new
    public static int Loot5 = ThreadLocalRandom.current().nextInt(0,25); //new
    public static int Loot6 = ThreadLocalRandom.current().nextInt(25,50); //new
    public static int Loot7 = ThreadLocalRandom.current().nextInt(50,75); //new
    public static int Loot8 = ThreadLocalRandom.current().nextInt(75,100);






    public static final int[] Market = {marketloc1,marketloc2,marketloc3,marketloc4,marketloc5};

    public static final int[] TRAPS = {Trap1,Trap2,Trap3};
    public static final int[] WALLS = {wall2,wall3};
    public static final int[] Loott = { Loot1,Loot2,Loot3,Loot4,Loot5,Loot6,Loot7,Loot8};
    public static final int[] TREASURES = {TRE1,TRE2, TRE3 ,TRE4 , TRE5 ,TRE6 , TRE7 , TRE8 };




}
