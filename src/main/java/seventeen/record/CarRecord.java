package seventeen.record;

// regNumber and owner are known as COMPONENTS
// records can implement interfaces
// records can not extend other types
public record CarRecord(String regNumber, String owner) /*extends Number*/ implements I {
    //    static final fields are allowed
    public static final String currentYear = "23";
/*
//    instance fields must be listed in constructor signature above
    private final boolean isNewCar;
*/

    //    instance methods are allowed
    public boolean isNewCar() {
        return regNumber().substring(0, 2).equals(currentYear);
    }

    // static methods are allowed
    public static CarRecord createBlankCarRecord() {
        return new CarRecord("     ", "");
    }

//    custom canonical constructor
/*
    public CarRecord(String regNumber, String owner) {
        if (regNumber.length() <= 4) {
            throw new IllegalArgumentException();
        }
        this.regNumber = regNumber;
        this.owner = owner;
    }
*/

    //    custom compact constructor
    public CarRecord {
        if (regNumber.length() <= 4) {
            throw new IllegalArgumentException();
        }
    }

    //  non-canonical constructor
    public CarRecord() {
        //  Non-canonical record constructor must delegate to another constructor
        this("     ", "");
    }

    //    override an accessor method
    //    no GET prefix
    public String owner() {
        return "owner overridden: " + owner;
    }
}

//  as Records are final, they cannot be extended
/*
class X extends CarRecord {

}
*/

interface I {

}