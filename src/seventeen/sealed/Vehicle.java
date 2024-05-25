package seventeen.sealed;

sealed interface Drivable permits Vehicle {

}

public sealed class Vehicle implements Drivable permits Car {

}

sealed class Car extends Vehicle permits Ford, Volvo {

}

// no other class can extend Ford because it is FINAL
final class Ford extends Car {

}

// no other class can extend Volvo because it is FINAL
final class Volvo extends Car {

}

// not permitted
//class Table extends Vehicle {
//
//}
// not permitted
//class Table implements Drivable {
//
//}