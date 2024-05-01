import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLearning {
    public static void main(String[] args) {
        List<Person1> person1s = Stream.generate(StreamLearning::generateRandomPerson1).limit(100).toList();
//        doubles.forEach(System.out::println);
        List<Integer> numbers = Stream.generate(() -> (int) (Math.random() * 100)).limit(20).toList();
        List<String> strings = Stream.generate(StreamLearning::generateString).limit(30).toList();

//        Double average = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));
//        System.out.println(average);
//
//        Double collect1 = strings.stream().collect(Collectors.averagingInt(String::length));
//        System.out.println(collect1);
//        String collect = strings.stream().collect(Collectors.joining(", ", "( ", " )"));
//        System.out.println(collect);
//
//        Map<String, Integer> collect2 = strings.stream().collect(Collectors.toMap(s -> s, String::length, (s1, s2) -> s1));
//        System.out.println(collect2);
//
//        Map<Integer, String> collect3 = strings.stream().collect(Collectors.toMap(String::length, s -> s, (s1, s2) -> s1 + ", " + s2, TreeMap::new));
//        System.out.println(collect3);
//
//        Map<Integer, List<String>> collect4 = strings.stream().collect(Collectors.groupingBy(String::length));
//        System.out.println(collect4);
//
        Map<Integer, Set<String>> collect5 = strings.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
//        System.out.println(collect5);

//        boolean a = strings.stream().peek(System.out::println).filter(s -> {
//            System.out.println(strings.indexOf(s) + " ... " + s);
//            return s.length() > 5;
//        }).anyMatch(s -> s.startsWith("a"));/*.forEach(System.out::println)*/
//        System.out.println(a);

//        Optional<Integer> first = numbers.stream().findFirst();


        strings.stream().peek(System.out::println).flatMap(s -> Arrays.stream(s.split("")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key,value) -> System.out.println(key + " : " + value));
    }

    public static boolean someMethod(int i) {
        return i > 2;
    }

    private static Person1 generateRandomPerson1() {
//        int nullChance = (int) (Math.random() * 100);
//        if (nullChance < 50) {
//            return null;
//        }

        return new Person1(generateString(), (int) (Math.random() * 100));
    }

    private static String generateString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = (int) (Math.random() * 10) + 2;

        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

}

class Person1 {
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
