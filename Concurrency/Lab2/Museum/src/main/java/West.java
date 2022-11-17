import java.util.concurrent.ThreadLocalRandom;

public class West extends Thread {
    Control control;

    public West(Control control) {
        this.control = control;
    }

    public void run() {
        while (true) {
            try {
                control.leave();
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
            } catch (InterruptedException e) {
            }
        }
    }
}