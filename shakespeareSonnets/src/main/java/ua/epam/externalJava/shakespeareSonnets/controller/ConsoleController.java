package ua.epam.externalJava.shakespeareSonnets.controller;

import org.jetbrains.annotations.NotNull;
import ua.epam.externalJava.shakespeareSonnets.fillerData.FillerDataIntoHashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ConsoleController {
    private String searchedWord;

    public void startProcess() throws IOException {
        fillMapsFromAllHTML();
        inputWord();
        setResultedMap();
        printResult();
        chooseAction();
    }

    private void fillMapsFromAllHTML(){
        System.out.println("Please wait");
        FillerDataIntoHashMap.fillSourceMaps();
    }

    private void inputWord() throws IOException {
        System.out.println("Input english word without numbers and/or special symbols");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line=reader.readLine();
        searchedWord=line.toLowerCase();
        //reader.close();
    }

    private void setResultedMap(){
        FillerDataIntoHashMap.setResultedHashMap(searchedWord);
    }

    private void printResult(){
        System.out.println(searchedWord);
        FillerDataIntoHashMap.getResultedHashMap().forEach((k,v)->{
            StringBuilder builder = new StringBuilder();
            builder.append(k).append("\t").append(v);
            System.out.println(builder.toString());
        });
    }

    private void chooseAction() throws IOException {
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("Input english word without numbers and/or special symbols one more time.");
            System.out.println("Input 0  if you want to exit");
            String line = reader2.readLine();
            if(line.equals("0")){
                System.exit(0);
            }else{
                inputWord(line);
                setResultedMap();
                printResult();
            }
        }
    }

    private void inputWord(String line){
        searchedWord=line.toLowerCase();
    }
}
