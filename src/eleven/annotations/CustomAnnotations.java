package eleven.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

enum Device {LAPTOP, PHONE}

// a marker annotation
@interface Human {
}

@Retention(RetentionPolicy.RUNTIME)
@interface OnWeb {
    // just like an interface, these elements are abstract and public.
    // cannot be protected, private or final.
    int startTime() default 0;  // optional (cause it has default value)

    int hoursPerDay();          // not optional because it does not have default value

    // these are constants are not considered elements
    int PEAK_TIME_START = 19;
    public static final int PEAK_END_TIME = 22;


    // the element type must be a primitive type: a String, an enum, Class, another annotation or an array.
    // wrapper types not allowed(Integer, Long, Double, Boolean, ...)
    String name() default "PH";

    Device consume() default Device.LAPTOP;

    Class humanOrBot() default Human.class;

    Human extractInfo() default @Human; // Note: 'new' keyword is never used for annotations

    String[] sites() default {"P", "H"}; // only one dimensional arrays allowed
}

// hoursPerDay does not have default value, so it is mandatory
// other attributes are given default values, so they are optional
@OnWeb(hoursPerDay = 6)
@Human
class Student {
}

// hoursPerDay does not have default value so it is mandatory
// here we replace the default value for startTime
@OnWeb(hoursPerDay = 3, startTime = 18)
@Human
class Worker {
}

public class CustomAnnotations {
    public static void main(String[] args) {
        Class<Worker> workerClass = Worker.class;
        OnWeb annotation = workerClass.getAnnotation(OnWeb.class);
        System.out.println(annotation.name());
        System.out.println(annotation.consume());
        System.out.println(annotation.startTime());
    }
}
