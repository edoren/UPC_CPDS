import java.util.Arrays;
import java.util.List;

public class SavingAccount {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        Thread alice = new Thread(new Person(account));
        alice.setName("Alice");

        Thread bob = new Thread(new Person(account));
        bob.setName("Bob");

        Thread sugar = new Thread(new Sugar(account));
        sugar.setName("Sugar");  // The third participant that deposits money only

        List<Thread> threads = Arrays.asList(alice, bob, sugar);

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }
}
