package concurrency.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SubmittingTaskCollections {
//    private static ExecutorService service = Executors.newSingleThreadExecutor();
    private static ExecutorService service = Executors.newFixedThreadPool(4);

    private static List<Callable<String>> callables = new ArrayList<>();

    public static void main(String[] args) {
        callables.add(() -> "A");
        callables.add(() -> "B");
        callables.add(() -> "C");
        callables.add(() -> "D");

//        invokeAny();
        invokeAll();
    }

    public static void invokeAny() {
        String result = null;
        try {
            result = service.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
        System.out.println("Enddddddd");
    }

    public static void invokeAll() {
        List<Future<String>> results = null;
        try {
            results = service.invokeAll(callables);
            results.forEach(result -> {
                try {
                    System.out.println(result.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
        System.out.println("END");
    }
}
