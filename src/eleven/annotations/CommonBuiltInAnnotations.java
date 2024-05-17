package eleven.annotations;

// 1. @Override - Person
//      a) commented out - Object::toString() called
//      b) comments removed - working
//      c) rename method to "tostring()" - with @Override, we get an error
// 2. @Override - Movable
//      a) working
//      b) make the method package-private in the class - error
// 3. @FunctionalInterface - Movable
//      a) working
//      b) if "run()" is uncommented, now we get an error
//      c) if "equals()" is uncommented, no error

public class CommonBuiltInAnnotations {
    public static void main(String[] args) {
        Person person = new Person("PH");
        System.out.println(person);
        person.move();

        Movable m = () -> System.out.println("functional one");
        m.move();
    }
}


@FunctionalInterface
interface Movable {
    void move();

    // though this interface is functional and EQUALS is a method inherited from Object
    // it is allowed as an abstract method in a @FunctionalInterface
    boolean equals(Object o);
}

class Person implements Movable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void move() {
        System.out.println(name + " is moving");
    }
}