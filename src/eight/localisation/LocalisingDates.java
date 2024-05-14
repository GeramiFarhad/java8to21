package eight.localisation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalisingDates {
    public static void main(String[] args) {
        Locale us = Locale.US;
        Locale french = Locale.FRANCE;
        Locale germany = Locale.GERMANY;

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        DateTimeFormatter dateMediumStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(dateMediumStyle.withLocale(us).format(ldt));
        System.out.println(dateMediumStyle.withLocale(french).format(ldt));
        System.out.println(dateMediumStyle.withLocale(germany).format(ldt));

        System.out.println("---------------------------");

        DateTimeFormatter timeShortStyle = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        System.out.println(timeShortStyle.withLocale(us).format(ldt));
        System.out.println(timeShortStyle.withLocale(french).format(ldt));
        System.out.println(timeShortStyle.withLocale(germany).format(ldt));

        System.out.println("---------------------------");

        DateTimeFormatter dateTimeShortStyle = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(dateTimeShortStyle.withLocale(us).format(ldt));
        System.out.println(dateTimeShortStyle.withLocale(french).format(ldt));
        System.out.println(dateTimeShortStyle.withLocale(germany).format(ldt));
    }
}
