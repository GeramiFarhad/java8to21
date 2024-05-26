package seventeen.textblocks;

import java.sql.SQLOutput;

public class TextBlock {
    public static void main(String[] args) {
        String stringName = "ABC";
        // a text block is a String object(immutable and interned)
        String textBlockName = """
                ABC""";

        System.out.println(stringName.equals(textBlockName));
        System.out.println(stringName == textBlockName);

        // String methods can be applied to text blocks
        System.out.println(textBlockName.substring(1));

        // text blocks start with """ followed by a line terminator
//        String tb1 = """abc""";   // this is not valid
//        String tb2 = """abc
//                """;  // this is not valid
        String tb3 = """
                abc
                """;    // this is valid
        System.out.println(tb3);

        // embedded double quotes are not required in text blocks. no need for escape character
        String stringQuote = "Hamlet: \"There is nothing either good or bad, " +
                "but thinking makes it so\""; // on one line
        System.out.println(stringQuote);

        String textBlockQuote = """
                Hamlet: "There is nothing either good or bad, but thinking makes it so"
                """;
        System.out.println(textBlockQuote); // on one line followed by a new line (added to println)

        String textBlockQuote2 = """
                Hamlet: "There is nothing either good or bad,
                but thinking makes it so"
                """;    // the spaces came from indentation are called incidental spaces and are stripped of the content
        System.out.println(textBlockQuote2); // on two lines followed by a new line (added to println)

        String textBlockQuote3 = """
                Hamlet: "There is nothing either good or bad,
                     but thinking makes it so"
                """;    // the spaces came from indentation are called incidental spaces and are stripped off the content
                        // but intended spaces are not stripped off. this stripping wont be applied on content.
                        // the left most decides the indentation.
        System.out.println(textBlockQuote3); // on two lines followed by a new line (added to println)

        String textBlockQuote4 = """
                Hamlet: "There is nothing either good or bad, but thinking makes it so"\040""";
        System.out.println(textBlockQuote4); // on one line, not followed by a new line
        System.out.println("end");

    }
}
