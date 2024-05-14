package eight.concurrency.executorservice;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Integer> future = service.submit(new MyLongCallable());
        System.out.println("START");
        try {
            System.out.println(future.get(1500, TimeUnit.MILLISECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }

        System.out.println("SHUTDOWN");
        service.shutdown();
    }
}
