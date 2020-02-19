package ua.epam.externaljava.moreless.view;

import ua.epam.externaljava.moreless.model.Model;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Modified by Yurii Kavuza 15.02.2020
 */
public class View {
    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "property.messages";
    public static ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("uk", "UA"));  // Ukrainian
                    new Locale("en", "US"));        // English

    public void setLocale(Locale locale) {
        bundle =
                ResourceBundle.getBundle(
                        MESSAGES_BUNDLE_NAME, locale);
    }

    // Text's constants
    public static final String EQUAL_SIGN = "=";
    public static final String SPACE_SIGN = " ";
    public static final String OPENS_SQUARE_BRACKET = "[";
    public static final String CLOSING_SQUARE_BRACKET = "]";

    public static final String CHOOSE_LANG ="choose.language";
    public static final String CHOOSE_YOUR_GAME ="choose.your.game";
    public static final String INPUT_INT_VALUE = "input.int.value";
    public static final String INPUT_INT_DATA_KEY = "input.int.data";
    public static final String WRONG_INPUT_INT_DATA = "input.wrong.data";
    public static final String WRONG_RANGE_DATA = "input.wrong.range";
    public static final String CONGRATULATION = "input.congratulation";
    public static final String YOUR_WAY = "input.way";
    public static final String YOUR_WAY_QUANTITY = "input.way.quantity";
    public static final String END_GAME = "end.game";

    /**
     *
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     *
     * @param message
     * @return
     */
    private String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public String getInputMessage(int minBarrier, int maxBarrier) {
        String str = concatenationString( bundle.getString( INPUT_INT_DATA_KEY ),
                SPACE_SIGN, OPENS_SQUARE_BRACKET,
                String.valueOf(minBarrier), SPACE_SIGN,
                String.valueOf(maxBarrier), CLOSING_SQUARE_BRACKET,
                SPACE_SIGN, EQUAL_SIGN);
        return str;
    }
    public void printWrongRangeInput(Model model) {
        printMessage(bundle.getString(WRONG_RANGE_DATA) +
                getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }
    public void printWrongIntInput(Model model) {
        printMessage(bundle.getString(WRONG_INPUT_INT_DATA) +
                getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }
    public void printCongratulation(Model model) {
        printMessage(bundle.getString(CONGRATULATION) +
                model.getSecretValue());
    }
    public void printWay(Model model) {
        printMessage(bundle.getString(YOUR_WAY) +
                String.valueOf(model.getYourWay())+
                SPACE_SIGN + bundle.getString(YOUR_WAY_QUANTITY) +
                String.valueOf(model.getYourWay().size()));
    }
}
