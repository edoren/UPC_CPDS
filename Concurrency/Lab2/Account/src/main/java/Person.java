import java.util.concurrent.ThreadLocalRandom;

public class Person implements Runnable {
    Account account;

    public Person(Account account) {
        this.account = account;
    }

    public void run() {
        while (true) {
            try {
                if (ThreadLocalRandom.current().nextBoolean()) {
                    int amount = ThreadLocalRandom.current().nextInt(1, 6);
                    System.out.println(Thread.currentThread().getName() + " wants to deposit " + amount + " coins");
                    account.deposit(amount);
                } else {
                    int amount = ThreadLocalRandom.current().nextInt(4, 10);
                    System.out.println(Thread.currentThread().getName() + " wants to withdraw " + amount + " coins");
                    account.withdraw(amount);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}