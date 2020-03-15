package ua.epam.externalJava.shakespeareSonnets.connection;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Connection {
    private final static Logger logger = Logger.getLogger(Connection.class);
    private static String data;
    private static StringBuilder urlString= new StringBuilder("http://shakespeare.mit.edu/Poetry/sonnet.");
    private static String urlStringXML;

    public static String getDataXML(){
        data=getData(urlStringXML);
        return data;
    }

    private static String getData(String value){
        String tempData = null;
        try{
            StringBuilder result = new StringBuilder();
            URL url = new URL(value);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                result.append(line);
            }
            bufferedReader.close();
            tempData = result.toString();
        } catch (IOException e) {
            logger.info(e);
        }
        return tempData;
    }

    public static void setRomanNumberToUrlStringXML(String sonnetRomanNumber) {
        urlStringXML = urlString.append(sonnetRomanNumber).append(".html").toString();
    }
}
