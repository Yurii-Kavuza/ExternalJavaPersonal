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

    private static Map<String,Object> jsonToMap (String stirng){
        Map <String,Object> map = new Gson().fromJson(stirng,
                new TypeToken<HashMap<String,Object>>() {}.getType());
        return map;
    }
    public static float getTempCurrent(){
        return Float.parseFloat(mainMap.get("temp").toString());
    }

    public static float getTempFeelsLike(){
        return Float.parseFloat(mainMap.get("feels_like").toString());
    }

    public static float getTempMin(){
        return Float.parseFloat(mainMap.get("temp_min").toString());
    }

    public static float getTempMax(){
        return Float.parseFloat(mainMap.get("temp_max").toString());
    }

    public static float getHumidity(){
        return Float.parseFloat(mainMap.get("humidity").toString());
    }

    public static float getPressure(){
        return Float.parseFloat(mainMap.get("pressure").toString())*0.75006f;
    }

}
