package eight.courses.concurrency;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountDown implements Runnable {
    private String[] timeStr = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    @Override
    public void run() {
        List<String> collect = Arrays.stream(timeStr).collect(Collectors.toList());
        Collections.reverse(collect);

        for (String s : collect) {
            System.out.println(s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
