package seventeen.switchpaptterns;

public class PatternMatching {
    // as PatternMatching is a preview feature,
    // and it is not covered in java21
    // you should set language level to:
    // 17 (Preview) - Pattern matching for switch

    // and add --enable-preview to Program Arguments
    public static void main(String[] args) {
        whatType("ABC");
        whatType(122);
        whatType(null);
        whatType(32.32);
        System.out.println("-------------------");
        infoOnType("ABC");
        infoOnType("BC");
        infoOnType(122);
        infoOnType(2);
        infoOnType(null);
        infoOnType(23.33);

    }

    public static void whatType(Object o) {
        switch (o) {
            // since Java 16 there is Pattern matching for instanceof. it introduces new language enhancements that enables
            // you to conditionally extract data from objects with code.
            // note the 's' and 'i' here
            case String s -> System.out.println("String");
            case Integer i -> System.out.println("Integer");
            case null -> System.out.println("Null");
            default -> System.out.println("Not Recognized");
        }
    }

    public static void infoOnType(Object o) {
/*
        switch (o) {
            case String s && s.startsWith("A") -> System.out.println("String beginning with A: " + s.startsWith("A") + " " + s);
            case Integer i && i.intValue() > 10 -> System.out.println("Integer > 10 : " + i);
            case null -> System.out.println("Null");
            default -> System.out.println("Not Recognized");
        }
*/
    }
}
