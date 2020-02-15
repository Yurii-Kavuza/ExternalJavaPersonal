package ua.epam.externaljava.moreless.view;

import ua.epam.externaljava.moreless.model.Model;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by User on 15.04.2016.
 */
public class View {

    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua"));  // Ukrainian
                    new Locale("en"));        // English

    // Text's constants
    public static final String EQUAL_SING = "=";
    public static final String SPACE_SING = " ";
    public static final String OPENS_SQUARE_BRACKET = "[";
    public static final String CLOSING_SQUARE_BRACKET = "]";

    public static final String INPUT_INT_DATA_KEY = "input.int.data";
    public static final String WRONG_INPUT_INT_DATA = "input.wrong.data";
    public static final String WRONG_RANGE_DATA = "input.wrong.range";
    public static final String CONGRATULATION = "input.congratulation";
    public static final String YOUR_WAY = "input.way";

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
                SPACE_SING, OPENS_SQUARE_BRACKET,
                String.valueOf(minBarrier), SPACE_SING,
                String.valueOf(maxBarrier), CLOSING_SQUARE_BRACKET,
                SPACE_SING, EQUAL_SING);
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
                String.valueOf(model.getYourWay()));
    }
}
