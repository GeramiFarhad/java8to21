package eleven;

public class PrivateInterfaceMethod {

    public static void main(String[] args) {
        Tennis tennis = new ProfessionalTennis();
//    tennis.hit(); it is private, it is encapsulated in Tennis interface
        tennis.backhand();
        Tennis.forehand();
    }
//    void x() {
//        main(null);
//    }
}

interface InefficientTennis {
    static void forehand() {
        System.out.println("Move into position");
        System.out.println("Hitting a forehand");
        System.out.println("Move back to ready position");
    }

    default void backHand() {
        System.out.println("Move into position");
        System.out.println("Hitting a backhand");
        System.out.println("Move back to ready position");
    }

    default void smash() {
        System.out.println("Move into position");
        System.out.println("Hitting a smash");
        System.out.println("Move back to ready position");
    }
}

interface Tennis {
    private static void hit(String stroke) {
        System.out.println("Move into position");
        System.out.println("Hitting a " + stroke);
        System.out.println("Move back to ready position");
    }

    static void forehand() {
        hit("forehand");
    }

    default void backhand() {
        hit("backhand");
    }

    private void smash() {
        hit("smash");
    }

/*
    not valid because PRIVATE and DEFAULT can not put together. DEFAULT is intended to be used by classes which implement
    the interface. but PRIVATE is just private to interface
*/
//    private default void rest() {
//
//    }


//    not valid because it is an abstract method and can not have a body
//    void volley() {
//        hit("forehand");
//    }
}

class ProfessionalTennis implements Tennis {

}