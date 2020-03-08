package ua.epam.externalJava.weatherStation.observer;

import ua.epam.externalJava.weatherStation.subject.WeatherData;
import java.util.ArrayList;

public class ForecastDisplay implements  DisplayElement, Observer{
    private WeatherData weatherData;
    private ArrayList<Float> listTemperature = new ArrayList<>();
    private ArrayList<Float> listHumidity = new ArrayList<>();

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(makePrediction());
    }

    @Override
    public void update() {
        listTemperature = weatherData.getListTemperature();
        listHumidity = weatherData.getListHumidity();
        display();
    }

    private String makePrediction(){
        StringBuilder prediction = new StringBuilder();
        if(checkEnoughData()){
            prediction.append(getTemperaturePrediction()).append("\n");
            prediction.append(getHumidityPrediction());
        }else {
            prediction.append("Excuse me. We do not have enough data for making forecast.");
        }
        return prediction.toString();
    }

    private boolean checkEnoughData(){
        return listHumidity.size() > 1 && listTemperature.size() > 1;
    }

    private String getTemperaturePrediction(){
        String temperaturePrediction = "";
        if(checkRiseTemperature()){
            temperaturePrediction = "The temperature is rising.";
        }else if(checkFallTemperature()){
            temperaturePrediction = "The temperature is falling.";
        }else{
            temperaturePrediction = "The temperature is not changing.";
        }
        return temperaturePrediction;
    }

    private boolean checkRiseTemperature(){
        int length = listTemperature.size();
        return listTemperature.get(length - 2) < listTemperature.get(length - 1);
    }

    private boolean checkFallTemperature(){
        int length = listTemperature.size();
        return listTemperature.get(length - 2) > listTemperature.get(length - 1);
    }

    private boolean isLowTemperature(){
        int length = listTemperature.size();
        return checkFallTemperature()&&(listTemperature.get(length-1)<5);
    }

    private String getHumidityPrediction(){
        String humidityPrediction = "";
        if(checkHighHumidity()){
            if(isLowTemperature()){
                humidityPrediction = "Pay attention. It may starting to snow and it may by slippery outside.";
            }else {
                humidityPrediction = "Pay attention and do not forget your umbrella. It may starting to rain.";
            }
        }else{
            humidityPrediction = "The forecast is for dry, cloudy weather with no precipitation expected.";
        }
        return humidityPrediction;
    }

    private boolean checkHighHumidity(){
        int length = listHumidity.size();
        return listHumidity.get(length-1)>84;
    }
}