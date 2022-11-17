import java.util.concurrent.ThreadLocalRandom;

public class East extends Thread {
    Control control;

    public East(Control control) {
        this.control = control;
    }

    public void run() {
        while (true) {
            try {
                control.arrive();
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1500));
            } catch (InterruptedException e) {
            }
        }
    }
}