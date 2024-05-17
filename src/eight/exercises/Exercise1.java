package eight.exercises;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {
//        separateOddAndEvenNumbers();
//        removeDuplicateElements();
//        characterFrequencyInString();
//        elementFrequencyInList();
//        sortNumbersInReverse();
//        joinStringList();
//        mergeTwoUnsortedArraysIntoOneSorted();
//        mergeTwoUnsortedArraysIntoOneSortedWithoutDuplicates();
//        threeMaxAndThreeMinNumbersInAList();
//        anagramStrings();
        findSumOfDigitsOfANumber();
//        secondLargestNumberInArray();
//        sortStringListByTheirLength();
//        findCommonElementsInTwoArrays();
//        reverseEachWordInAString();
//        sumOfFirstTenNaturalNumbers();
//        reverseAnIntegerArray();
//        firstTenEvenNumbers();
//        mostRepeatedElementInArray();
//        palindromeProgram();
//        findStringStartingWithANumber();
//        extractDuplicateElementsFromArray();
//        duplicateCharactersInString();
//        findFirstRepeatedCharacterInString();
//        findFirstNoneRepeatedCharacterInString();
//        fibonacciSeries();
//        firstTenOddNumbers();
//        getLastElementOfAnArray();


//        findAgeOfPersonWithGivenBirthDate();

    }

    private static void findAgeOfPersonWithGivenBirthDate() {
        LocalDate birthDay = LocalDate.of(1986, 3, 30);

        LocalDate now = LocalDate.now();

        System.out.println(ChronoUnit.YEARS.between(birthDay, now));
    }

    private static void getLastElementOfAnArray() {
        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");

        String s1 = listOfStrings.stream().skip(listOfStrings.size() - 1).findFirst().orElse("");
        System.out.println(s1);

        Collections.reverse(listOfStrings);
        String s = listOfStrings.stream().findFirst().orElse("");
        System.out.println(s);


    }

    private static void firstTenOddNumbers() {
        IntStream.rangeClosed(0, 9).map(number -> 2 * number + 1).forEach(System.out::println);

    }

    private static void fibonacciSeries() {
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(10)
                .map(f -> f[0])
                .forEach(i -> System.out.print(i + " "));

        System.out.println("");

//        List<Integer> seed = new ArrayList<>();
//        seed.add(0);
//        seed.add(1);
//        List<List<Integer>> lists = Stream.iterate(seed, item -> {
//                    item.add(item.get(item.size() - 1) + item.get(item.size() - 2));
//                    return item;
//                })
//                .limit(10).toList();
//        System.out.println(lists.get(lists.size()-1));

//        first.ifPresent(System.out::println);

    }

    private static void findFirstNoneRepeatedCharacterInString() {
        String inputString = "Java Concept Of The Day";

        Optional<Map.Entry<String, Long>> key = Arrays.stream(inputString.toLowerCase().split(""))
                .collect(Collectors.groupingBy(/*Function.identity()*/str -> str, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();

        key.ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));
    }

    private static void findFirstRepeatedCharacterInString() {
        String inputString = "Java Concept Of The Day";

        Set<String> characters = new HashSet<>();
        String s = Arrays.stream(inputString.toLowerCase().split("")).filter(character -> !characters.add(character)).findFirst().orElse("");
        System.out.println(s);
    }

    private static void duplicateCharactersInString() {
        String inputString = "Java Concept Of The Day";

        Set<String> characters = new HashSet<>();

        List<String> strings = Arrays.stream(inputString.toLowerCase().split("")).filter(character -> !characters.add(character)).distinct().toList();
        System.out.println(strings);
    }

    private static void extractDuplicateElementsFromArray() {
        List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);

        List<Integer> integers = listOfIntegers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).toList();

        System.out.println(integers);

//        Set<Integer> uniqueElements = new HashSet<>();
//
//        Set<Integer> duplicateElements = listOfIntegers.stream().filter(i -> ! uniqueElements.add(i)).collect(Collectors.toSet());
//
//        System.out.println(duplicateElements);
    }

    private static void findStringStartingWithANumber() {
        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");

        List<String> strings = listOfStrings.stream().filter(item -> Character.isDigit(item.charAt(0))).toList();

        System.out.println(strings);
    }

    private static void palindromeProgram() {
        String str = "ROTATOR";

        boolean isItPalindrome = IntStream.range(0, str.length() / 2).
                noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));

        System.out.println("str: " + str + " is" + (isItPalindrome ? "" : " not") + " palindrome");
    }

    private static void mostRepeatedElementInArray() {
        List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");

        listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max((a, b) -> (int) (a.getValue() - b.getValue())).ifPresent(entry -> System.out.println(entry.getKey()));
    }

    private static void firstTenEvenNumbers() {
        IntStream.rangeClosed(1, 10).map(number -> number * 2).forEach(System.out::println);
    }

    private static void reverseAnIntegerArray() {
        int[] array = new int[]{5, 1, 7, 3, 9, 6};

        int[] ints = IntStream.rangeClosed(1, array.length).map(index -> array[array.length - index]).toArray();

        Arrays.stream(ints).forEach(System.out::println);
    }

    private static void sumOfFirstTenNaturalNumbers() {
        int sum = IntStream.range(1, 11).sum();
        System.out.println(sum);
    }

    private static void reverseEachWordInAString() {
        String str = "Java Concept Of The Day";

        String collect = Arrays.stream(str.split(" ")).map(part -> new StringBuilder(part).reverse()).collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    private static void findCommonElementsInTwoArrays() {
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28, 28);

        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);

        List<Integer> integers = Stream.concat(list1.stream().distinct(), list2.stream().distinct())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(integers);
    }

    private static void sortStringListByTheirLength() {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

        List<String> strings = listOfStrings.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println(strings);
    }

    private static void secondLargestNumberInArray() {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        Integer integer = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);

        System.out.println(integer);
    }

    private static void findSumOfDigitsOfANumber() {
        int a = 15623;

        int sum = Stream.of(String.valueOf(a).split("")).mapToInt(Integer::valueOf).sum();
        System.out.println(sum);
    }

    private static void anagramStrings() {
        String s1 = "RaceCar";
        String s2 = "CarRace";

        String collect1 = Stream.of(s1.split("")).sorted().collect(Collectors.joining());
        String collect2 = Stream.of(s2.split("")).sorted().collect(Collectors.joining());

        System.out.println("s1: " + s1 + " and s2: " + s2 + " are " + (collect1.equalsIgnoreCase(collect2) ? "" : "not ") + "anagrams");
    }

    private static void threeMaxAndThreeMinNumbersInAList() {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        List<Integer> collectMin = listOfIntegers.stream().sorted().limit(3).collect(Collectors.toList());
        List<Integer> collectMax = listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());

        System.out.println(collectMin);
        System.out.println(collectMax);
    }

    private static void mergeTwoUnsortedArraysIntoOneSortedWithoutDuplicates() {
        int[] a = new int[]{4, 2, 5, 1};

        int[] b = new int[]{8, 1, 9, 5};

        int[] ints = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
        Arrays.stream(ints).forEach(System.out::println);

    }

    private static void mergeTwoUnsortedArraysIntoOneSorted() {
        int[] a = new int[]{4, 2, 7, 1};

        int[] b = new int[]{8, 3, 9, 5};

        int[] ints = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        Arrays.stream(ints).forEach(System.out::println);
    }


    private static void joinStringList() {
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");

        String s = listOfStrings.stream().reduce("", (a, b) -> a + "[" + b + "], ");
        System.out.println(s);

        String collect = listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));
    }

    private static void sortNumbersInReverse() {
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        decimalList.sort(Comparator.reverseOrder());

        System.out.println(decimalList);
    }

    private static void elementFrequencyInList() {
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> collect = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
    }

    private static void characterFrequencyInString() {
        String inputString = "Java Concept Of The Day";

        Map<String, Long> collect = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    private static void removeDuplicateElements() {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");

        List<String> strings = listOfStrings.stream().distinct().toList();
        System.out.println(strings);
    }

    private static void separateOddAndEvenNumbers() {
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

        Map<Boolean, List<Integer>> collect = listOfIntegers.stream().collect(Collectors.groupingBy(number -> number % 2 == 0));

        System.out.println(collect);

    }
}
