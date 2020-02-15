package ua.epam.externaljava.moreless.controller;
import ua.epam.externaljava.moreless.model.Model;
import ua.epam.externaljava.moreless.view.GlobalConstants;
import ua.epam.externaljava.moreless.view.View;

import java.util.Scanner;

/**
 * Created by User on 15.04.2016.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                                GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setSecretValue();
        System.out.println(model.getSecretValue());

        while (!model.checkValue(inputIntValueWithScanner(sc))){}

        view.printCongratulation(model);
        view.printWay(model);
}

    // The Utility methods

    /**
     *
     * @param sc
     * @return
     */
    private int inputIntValueWithScanner(Scanner sc) {
        int res=0;
        view.printMessage(view.getInputMessage
                (model.getMinBarrier(), model.getMaxBarrier()));

        while( true ) {
            // check int - value
            while (!sc.hasNextInt()) {
                view.printWrongIntInput(model);
                sc.next();
            }
            // check value in diapason
            if ((res = sc.nextInt()) <= model.getMinBarrier() ||
                    res >= model.getMaxBarrier()) {
                view.printWrongRangeInput(model);
                continue ;
            }
            break;
        }
        return res;
    }
}
