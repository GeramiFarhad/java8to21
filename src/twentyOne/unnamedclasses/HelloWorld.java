
// this is a preview feature
// IDEs still don't support this feature

// you should use command prompt:
// javac --release 21 --enable-preview HelloWorld.java
// java --enable-preview HelloWorld
// note that there is no .class after HelloWorld


// they can have instance variables
//int x=5;


// they have a main method, no "public static"  and no "String[] args" needed.
//void main() {
//    System.out.println("hello world");
//    showX();
//    new OtherClass().test();  // unnamed classes can not be instantiated. (see OtherClass)
//}


// they can have other instance methods
//void showX(){
//    System.out.println(x);
//}


// adding a constructor, even no-arg gives compile error
//HelloWorld() {
//
//}


// other classes in an unnamed class will be compiled to
// class HelloWorld$SomeOtherClass
// but as the unnamed class itself can not be referenced, the inner class is hidden too
//class SomeOtherClass {
//
//}