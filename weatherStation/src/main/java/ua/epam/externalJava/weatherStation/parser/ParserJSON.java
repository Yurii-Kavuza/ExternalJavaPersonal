package ua.epam.externalJava.weatherStation.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ua.epam.externalJava.weatherStation.connection.Connection;
import java.util.HashMap;
import java.util.Map;

public class ParserJSON {
    private static String json = Connection.getDataJSON();
    private static Map<String,Object> resMap = jsonToMap(json.toString());
    private static Map<String,Object> mainMap = jsonToMap(resMap.get("main").toString());

    private static Map<String,Object> jsonToMap (String string){
        Map <String,Object> map = new Gson().fromJson(string,
                new TypeToken<HashMap<String,Object>>() {}.getType());
        return map;
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
        return getValue("pressure") * 0.75006f;
    }

    private static float getValue(String value){
        return Float.parseFloat(mainMap.get(value).toString());
    }
}