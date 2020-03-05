package ua.epam.externalJava.weatherStation.connection;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Connection {
    private final static Logger logger = Logger.getLogger(Connection.class);
    private static String data;
    private static String API_KEY = "71b55d6a9dc5f6a5e4d284c14b97e5a0";
    private static String LOCATION = "Kyiv";
    private static StringBuilder urlString= new StringBuilder("http://api.openweathermap.org/data/2.5/weather?q=")
            .append(LOCATION).append("&appid=").append(API_KEY).append("&units=metric");
    private static String urlStringJSON = urlString.toString();
    private static String urlStringXML = urlString.append("&mode=xml").toString();

    public static String getDataJSON(){
        data=getData(urlStringJSON);
        return data;
    }

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
}
