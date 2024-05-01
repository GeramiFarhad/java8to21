package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixRaceWithLock {
    private static int count = 0;
    private static Lock lock = new ReentrantLock();

    public static void addToCounterWithLockMethod() {
        try {
            lock.lock();
            int c = count;
            System.out.println("Before: " + count + " Thread id: " + Thread.currentThread().getId());
            count = c + 1;
            System.out.println("After: " + count + " Thread id: " + Thread.currentThread().getId());
        } finally {
            lock.unlock();
        }
    }

    public static void addToCounterWithTryLockMethod() {
        if (lock.tryLock()) {
            try {
                int c = count;
                System.out.println("Before: " + count + " Thread id: " + Thread.currentThread().getId());
                count = c + 1;
                System.out.println("After: " + count + " Thread id: " + Thread.currentThread().getId());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Thread id: " + Thread.currentThread().getId() + " couldn't get lock");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            service.submit(FixRaceWithLock::addToCounterWithTryLockMethod);
        }

        service.shutdown();
    }

}
