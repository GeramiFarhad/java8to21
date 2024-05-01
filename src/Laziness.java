import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Laziness {
    public static void main(String[] args) {
        List<String> names =
                Arrays.asList("April", "Ben", "Charlie",
                        "David", "Benildus", "Christian");
//        names.stream()
//            .peek(System.out::println)
//            .filter(s -> {
//                System.out.println("filter1 : "+s);
//                return s.startsWith("B") || s.startsWith("C"); } )
//            .filter(s -> {
//                System.out.println("filter2 : "+s);
//                return s.length() > 3; } )
//            .limit(1) // intermediate operation  Stream<T> limit(long)
//            .forEach(System.out::println);  // terminal operation

//        names.stream()
//                .peek(System.out::println)
//                .map(name -> {
//                    System.out.println("map: " + name);
//                    return name.toUpperCase();
//                })
//                .anyMatch(name -> {
//                    System.out.println("anyMatch: " + name);
//                    return name.startsWith("C");
//                });

        List<Integer> numbers = List.of(1);
        Integer reduce = numbers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        Optional<Integer> min = numbers.stream().min(Comparator.naturalOrder());
//        boolean b = someMethod(numbers);
        System.out.println(min);
    }

    public static boolean someMethod(List<Integer> numbers) {
        return numbers.stream().anyMatch
                (number -> {
                            System.out.println("Numbers: " + numbers);
                            System.out.println("Number: " + number);
                            return (number > 10) ? true : someMethod(numbers.stream().skip(1).toList());
                        }
                );
    }
}


/* Output:
April                   - peek
filter1 : April         - filter1 removes April
Ben                     - peek
filter1 : Ben           - filter1 passes Ben on 
filter2 : Ben           - filter2 removes Ben
Charlie                 - peek
filter1 : Charlie       - filter1 passes Charlie on
filter2 : Charlie       - filter2 passes Charlie on
Charlie                 - forEach()

Note: limit(1) means David, Benildus or Christian are not 
      processed at all i.e. none of them appear in the output
      via "peek()"
*/