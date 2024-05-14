package eight.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Attributes {
    public static void main(String[] args) {
        Path source = Paths.get("D:\\Temp\\Source\\to be copied");
        Path source2 = Paths.get("D:\\Temp\\Source\\to be copied\\NationalId.jpg");
        checkAttributes(source);
        System.out.println("---------------");
        checkAttributes(source2);
    }

    public static void checkAttributes(Path path) {
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.isSymbolicLink(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));

        try {
            System.out.println(Files.isHidden(path));
            System.out.println(Files.size(path));
            long x = Files.getLastModifiedTime(path).toMillis();
            ZonedDateTime zdt = FileTime.fromMillis(x).toInstant().atZone(ZoneId.systemDefault());
            System.out.println(zdt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
