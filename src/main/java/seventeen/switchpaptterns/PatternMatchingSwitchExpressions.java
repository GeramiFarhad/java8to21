package seventeen.switchpaptterns;

sealed abstract class Vehicle permits Car, Boat, Train {
}

final class Car extends Vehicle {
    public String onRoad() {
        return "Car can move on road";
    }
}

final class Boat extends Vehicle {

}

final class Train extends Vehicle {

}

public class PatternMatchingSwitchExpressions {
    public static void ifStatements(Vehicle v) {
        if (v instanceof Car c) {
            // since Java 16 there is Pattern matching for instanceof. it introduces new language enhancements that enables
            // you to conditionally extract data from objects with code.
            // note the 'c' here, this is called "type pattern"
            System.out.println("It is a Car: " + c.onRoad());
        } else if (v instanceof Boat) {
            System.out.println("It is a Boat");
        } else if (v instanceof Train) {
            System.out.println("It is a Train");
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void patternMatchingSwitch(Vehicle v) {
        switch (v) {
            case Car c -> {
                System.out.println("PatMat: some logic1");
                System.out.println("PatMat: It is a Car: " + c.onRoad());
                System.out.println("PatMat: some logic2");
            }
            case Boat b -> System.out.println("PatMat: It is a Boat");
            case Train t -> System.out.println("PatMat: It is a Train");
            default -> throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        ifStatements(new Car());
        ifStatements(new Boat());
        ifStatements(new Train());
//        ifStatements(null);
        System.out.println("----------------------------");
        patternMatchingSwitch(new Car());
        patternMatchingSwitch(new Boat());
        patternMatchingSwitch(new Train());
        patternMatchingSwitch(null);
    }
}
