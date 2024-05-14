package eight.io;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class ReadingWritingExamples {
    public static void main(String[] args) {
//        copyTextFile(false);
//        copyTextFile(true);
//        copyBinaryFile(false);
//        copyBinaryFile(true);
        copySourceFolder(new File("D:\\SourceFolder"), "D:\\DestFolder", true);

    }

    private static void copySourceFolder(File source, String destAddress, boolean isFirst) {
        if (source.isDirectory()) {
            if (!isFirst) {
                File newFolder = new File(destAddress);
                newFolder.mkdir();
            }
            File[] files = source.listFiles();
            if (Objects.nonNull(files)) {
                Arrays.stream(files).forEach(file -> copySourceFolder(file, destAddress + "\\" + file.getName(), false));
            }
        } else {
            try (var reader = new BufferedInputStream(new FileInputStream(source));
                 var writer = new BufferedOutputStream(new FileOutputStream(destAddress))) {
                var buffer = new byte[1024];
                int numBytesRead = 0;
                while ((numBytesRead = reader.read(buffer)) > 0) {
                    writer.write(buffer, 0, numBytesRead);
                    writer.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void copyBinaryFile(boolean buffering) {
        File srcFile = new File("C:\\My Courses\\Udemy - Java 21, Java 17, Java 11 and Advanced Java 8 2023-8\\07 - Java IO API\\examples\\AxPersoneli.jpg");
        File destFile = new File("C:\\My Courses\\Udemy - Java 21, Java 17, Java 11 and Advanced Java 8 2023-8\\07 - Java IO API\\examples\\AxPersoneliDest.jpg");

        try (var reader = new BufferedInputStream(new FileInputStream(srcFile));
             var writer = new BufferedOutputStream(new FileOutputStream(destFile))) {
            if (buffering) {
                var buffer = new byte[1024];
                int numBytesRead = 0;
                while ( (numBytesRead = reader.read(buffer)) > 0 ) {
                    writer.write(buffer, 0, numBytesRead);
                    writer.flush();
                }
            } else {
                int b;
                while( (b = reader.read()) != -1 ) {
                    writer.write(b);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyTextFile(boolean buffering) {
        File srcFile = new File("C:\\My Courses\\Udemy - Java 21, Java 17, Java 11 and Advanced Java 8 2023-8\\07 - Java IO API\\examples\\srcFile.txt");
        File destFile = new File("C:\\My Courses\\Udemy - Java 21, Java 17, Java 11 and Advanced Java 8 2023-8\\07 - Java IO API\\examples\\destFile.txt");

        try (var reader = new BufferedReader(new FileReader(srcFile));
             var writer = new BufferedWriter(new FileWriter(destFile))) {
            if (buffering) {
                String s = null;

                while( (s = reader.readLine()) != null ) {
                    writer.write(s);
                    writer.newLine();
                }
            } else {
                int b;
                while ( (b = reader.read()) != -1 ) {
                    writer.write(b);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
