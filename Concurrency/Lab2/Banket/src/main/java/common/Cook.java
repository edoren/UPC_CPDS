package common;

import interfaces.IPot;

public class Cook extends Thread {
    IPot pot;

    public Cook(IPot pot) {
        this.pot = pot;
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " would like to fill the pot");
            try {
                Thread.sleep(200);
                pot.fillpot();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}