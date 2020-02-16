package ua.epam.externaljava.moreless.controller;
import ua.epam.externaljava.moreless.model.Model;
import ua.epam.externaljava.moreless.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    //The Workflow for console view
    public void startProcess(){
        chooseLanguage();
        processUser();
    }
    
    public void chooseLanguage(){
        Scanner scanner = new Scanner(System.in);

        view.printMessage(View.bundle.getString(View.CHOOSE_LANG));
        int numOfLang;

        if (scanner.hasNextInt())
            numOfLang = scanner.nextInt();
        else numOfLang = 1;

        Locale locale = numOfLang == 2 ?
                new Locale("en", "EN"):
                new Locale("uk", "UA");


        view.setLocale(locale);
    }

    public void chooseTypeOfGame(){
        Scanner scanner = new Scanner(System.in);
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setPrimaryBarrier(model.getMinBarrier(),
                                model.getMaxBarrier());
        model.setSecretValue();
        //System.out.println(model.getSecretValue());

        while (!model.checkValue(inputIntValueWithScanner(sc))){}

        view.printCongratulation(model);
        view.printWay(model);
}

    // The Utility methods

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
