package localisation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocalisingNumbers {
    public static void main(String[] args) throws ParseException {
//        formatNumbers();
//        formatCurrencies();
//        parseNumbers();
        customFormats();
    }

    private static void customFormats() {
        double n = 77_000.17;
        System.out.println(new DecimalFormat("$#,###,###.###").format(n));
        System.out.println(new DecimalFormat("$0,000,000.000").format(n));
    }

    private static void parseNumbers() throws ParseException {
        String unitedStatesNumber = "77,000.11",
                italianNumber = "77.000,11",
                frenchNumber = "77 000,11";
        System.out.println(NumberFormat.getNumberInstance(Locale.US).parse(unitedStatesNumber));
        System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).parse(italianNumber));
        System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).parse(frenchNumber));

        double n = 77_000.11;
        String format = NumberFormat.getNumberInstance(Locale.FRANCE).format(n);
        System.out.println(format);
        System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).parse(format));

    }

    private static void formatCurrencies() {
        double n = 23.22;
        System.out.println(NumberFormat.getCurrencyInstance().format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.ITALY).format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).format(n));
    }

    private static void formatNumbers() {
        double n = 77_000.11;
        System.out.println(NumberFormat.getInstance().format(n));
        System.out.println(NumberFormat.getNumberInstance(Locale.US).format(n));
        System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).format(n));
        System.out.println(NumberFormat.getNumberInstance(Locale.FRENCH).format(n));
        System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).format(n));
    }
}
