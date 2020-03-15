package ua.epam.externalJava.shakespeareSonnets;

import ua.epam.externalJava.shakespeareSonnets.connection.Connection;
import ua.epam.externalJava.shakespeareSonnets.parser.ParserXML;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Programm {
    public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        in.close();

        return response.toString();
    }
    public static void main(String[] args) throws Exception {
//        Map<String, Integer> m = new HashMap<String, Integer>();
//        String str= getText("http://shakespeare.mit.edu/Poetry/sonnet.III.html");
//        String str= getText("https://stackoverflow.com/questions/4328711/read-url-to-string-in-few-lines-of-java-code");
//         String str="Mama mila ramu ramu maila mama mama";
        //Initialize frequency table from command line
//        String [] words = str.split(" ");
//        for (String a : words) {
//            Integer freq = m.get(a);
//            m.put(a, (freq == null) ? 1 : freq + 1);
//        }
//        System.out.println(m.size() + " distinct words:");
//        System.out.println(m);
        Connection.setRomanNumberToUrlStringXML("III");
        System.out.println(Connection.getDataXML());
        System.out.println(ParserXML.getHTMLBody());

    }
}
