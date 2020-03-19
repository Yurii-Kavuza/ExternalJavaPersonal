package ua.epam.externalJava.shakespeareSonnets;

import ua.epam.externalJava.shakespeareSonnets.controller.ConsoleController;
import ua.epam.externalJava.shakespeareSonnets.fillerData.FillerDataIntoHashMap;

import java.util.HashMap;
import java.util.Map;

public class Programm {

    public static void main(String[] args) throws Exception {
//        Connection.setRomanNumberToUrlStringXML("IV");
//        FillerDataIntoHashMap.setInnerHashMap(ParserXML.getHTMLBody());
//        System.out.println(FillerDataIntoHashMap.getInnerHashMap());
        ConsoleController consoleController = new ConsoleController();
        consoleController.startProcess();
//        FillerDataIntoHashMap.getOuterHashMap().forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v);
//        });
//        for (Map.Entry<String, HashMap<String, Integer>> s : FillerDataIntoHashMap.getOuterHashMap().entrySet()) {
//            System.out.println(s.getKey());
//            System.out.println(s.getValue());
//
//        };
    }
}
