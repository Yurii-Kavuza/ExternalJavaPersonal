package ua.epam.externalJava.shakespeareSonnets.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ua.epam.externalJava.shakespeareSonnets.connection.Connection;

public class ParserXML {

    public static String getHTMLBody(){
        String dataXML = Connection.getDataXML();
        Document docXml = Jsoup.parse(dataXML);
        Elements element = docXml.getElementsByTag("body");
        return element.text();
    }
}