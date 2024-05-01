package concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VariousTypes {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        int cpuCount = Runtime.getRuntime().availableProcessors();
        System.out.println(cpuCount);
        ExecutorService service1 = Executors.newFixedThreadPool(cpuCount);

        ExecutorService service2 = Executors.newSingleThreadExecutor();
    }
}
