package eleven.security;

import java.util.ArrayList;

 final class Department {

    private final String name, address; // String is immutable (reference can not be changed)
    private final int numEmployees;
    private final ArrayList<String> employees; // mutable

    private Department(String name, String address, int numEmployees, ArrayList<String> employees) {
        this.name = name;
        this.address = address;
        this.numEmployees = numEmployees;
//        this.employees = employees; // this line breaks encapsulation. because this.employees refer to
                                    // an ArrayList taken from outside.
//        Main Output:
//        Created: Department{name='PH', address='somewhere', numEmployees=2, employees=[A, B]}
//        Retrieved: PH somewhere 2 [A, B]
//        Any Change?: Department{name='PH', address='somewhere', numEmployees=2, employees=[A, B, C]}



//        this is called Defensive Copying
        this.employees = new ArrayList<>(employees);
//        Main Output:
//        Created: Department{name='PH', address='somewhere', numEmployees=2, employees=[A, B]}
//        Retrieved: PH somewhere 2 [A, B]
//        Any Change?: Department{name='PH', address='somewhere', numEmployees=2, employees=[A, B]}
    }

    public static Department createNewInstance(String name, String address, int numEmployees, ArrayList<String> employees) {
        return new Department(name, address, numEmployees, employees);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public ArrayList<String> getEmployees() {
//        return employees; //    this getter also breaks encapsulation. because it gives out the reference to this.employees

        return new ArrayList<>(employees); // this is called Defensive Copying
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numEmployees=" + numEmployees +
                ", employees=" + employees +
                '}';
    }
}

//    as Department is final, it can not be inherited(extended). however if FINAL keyword is removed
//    because the constructor is private. so this extension is not valid because Department has no
//    visible(not private) constructor

//class SportsDepartment extends Department/*with FINAL keyword, here is marked as error*/ {
//    public SportsDepartment() {
//        super();/*with private constructor in Department, here is marked as error*/
//    }
//}


public class TestImmutable {
    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<>();
        employees.add("A");
        employees.add("B");

        Department department = Department.createNewInstance("PH", "somewhere", 2, employees);
        System.out.println("Created: " + department);

        String name = department.getName();
        String address = department.getAddress();
        int numEmployees = department.getNumEmployees();
        employees = department.getEmployees();

        System.out.println("Retrieved: " + name + " " + address + " " + numEmployees + " " + employees);

        name = "Boots";
        address = "Galway";
        numEmployees = 3;
        employees.add("C");

        System.out.println("Any Change?: " + department);
    }
}