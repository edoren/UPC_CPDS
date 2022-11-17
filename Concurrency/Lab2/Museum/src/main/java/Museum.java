import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Museum {
    public static void main(String[] args) throws InterruptedException {
        Control control = new Control();

        Thread director = new Director(control);
        director.setName("Director");

        Thread east = new East(control);
        Thread west = new West(control);

        List<Thread> threads = Arrays.asList(east, west, director);

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    public static List<Thread> createVisitors(Control control, List<String> users) {
        List<Thread> threads = new ArrayList<Thread>();

        Thread east = new East(control);
        Thread west = new West(control);

        return threads;
    }
}
