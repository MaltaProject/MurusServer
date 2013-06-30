package maltaProject;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The game keeper manages the game ticks. These ticks control movements of NPC's, and server
 * resets.
 * 
 * 
 * @author Nicholas Ingalls
 * 
 */
public class GameKeeper extends Thread {
    Timer timer;
    String database = "";

    /**
     * Passes on the database location to the game keeper
     * @param data
     */
    public GameKeeper(String data) {
        database = data;
        System.out.println("[GameKeeper] I am active, fear me.");
    }

    public void controller() {

        System.out.println("Game Keeper Tick");

        // Start Timer Again
        int milliseconds = 500;
        timer = new Timer();
        timer.schedule(new RemindTask(), milliseconds);
    }

    class RemindTask extends TimerTask {
        @Override
        public void run() {
            timer.cancel();
            controller();

        }

    }
}
