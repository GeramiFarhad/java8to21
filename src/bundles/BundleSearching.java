package bundles;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleSearching {
    public static void main(String[] args) {
//        defaultLocaleIrrelevant();
        ignoreAmericaBundle();
    }

    private static void ignoreAmericaBundle() {
        Locale.setDefault(Locale.UK);
        Locale us = Locale.FRANCE;

        ResourceBundle rb = ResourceBundle.getBundle("bundles.Mill", us);
        System.out.println(rb.getString("open"));
        System.out.println(rb.getString("name"));
    }

    private static void defaultLocaleIrrelevant() {
        Locale.setDefault(Locale.US);
        Locale localeCA = Locale.CANADA;

        ResourceBundle rb = ResourceBundle.getBundle("bundles.Mill", localeCA);
        System.out.println(rb.getString("name"));
    }
}
