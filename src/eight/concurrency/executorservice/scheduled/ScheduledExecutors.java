package eight.concurrency.executorservice.scheduled;

import java.util.concurrent.*;

public class ScheduledExecutors {
    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
//        schedule();
//        scheduleWithFixedDelay();
        scheduleAtFixedRate();

    }


    private static void schedule() {
        System.out.println("Start...");
        ScheduledFuture<String> schedule = scheduledExecutorService.schedule(() -> "A", 2, TimeUnit.SECONDS);
        try {
            System.out.println(schedule.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
//            scheduledExecutorService.shutdown();
        }
        System.out.println("...Finish");
    }

    private static void scheduleWithFixedDelay() {
        System.out.println("Start...");
        long initialDelay = 2000;
        long wait = 300;

        scheduledExecutorService.scheduleWithFixedDelay(
                () -> System.out.println("Thread id: " + Thread.currentThread().getId()), initialDelay, wait, TimeUnit.MILLISECONDS
        );
    }

    private static void scheduleAtFixedRate() {
        System.out.println("Start...");
        long initial = 2000;
        long wait = 300;

        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getId()), initial, wait, TimeUnit.MILLISECONDS);
    }
}
