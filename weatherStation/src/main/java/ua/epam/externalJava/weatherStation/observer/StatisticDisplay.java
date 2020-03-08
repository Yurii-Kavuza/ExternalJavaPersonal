package ua.epam.externalJava.weatherStation.observer;

import ua.epam.externalJava.weatherStation.subject.WeatherData;
import java.util.ArrayList;
import java.util.Collections;

public class StatisticDisplay implements  DisplayElement, Observer{
    private WeatherData weatherData;
    private ArrayList<Float> listTemperature = new ArrayList<>();
    private ArrayList<Float> listHumidity = new ArrayList<>();
    private ArrayList<Float> listPressure = new ArrayList<>();

    public StatisticDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        listTemperature = weatherData.getListTemperature();
        listHumidity = weatherData.getListHumidity();
        listPressure = weatherData.getListPressure();
      display();
    }

    @Override
    public void display() {
        System.out.println(result(listTemperature,"temperature"));
        System.out.println(result(listHumidity,"humidity"));
        System.out.println(result(listPressure,"pressure"));
    }

    private float getValueAvg(ArrayList<Float> list){
        float total=0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
        }
        return  total/list.size();
    }

    private float getValueMin(ArrayList<Float> list){
        Collections.sort(list);
        return list.get(0);
    }

    private float getValueMax(ArrayList<Float> list){
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    private String result(ArrayList<Float> list, String value){
        StringBuilder builder= new StringBuilder("Avg/Max/Min ").append(value).
                append(" is ").append(getValueAvg(list)).append("/").append(getValueMax(list)).
                append("/").append(getValueMin(list)).append("/");
        return builder.toString();
    }
}