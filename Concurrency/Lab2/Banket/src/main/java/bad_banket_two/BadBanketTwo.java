package bad_banket_two;

import common.Cook;
import common.Savage;

import java.util.Arrays;
import java.util.List;

public class BadBanketTwo {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads;
        BadPotTwo pot = new BadPotTwo(5);
        Thread s1 = new Savage(pot); s1.setName("alice");
        Thread s2 = new Savage(pot); s2.setName("bob");
        Thread s3= new Savage(pot); s3.setName("peter");
        Thread s4= new Savage(pot); s4.setName("xana");
        Thread s5 = new Savage(pot); s5.setName("tom");
        Thread s6 = new Savage(pot); s6.setName("jerry");
        Thread s7= new Savage(pot); s7.setName("kim");
        Thread s8= new Savage(pot); s8.setName("berta");
        Thread c = new Cook(pot); c.setName("cook");
        threads = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, c);
        for (Thread t: threads) {
            t.start();
        }
        for (Thread t: threads) {
            t.join();
        }
    }
}
