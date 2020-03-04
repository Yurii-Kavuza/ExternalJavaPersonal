package ua.epam.externalJava.weatherStation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class DictionaryGetRequestJson {

    public static Map<String,Object> jsonToMap (String stirng){
        Map <String,Object> map = new Gson().fromJson(stirng,
                new TypeToken<HashMap<String,Object>>() {}.getType());
        return map;
    }

    public static void main(String[] args) {
        String API_KEY = "71b55d6a9dc5f6a5e4d284c14b97e5a0";
        String LOCATION = "Kyiv";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY +
                "&units=metric";
        try{
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                result.append(line);
            }
            bufferedReader.close();
            System.out.println(result);

            Map<String,Object> resMap = jsonToMap(result.toString());
            Map<String,Object> mainMap = jsonToMap(resMap.get("main").toString());
            Map<String,Object> windMap = jsonToMap(resMap.get("wind").toString());

            System.out.println("Current temperature is " + mainMap.get("temp"));
            System.out.println("Current humidity is " + mainMap.get("humidity"));
            System.out.println("Current pressure is " + mainMap.get("pressure"));

        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}
