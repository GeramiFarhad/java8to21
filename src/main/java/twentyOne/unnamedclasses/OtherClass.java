// note that this file(which will be used in an unnamed class) has no package set
package twentyOne.unnamedclasses;

public class OtherClass {
    public void test() {
        System.out.println("Test other");
        //new HelloWorld();   // though there will be a HelloWorld.class after using javac, but an unnamed class can
                            // not be instantiated.
    }
}