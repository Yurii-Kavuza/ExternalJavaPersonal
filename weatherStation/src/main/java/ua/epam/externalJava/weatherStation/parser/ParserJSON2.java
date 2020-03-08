package ua.epam.externalJava.weatherStation.parser;

import org.json.JSONObject;
import ua.epam.externalJava.weatherStation.connection.Connection;

public class ParserJSON2 {
    private static String json = Connection.getDataJSON();
    private static JSONObject jsonObject = new JSONObject(json);

    private static float getValue(String value){
        return jsonObject.getJSONObject("main").getFloat(value);
    }

    public static float getTempCurrent(){
        return getValue("temp");
    }

    public static float getTempFeelsLike(){
        return getValue("feels_like");
    }

    public static float getTempMin(){
        return getValue("temp_min");
    }

    public static float getTempMax(){
        return getValue("temp_max");
    }

    public static float getHumidity(){
        return getValue("humidity");
    }

    public static float getPressure(){
        return getValue("pressure")*0.75006f;
    }
}
