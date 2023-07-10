package Main;

public class Game implements Runnable {
    private static Game instance = new Game();
    private Window window;
    private Panel panel;
    private Thread thread;
    private final int FPS_SET = 126;
    private final int UPS_SET = 200;
    public static boolean roundr = true;
    private Game(){
        panel = new Panel();
        window = new Window(panel);
        panel.requestFocus();
        startgameloop();



    }
    public static Game getInstance(){
        return instance;
    }
    private void startgameloop(){
        thread = new Thread(this);
        thread.start();
    }
    public void update(){
        panel.updategame();
    }

    @Override
    public void run() {
        double timeperframe = 1000000000.0 / FPS_SET;
        double timeperupdate = 1000000000.0 / UPS_SET;
        long perivioustime = System.nanoTime();

        int updates = 0;
        int frames =0;
        long lastCheck = System.currentTimeMillis();
        double deltau = 0;
        double deltaf = 0;
        while(true){
            long currenttime  = System.nanoTime();

            deltau += (currenttime - perivioustime)/ timeperupdate;

            deltaf+= (currenttime - perivioustime)/ timeperframe;
            perivioustime = currenttime;

            if(deltau >= 1){
                update();

                updates++;
                deltau--;
            }
            if(deltaf >= 1){
                panel.repaint();
                frames++;
                deltaf--;
            }


            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                //System.out.println(frames+ "ups"+ updates);
                frames =0;
                updates = 0;
            }

        }
    }
}
