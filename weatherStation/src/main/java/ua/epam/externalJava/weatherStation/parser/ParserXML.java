package ua.epam.externalJava.weatherStation.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ua.epam.externalJava.weatherStation.connection.Connection;


public class ParserXML {
    private static String dataXML = Connection.getDataXML();

    private static Document docXml = Jsoup.parse(dataXML);

    Elements temp = docXml.getElementsByTag("temperature");

    private static float getValue(String tag, String attr){
        Elements element = docXml.getElementsByTag(tag);
        return Float.parseFloat(element.attr(attr));
    }

    public static float getTempCurrent(){
        return getValue("temperature", "value");
    }

    public static float getTempMin(){
        return getValue("temperature", "min");
    }

    public static float getTempMax(){
        return getValue("temperature", "max");
    }

    public static float getHumidity(){
        return getValue("humidity", "value");
    }

    public static float getPressure(){
        return getValue("pressure", "value")*0.75006f;
    }

}

