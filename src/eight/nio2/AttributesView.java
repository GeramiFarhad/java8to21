package eight.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class AttributesView {
    public static void main(String[] args) throws IOException {
        var path = Paths.get("D:\\Temp\\Source\\to be copied\\NationalId.jpg");
        System.out.println(path);

        BasicFileAttributes view = Files.readAttributes(path, BasicFileAttributes.class);
//        System.out.println(view.isDirectory());
//        System.out.println(view.isRegularFile());
//        System.out.println(view.isSymbolicLink());
//        System.out.println(view.size());
        System.out.println(view.lastModifiedTime());

        System.out.println("---------------------");

        BasicFileAttributeView updView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = updView.readAttributes();
        final long THIRTY_MIS_MSEC = 1000 * 60 * 30;
        FileTime lastModifiedTime = FileTime.fromMillis(basicFileAttributes.lastModifiedTime().toMillis() + THIRTY_MIS_MSEC);
        updView.setTimes(lastModifiedTime, null, null);

        view = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println(view.lastModifiedTime());
    }
}
