package inputs;

import Main.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MenuMouse implements MouseListener {

    public menufp menufp;
    Music mu;
    public static int gamemode = 1;
    public MenuMouse(menufp menufp){
        mu = new Music();

        this.menufp=menufp;
    }
    @Override
    public void mouseClicked(MouseEvent e) {


            if (e.getX() > 820 && e.getX() < 1070 && e.getY() > 220 && e.getY() < 300) {
                mu.setFile("buttons.wav");
                mu.play();
                Map.Market[0] = ThreadLocalRandom.current().nextInt(5, 10); //new
                Map.Market[1] = ThreadLocalRandom.current().nextInt(21, 36); //new
                Map.Market[2] = ThreadLocalRandom.current().nextInt(46, 49); //new
                Map.Market[3] = ThreadLocalRandom.current().nextInt(60, 65); //new
                Map.Market[4] = ThreadLocalRandom.current().nextInt(94, 99); //new (Shansi ye ja inam bndaze)

                Game game = Game.getInstance();
                menufp.framedispose = 1;

            }

        if (e.getX() > 820 && e.getX() < 1070 && e.getY() > 320 && e.getY() < 400) {
            File save = new File(new File("").getAbsolutePath()+"/save.txt");
            try {
                Scanner scanner = new Scanner(save);
                while (scanner.hasNextLine()) {
                    String deta = scanner.nextLine();
                    String[] arraysave = deta.split(",");
                    //******************************
                    Map.Market[0] = Integer.parseInt(arraysave[0]);
                    Map.Market[1] = Integer.parseInt(arraysave[1]);
                    Map.Market[2] = Integer.parseInt(arraysave[2]);
                    Map.Market[3] = Integer.parseInt(arraysave[3]);
                    Map.Market[4] = Integer.parseInt(arraysave[4]);
                    Map.WALLS[0] = Integer.parseInt(arraysave[11]);
                    Map.WALLS[1] = Integer.parseInt(arraysave[12]);

                }
            } catch (FileNotFoundException e2) {
                throw new RuntimeException(e2);
            }

            Panel.save=1;
            Game game = Game.getInstance();
            menufp.framedispose = 1;
        }
        if(e.getX()>820 && e.getX()<1070 && e.getY()>540 && e.getY()<600) {
            mu.setFile("buttons.wav");
            mu.play();

            menufp.run=4;

        }
        if(e.getX()>0 && e.getX()<250 && e.getY()>0 && e.getY()<150) {
            mu.setFile("buttons.wav");
            mu.play();
            menufp.run=2;//BACK
        }
        if(e.getX()>160 && e.getX()<450 && e.getY()>250 && e.getY()<670) {
            mu.setFile("buttons.wav");
            mu.play();


            gamemode=2;
            System.out.printf("kochik");

        }
        if(e.getX()>650 && e.getX()<790 && e.getY()>250 && e.getY()<670) {
            mu.setFile("buttons.wav");
            mu.play();

            gamemode=3;


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

//        if(e.getX()>820 && e.getX()<1070 && e.getY()>250 && e.getY()<300) {
//            menufp.optioncount = 1;
//            System.out.printf("55");
//        }


    }

    @Override
    public void mouseExited(MouseEvent e) {

//        if(e.getX()>820 && e.getX()<1070 && e.getY()>250 && e.getY()<300) {
//            menufp.optioncount = 0;
//            System.out.println("55");
//        }
    }
}
