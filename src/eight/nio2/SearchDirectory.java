package eight.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchDirectory {
    public static void main(String[] args) {
        Path startPath = Paths.get("D:\\Temp\\Source\\to be copied");

        try (var streamPaths = Files.find(startPath, 10, (path, attr) -> attr.isRegularFile() && path.toString().endsWith(".jpg"))) {
            streamPaths.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
