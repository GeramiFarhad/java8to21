package seventeen.record;

public class CarMain {
    public static void main(String[] args) {
        // regular class
        Car car = new Car("regNumber123", "owner123");
        System.out.println(car);
        System.out.println(car.getOwner());
        System.out.println(car.getRegNumber());

        // using record
        CarRecord carRecord = new CarRecord("regNumber456", "owner456");
        System.out.println(carRecord);
        System.out.println(carRecord.owner()); // no GET prefix
        System.out.println(carRecord.regNumber()); // no GET prefix

        // define an instance method; cannot define an instance field; can define static field
        System.out.println(carRecord.isNewCar());
        System.out.println(carRecord.currentYear);

        // define an static method
        CarRecord blank = CarRecord.createBlankCarRecord();
        System.out.println(blank);

    }
}
