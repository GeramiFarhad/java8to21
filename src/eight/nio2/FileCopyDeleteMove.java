package eight.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyDeleteMove {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("D:\\Temp\\Source\\to be copied");
        Path destination = Paths.get("D:\\Temp\\Dest");
        deepCopyDirectory(source, destination);
    }

    public static void deepCopyDirectory(Path source, Path destinationAddress) {
        if (Files.isDirectory(source)) {
            try {
                Path destinationPath = destinationAddress.resolve(source.getFileName());

                if (!Files.exists(destinationPath)) {
                    Files.createDirectory(destinationPath);
                }
                Files.list(source).forEach(path -> deepCopyDirectory(path, destinationAddress.resolve(source.getFileName())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            Path destination = destinationAddress.resolve(source.getFileName());
            try {
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
