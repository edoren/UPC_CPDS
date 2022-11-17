package banket;

import common.Cook;
import common.Savage;

public class Banket {
    public static void main(String[] args) throws InterruptedException {
        Pot pot = new Pot(5);
        Thread a = new Savage(pot);
        a.setName("alice");
        Thread b = new Savage(pot);
        b.setName("bob");
        Thread c = new Cook(pot);
        c.setName("cook");
        a.start();
        b.start();
        c.start();
        a.join();
        b.join();
        c.join();
    }
}
