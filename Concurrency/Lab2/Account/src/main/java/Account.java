public class Account {
    int balance = 0;

    public synchronized void deposit(int amount) throws InterruptedException {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " is depositing. New balance: " + balance + " coins");
        notify();
    }

    public synchronized void withdraw(int amount) throws InterruptedException {
        while ((balance - amount) < 0) {
            wait(1000);
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " is withdrawing. New balance: " + balance + " coins");
        notifyAll();
    }
}
