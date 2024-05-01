package concurrency.executorservice;

import java.util.concurrent.Callable;

public class MyLongCallable implements Callable<java.lang.Integer> {
    @Override
    public java.lang.Integer call() throws Exception {
        Thread.sleep(1000);
        return 8;
    }
}
