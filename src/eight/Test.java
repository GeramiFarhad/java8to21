package eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Predicate<Integer> p = t -> t > 0;

        int[] numbers = {1,2,3};

        List<Integer> numbersList = new ArrayList<>(20);
        numbersList.add(1);
        IntStream intStream = Arrays.stream(numbers).filter(number -> number > 1);
        System.out.println(numbersList.size());
        System.out.println(check(1, p));
    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}
