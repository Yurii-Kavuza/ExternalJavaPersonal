package ua.epam.externalJava.weatherStation.parser;


import ua.epam.externalJava.weatherStation.connection.Connection;


public class ParserXML {
    private static String dataXML = Connection.getDataXML();

//    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//    Document dDoc = builder.parse(dataXML);
//    dDoc.getDocumentElement().normalize();

//    XPath xPath = XPathFactory.newInstance().newXPath();
//    NodeList nodes = (NodeList) xPath.evaluate("//xml/ep/source/@type", dDoc, XPathConstants.NODESET);
//    for (int i = 0; i < nodes.getLength(); i++){
//        Node node = nodes.item(i);
//        System.out.println(node.getTextContent());






//    private static Document docXml = Jsoup.parse(dataXML, "", Parser.xmlParser());
//
//    public static float getTempCurrent(){
//        return Float.parseFloat(docXml.select("temp").text());
//    }
//
//    public static float getTempFeelsLike(){
//        return Float.parseFloat(docXml.select("feels_like").text());
//    }
//
//    public static float getTempMin(){
//        return Float.parseFloat(docXml.select("temp_min").text());
//    }
//
//    public static float getTempMax(){
//        return Float.parseFloat(docXml.select("temp_max").text());
//    }
//
//    public static float getHumidity(){
//        return Float.parseFloat(mainMap.get("humidity").toString());
//    }
//
//    public static float getPressure(){
//        return Float.parseFloat(mainMap.get("pressure").toString())*0.75006f;
//    }

}

