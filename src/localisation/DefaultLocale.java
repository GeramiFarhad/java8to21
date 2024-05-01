package localisation;

import java.util.Locale;

public class DefaultLocale {
    public static void main(String[] args) {
//        Locale locale = Locale.getDefault();
//        System.out.println(locale);

        System.out.println(new Locale("en"));
        Locale locEngGB = new Locale("en", "GB");
        System.out.println(locEngGB.getDisplayLanguage());
        System.out.println(locEngGB.getDisplayCountry());

        System.out.println(Locale.FRENCH);
        Locale locFrenchFrance = Locale.FRANCE;
        System.out.println(locFrenchFrance.getDisplayLanguage());
        System.out.println(locFrenchFrance.getDisplayCountry());

        Locale locArabicEgypt = new Locale.Builder().setLanguage("ar").setRegion("EG").build();
        System.out.println(locArabicEgypt);
    }
}
