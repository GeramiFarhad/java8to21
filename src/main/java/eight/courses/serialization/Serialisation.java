package eight.courses.serialization;

import java.io.*;

class InfoMedium {
    private String theMedium;

    InfoMedium() { // IS called when de-serialising as this class IS NOT Serializable
        theMedium = "Unknown theMedium";
    }

    public void setMedium(String aMedium) {
        theMedium = aMedium;
    }

    public String getMedium() {
        return theMedium;
    }
}

class Book extends InfoMedium implements Serializable {
    private BookMarker p = new BookMarker();
    private String theAuthor; // if 'transient', then 'null' is value
//    private String theAddress;

    Book() { // IS NOT called when de-serialising as this class IS Serializable
        theAuthor = "Unknown theAuthor";
    }

    public void setAuthor(String aAuthor) {
        theAuthor = aAuthor;
    }

    public String getAuthor() {
        return theAuthor;
    }

    @Override
    public String toString() {
        return getMedium() + "; " + getAuthor();
    }

}

class BookMarker implements Serializable {
    private Image l = new Image();
//    private transient Image l = new Image(); // fix #2, mark as 'transient'
}

//class Image {}// generates a java.eight.courses.io.NotSerializableException when serialising
class Image implements Serializable {
} // fix #1
//class Image{} // fix #2, see BookMarker class

public class Serialisation {
    public static void main(String[] args) {
        // Serialise a Book
        // creates file here: C:\Users\skennedy\Documents\NetbeansProjects\Udemy
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("book.ser")))) {
            Book b = new Book();
            b.setMedium("Print");
            b.setAuthor("Sean Kennedy");
            System.out.println("BEFORE: " + b);
            out.writeObject(b);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Deserialise a Book
        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("book.ser")))) {
            Book b = (Book) in.readObject();
            System.out.println("AFTER: " + b);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}






/*
class InfoMedium {
    private String theMedium;

    InfoMedium(){ // IS called when de-serialising as this class IS NOT Serializable
        theMedium="Unknown";
    }
    public void setMedium(String aMedium){
        theMedium = aMedium;
    }
    public String getMedium(){
        return theMedium;
    }
}
class Book extends InfoMedium implements Serializable{
    private BookMarker p = new BookMarker();
    private String theAuthor; // if 'transient', then 'null' is value

    Book(){ // IS NOT called when de-serialising as this class IS Serializable
        theAuthor = "Unknown";
    }
    public void setAuthor(String aAuthor){
        theAuthor = aAuthor;
    }
    public String getAuthor(){
        return theAuthor;
    }

    @Override
    public String toString() {
        return getMedium() + "; " + getAuthor() ;
    }

}
class BookMarker implements Serializable{
    private Image l = new Image();
//    private transient Image l = new Image(); // fix #2, mark as 'transient'
}
//class Image {}// generates a java.eight.courses.io.NotSerializableException when serialising
class Image implements Serializable{} // fix #1
//class Image{} // fix #2, see BookMarker class

public class Serialisation {
    public static void main(String[] args) {
        // Serialise a Book
        // creates file here: C:\Users\skennedy\Documents\NetbeansProjects\Udemy
        try(var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("book.ser")))){
            Book b = new Book();
            b.setMedium("Print");
            b.setAuthor("Sean Kennedy");
            System.out.println("BEFORE: "+b);
            out.writeObject(b);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Deserialise a Book
        try(var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("book.ser")))){
            Book b = (Book)in.readObject();
            System.out.println("AFTER: "+b);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

*/