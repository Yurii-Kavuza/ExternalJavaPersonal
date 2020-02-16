package ua.epam.externaljava.moreless.controller;

import ua.epam.externaljava.moreless.model.Model;
import ua.epam.externaljava.moreless.view.View;
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
        while (true){
            chooseTypeOfGame();
            processUser();
            endGame();
        }

    }

    //Choose your language. Check the right value.
    public void chooseLanguage(){
        Scanner scanner = new Scanner(System.in);
        int numOfLang = 0;
        Locale locale;

        view.printMessage(View.bundle.getString(View.CHOOSE_LANG));

        while (true){
            // check int - input
            while (!scanner.hasNextInt()) {
                view.printMessage(View.bundle.getString(View.CHOOSE_LANG));
                scanner.next();
            }

            // check the number of language
            numOfLang = scanner.nextInt();
            if (numOfLang==1) {
                locale = new Locale("uk", "UA");
                view.setLocale(locale);
                break;
            }else if (numOfLang==2) {
                locale = new Locale("en", "EN");
                view.setLocale(locale);
                break;
            }
        }
    }

    //Choose your type of game. Check the right value.
    public void chooseTypeOfGame(){
        Scanner scanner = new Scanner(System.in);
        view.printMessage(View.bundle.getString(View.CHOOSE_YOUR_GAME));
        int typeOfgame=0;

        while (true){
            // check int - input
            while (!scanner.hasNextInt()) {
                view.printMessage(View.bundle.getString(View.INPUT_INT_VALUE));
                scanner.next();
            }

            // check the type of game
            typeOfgame = scanner.nextInt();
            if (typeOfgame==1) {
                break;
            }else if (typeOfgame==2) {
                setRange(scanner);
                break;
            }
        }
    }

    //Set custom range for your game
    public void setRange(Scanner sc){
        int first;
        int second;
        int temp;

        view.printMessage(View.bundle.getString(View.INPUT_INT_VALUE));

        while (true){
            // check int - input
            while (!sc.hasNextInt()) {
                view.printMessage(View.bundle.getString(View.INPUT_INT_VALUE));
                sc.next();
            }
            //set the first value
            first=sc.nextInt();
            break;
        }

        view.printMessage(View.bundle.getString(View.INPUT_INT_VALUE));
        while (true){
            // check the next int and match with first value
            while (!sc.hasNextInt()) {
                view.printMessage(View.bundle.getString(View.INPUT_INT_VALUE));
                sc.next();
            }
            temp=sc.nextInt();
            if((temp == first - 1) || (temp == first) || (temp == first + 1)){
                continue;
            } else {
                second = temp;
                break;
            }
        }
        if(first>second){
            model.setPrimaryBarrier(second,first);
        }else{
            model.setPrimaryBarrier(first,second);
        }
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


    //End game
    public void endGame(){
        Scanner scanner = new Scanner(System.in);
        view.printMessage(View.bundle.getString(View.END_GAME));

        if(scanner.hasNextInt()){
            if(scanner.nextInt()!=1){
                System.exit(0);
            }else{
                model.setYourWay();
            }
        }else {
            System.exit(0);
        }
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
                view.printWrongIntInput(model);
                continue ;
            }
            break;
        }
        return res;
    }
}
