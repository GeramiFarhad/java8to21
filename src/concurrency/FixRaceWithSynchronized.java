package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixRaceWithSynchronized {
    private static int count = 0;

    public static synchronized void addToCounterStaticMethod() {
        int c = count;
        System.out.println("Before: " + count + " Thread id: " + Thread.currentThread().getId());
        count = c + 1;
        System.out.println("After: " + count + " Thread id: " + Thread.currentThread().getId());
    }

    public static void addToCounterSynchronizedBlock() {
        synchronized (FixRaceWithSynchronized.class) {
            int c = count;
            System.out.println("Before: " + count + " Thread id: " + Thread.currentThread().getId());
            count = c + 1;
            System.out.println("After: " + count + " Thread id: " + Thread.currentThread().getId());
        }
    }

    private static Object lock = new Object();
    public static void addToCounterSynchronizedLock() {
        synchronized (lock) {
            int c = count;
            System.out.println("Before: " + count + " Thread id: " + Thread.currentThread().getId());
            count = c + 1;
            System.out.println("After: " + count + " Thread id: " + Thread.currentThread().getId());
        }
    }

    public void addToCounterSynchronizedOnThis() {
        synchronized (this) {
            int c = count;
            System.out.println("Before: " + count + " Thread id: " + Thread.currentThread().getId());
            count = c + 1;
            System.out.println("After: " + count + " Thread id: " + Thread.currentThread().getId());
        }
    }


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            service.submit(FixRaceWithSynchronized::addToCounterStaticMethod);
        }

//        FixRaceWithSynchronized that = new FixRaceWithSynchronized();
//        for (int i = 0; i < 10; i++) {
//            service.submit(that::addToCounterSynchronizedOnThis);
//        }

        service.shutdown();
    }
}
