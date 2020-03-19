package ua.epam.externalJava.shakespeareSonnets.fillerData;

import org.jetbrains.annotations.NotNull;
import ua.epam.externalJava.shakespeareSonnets.connection.Connection;
import ua.epam.externalJava.shakespeareSonnets.convertor.ConvertorDecimalNumToRoman;
import ua.epam.externalJava.shakespeareSonnets.parser.ParserXML;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FillerDataIntoHashMap {
    private static HashMap<String, Integer> innerHashMap;
    private static HashMap<String,HashMap<String, Integer>> outerHashMap = new HashMap<>();
    private static HashMap<String, Integer> resultedHashMap;

    public static void fillSourceMaps(){
        for (int i = 100; i < 155; i++) {
            Connection.setRomanNumberToUrlStringXML(ConvertorDecimalNumToRoman.getRomanNum(i));
            setInnerHashMap(ParserXML.getHTMLBody());
            setOuterHashMap(Connection.getUrlStringXML(),getInnerHashMap());
        }
    }

    public static void setInnerHashMap(@NotNull String inputDataString) {
        innerHashMap = new HashMap<>();
        String temp = inputDataString.toLowerCase();
        String regExpression = "\\s*(\\s|,|!|:|'d|'st|'s|'|;|--|\\?|\\.|\\t|\\n|\\x0B|\\f|\\r|\\[|\\])\\s*";
        String [] words = temp.split(regExpression);
        for (String a : words) {
            Integer freq = innerHashMap.get(a);
            innerHashMap.put(a, (freq == null) ? 1 : freq + 1);
        }
    }

    public static void setOuterHashMap(String url, HashMap<String, Integer> innerMap) {
        outerHashMap.put(url,innerMap);
    }

    public static void setResultedHashMap(String searchedWord) {
        HashMap<String, Integer> tempMap = new HashMap<>();
        for (Map.Entry<String, HashMap<String, Integer>> outer : getOuterHashMap().entrySet()) {
            HashMap<String , Integer> inner = outer.getValue();
            if(inner.containsKey(searchedWord)){
                tempMap.put(outer.getKey(),inner.get(searchedWord));
            }
        }
        resultedHashMap=sortResultedHashMap(tempMap);
    }

    private static HashMap<String, Integer> sortResultedHashMap(HashMap<String, Integer> inputData){
        HashMap<String, Integer> outputData = inputData.entrySet().
                stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1,e2)->e2, LinkedHashMap::new));
        return outputData;
    }

    public static HashMap<String, Integer> getInnerHashMap() {
        return innerHashMap;
    }

    public static HashMap<String, HashMap<String, Integer>> getOuterHashMap() {
        return outerHashMap;
    }

    public static HashMap<String, Integer> getResultedHashMap() {
        return resultedHashMap;
    }
}