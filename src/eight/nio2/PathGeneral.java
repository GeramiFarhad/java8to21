package eight.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathGeneral {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        Path p1 = Path.of("D:\\Temp\\Source\\test.txt");
        Path p2 = Path.of("D:", "Temp", "Source", "test.txt");

        Path p3 = Paths.get("D:\\Temp\\Source\\test.txt");
        Path p4 = Paths.get("D:", "Temp", "Source", "test.txt");

        pathInfo(p1);
    }

    public static void pathInfo(Path path) {
        System.out.println("toString: " + path);
        System.out.println("getNameCount: " + path.getNameCount());
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println("getName(" + i + "): " + path.getName(i));
        }
        System.out.println("getFileName: " + path.getFileName());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getRoot: " + path.getRoot());

        System.out.println("subpath(0,3): " + path.subpath(0, 3));
        System.out.println("subpath(1,4): " + path.subpath(1, 3));
        System.out.println("subpath(2,3): " + path.subpath(2, 3));

        System.out.println("isAbsolute: " + path.isAbsolute());
    }
}
