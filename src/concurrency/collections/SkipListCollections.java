package concurrency.collections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SkipListCollections {
    public static void main(String[] args) {
        Set<String> countries = new ConcurrentSkipListSet<>();
        countries.add("Z");
        countries.add("A");
        countries.add("F");

        countries.forEach(System.out::println);

        Map<String,Integer> map = new ConcurrentSkipListMap<>();
        map.put("Z", 1);
        map.put("A", 2);
        map.put("F", 3);

        map.keySet().forEach(System.out::println);

    }
}
