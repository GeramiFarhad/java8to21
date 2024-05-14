package eight.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        es.submit(() -> System.out.println("Runnable Exapmle"));

        es.shutdown();
    }
}
