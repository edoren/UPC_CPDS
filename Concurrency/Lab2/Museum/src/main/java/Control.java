public class Control {
    int count = 0;
    boolean opened = false;

    public synchronized void arrive() throws InterruptedException {
        while (!opened) {
            wait(1000);
        }
        count += 1;
        System.out.println("Person arrived (count = " + count + ")");
        notify();
    }

    public synchronized void leave() throws InterruptedException {
        while (count <= 0) {
            wait(1000);
        }

        count -= 1;
        System.out.println("Person leave (count = " + count + ")");
        notify();
//        if (count == 0) {
//            // ....
//        }
    }

    public synchronized void open() throws InterruptedException {
        opened = true;
        notifyAll();
    }

    public synchronized void close() throws InterruptedException {
        opened = false;
        notifyAll();
    }
}
