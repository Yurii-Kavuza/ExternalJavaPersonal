package ua.epam.externalJava.shakespeareSonnets.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ua.epam.externalJava.shakespeareSonnets.connection.Connection;

public class ParserXML {
    private static String dataXML = Connection.getDataXML();
    private static Document docXml = Jsoup.parse(dataXML);

    public static String getHTMLBody(){
        Elements element = docXml.getElementsByTag("body");
        return element.text();
    }
}