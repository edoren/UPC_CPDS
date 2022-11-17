package bad_banket_two;

import interfaces.IPot;

import java.util.concurrent.atomic.AtomicInteger;

public class BadPotTwo implements IPot {
    private AtomicInteger servings = new AtomicInteger(0);
    private int capacity;

    public BadPotTwo(int capacity) {
        this.capacity = capacity;
    }

    public void getserving() throws InterruptedException {
        if (servings.get() == 0) {
            System.out.println(Thread.currentThread().getName() + " has to wait");
//            wait(5000);
        } else {
            Thread.sleep(200);
            servings.decrementAndGet();
            System.out.println(Thread.currentThread().getName() + " is served");
//            if (servings == 0) {
//                notifyAll();
//            }
            print_servings();
        }
    }

    public void fillpot() throws InterruptedException {
        if (servings.get() > 0) {
            System.out.println(Thread.currentThread().getName() + " has to wait");
//            wait(5000);
        } else {
            System.out.println(Thread.currentThread().getName() + " fills the pot");
            servings.set(capacity);
            // wake up threads in Waiting Set in order to asure....
            print_servings();
//            notifyAll();
        }
    }

    //only for trace purposes
    public synchronized void print_servings() {
        System.out.println("servings in the pot: " + servings);
    }
}