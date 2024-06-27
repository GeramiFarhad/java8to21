package eleven.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target({ElementType.FIELD, ElementType.PARAMETER}) // Situation-1
//@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR}) // Situation-2
@Target({ElementType.TYPE_USE}) // Situation-3
@interface DataItem {

}

// on Situation-1 gets an error (no method targeted)
// on Situation-2 gets an error (no method targeted)
@DataItem
class X {
}

// on Situation-1 gets an error (no method targeted)
// on Situation-2 gets an error (no method targeted)
@DataItem
interface Y {

}

class Z {
    @DataItem
    int a;

    @DataItem
    static int b;

    // on Situation-1 gets an error (no constructor targeted)
    // on Situation-2 is safe
    @DataItem
    Z() {
    }

    void m1(@DataItem int a) {
    }
}


@Target(ElementType.TYPE_USE)
@interface WildCard {
}

class X1 {
    @WildCard
    int x;

    @WildCard
    static int y;

    void m1(@WildCard int a) {
        @WildCard int z = 0;
        var x1 = new @WildCard X1();    // if the target gets commented out, this line gets an error

        int n = (@WildCard int) 23.9;   // if the target gets commented out, this line gets an error
    }
}

public class TargetExample {
}
