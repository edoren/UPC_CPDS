public class Director extends Thread {
    Control control;

    public Director(Control control) {
        this.control = control;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " is opening the museum");
                control.open();
                Thread.sleep(20000);
                System.out.println(Thread.currentThread().getName() + " is closing the museum");
                control.close();
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}