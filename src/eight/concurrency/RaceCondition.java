package eight.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int balance) {
        this.balance -= balance;
    }
}

public class RaceCondition implements Runnable {
    private BankAccount bankAccount = new BankAccount();

    public static void main(String[] args) {
        Runnable r = new RaceCondition();

        Thread john = new Thread(r);
        john.setName("John");
        Thread mary = new Thread(r);
        mary.setName("Mary");

        john.start();
        mary.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
             makeWithdrawal(10);
             if (bankAccount.getBalance() < 0) {
                 System.out.println("Account is overdrawn");
             }

             try {
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }

        }
    }

    private Lock lock = new ReentrantLock();
    private /*synchronized*/ void makeWithdrawal(int amount) {
        try {
            lock.lock();
            if (bankAccount.getBalance() >= amount) {
                System.out.println(Thread.currentThread().getName() + ". Balance Before: " + bankAccount.getBalance());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                bankAccount.withdraw(amount);
                System.out.println(Thread.currentThread().getName() + ". Balance After: " + bankAccount.getBalance());
            } else {
                System.out.println(Thread.currentThread().getName() + ". Unable to withdraw " + amount + ". Balance Before: " + bankAccount.getBalance());
            }
        } finally {
            lock.unlock();
        }
    }
}