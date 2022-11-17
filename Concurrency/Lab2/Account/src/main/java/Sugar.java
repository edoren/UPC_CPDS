import java.util.concurrent.ThreadLocalRandom;

public class Sugar implements Runnable {
    Account account;

    public Sugar(Account account) {
        this.account = account;
    }

    public void run() {
        while (true) {
            try {
                int amount = ThreadLocalRandom.current().nextInt(10, 16);
                System.out.println(Thread.currentThread().getName() + " wants to deposit " + amount + " coins");
                account.deposit(amount);
                Thread.sleep(30000);
            } catch (InterruptedException e) {
            }
        }
    }
}