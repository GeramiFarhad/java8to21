package eight.io;

import java.io.Console;
import java.util.Objects;

public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console();
        if (Objects.isNull(console)) {
            System.out.println("Console not available");
        } else {
            String name = console.readLine("Enter your name");
            System.out.println(name);
        }
    }
}
