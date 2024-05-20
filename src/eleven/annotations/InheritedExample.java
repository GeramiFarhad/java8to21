package eleven.annotations;

// 1. Apply directly.
// 2. Apply via inheritance.

import java.lang.annotation.Inherited;

//@interface BreatheInWater{}
@Inherited
@interface BreatheInWater {
} // this is an inheritable annotation

@BreatheInWater
class Fish {
}

// no need to annotate Trout class with @BreatheInWater
class Trout extends Fish {
}

public class InheritedExample {

}
