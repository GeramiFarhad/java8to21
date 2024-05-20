package eleven.annotations;

import java.lang.annotation.Repeatable;

// this is the container interface
@interface Batteries {      // by convention, the plural of the annotation is used
    Battery[] value();      // must be value()
}

// this is the annotation we want to repeat
@Repeatable(Batteries.class)
@interface Battery {
    String level();

    boolean recharge();
}

@Battery(level = "high", recharge = false)
@Battery(level = "low", recharge = true)
class ElectricCar {
}

public class RepeatableExample {

}
