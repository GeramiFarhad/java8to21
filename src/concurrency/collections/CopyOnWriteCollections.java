package concurrency.collections;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteCollections {
    public static void main(String[] args) {
        List<String> names = new CopyOnWriteArrayList<>();
        names.add("Ann");
        names.add("Annn");
        names.add("Annnn");

        for (String name : names) {
            System.out.println(name);
            names.add(name);
        }
        System.out.println(names);
        System.out.println("---------------------------------------------");
        Set<String> uniqueNames = new ConcurrentSkipListSet<>();
        uniqueNames.add("A");
        uniqueNames.add("B");
        uniqueNames.add("C");

        for (String uniqueName : uniqueNames) {
            System.out.println(uniqueName);
            uniqueNames.add(uniqueName+"2");
        }
        System.out.println(uniqueNames);
        System.out.println("size: " + uniqueNames.size());
    }
}
