package eight.concurrency.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TheProblem {
    public static void main(String[] args) {
//        Map<String,String> capitalCities = new HashMap<>();
        Map<String,String> capitalCities = new ConcurrentHashMap<>();

        capitalCities.put("A", "a");
        capitalCities.put("B", "b");

        for (String s : capitalCities.keySet()) {
            System.out.println(s);
            capitalCities.remove(s);
        }

    }
}
