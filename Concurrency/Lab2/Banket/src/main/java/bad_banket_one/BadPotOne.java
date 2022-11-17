package bad_banket_one;

import interfaces.IPot;

public class BadPotOne implements IPot {
    private int servings = 0;
    private int capacity;

    public BadPotOne(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void getserving() throws InterruptedException {
        // Condition synchronization: at least one serving available,
        // otherwise, go to the Waiting Set til the cook fill the pot
        if (servings == 0) {
            System.out.println(Thread.currentThread().getName() + " has to wait");
            wait(5000);
        }
        Thread.sleep(200);
        --servings;
        System.out.println(Thread.currentThread().getName() + " is served");
        // when necessary, wake up threads in Waiting Set in order to asure
        // a runnable cook
        if (servings == 0) {
            notifyAll();
        }
        print_servings();
    }

    public synchronized void fillpot() throws InterruptedException {
        //Condition synchronization: .....
        //....
        if (servings > 0) {
            System.out.println(Thread.currentThread().getName() + " has to wait");
            wait(5000);
        }
        System.out.println(Thread.currentThread().getName() + " fills the pot");
        servings = capacity;
        // wake up threads in Waiting Set in order to asure....
        print_servings();
        notifyAll();
    }

    //only for trace purposes
    public synchronized void print_servings() {
        System.out.println("servings in the pot: " + servings);
    }
}