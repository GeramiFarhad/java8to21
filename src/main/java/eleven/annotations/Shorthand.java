package eleven.annotations;


@interface Team {
    String value() default "Soccer";

    int numPlayers() default 2;
}

class Sport {
    @Team(numPlayers = 6, value = "Volleyball")
    void beach() {
    }

    ;    // all provided

    @Team(value = "Tennis")
    void strawberriesAndCream() {
    }          // numPlayers omitted


    @Team("Curling")
    void slow() {
    }

    ;                                // numPlayers omitted, "value=" omitted too
}

@interface Quiz {
    String[] topics();
}

class Competitor {
    @Quiz(topics = {"A", "B"})
    String favouriteTopic;

    // arrays with ONLY one element
    @Quiz(topics = {"C"})
    String leastFavouriteTopic;
    @Quiz(topics = "D")
    String leastOtherFavouriteTopic;    // compiler inserts the {}

//    @Quiz(topics = "A", "B") String notValid1;
//    @Quiz(topics = null) String notValid2;
}

@interface Colours {
    String[] value();
}

// combining both above shorthands
class TestRainbow {
    @Colours(value = {"RED"})
    String colour1;
    @Colours(value = "RED")
    String colour2;
    @Colours({"RED"})
    String colour3;
    @Colours("RED")
    String colour4;

    public String getColour1() {
        return colour1;
    }

    public void setColour1(String colour1) {
        this.colour1 = colour1;
    }

    public String getColour2() {
        return colour2;
    }

    public void setColour2(String colour2) {
        this.colour2 = colour2;
    }

    public String getColour3() {
        return colour3;
    }

    public void setColour3(String colour3) {
        this.colour3 = colour3;
    }

    public String getColour4() {
        return colour4;
    }

    public void setColour4(String colour4) {
        this.colour4 = colour4;
    }
}


public class Shorthand {
}
