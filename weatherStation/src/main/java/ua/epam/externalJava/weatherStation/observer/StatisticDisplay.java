package ua.epam.externalJava.weatherStation.observer;

import ua.epam.externalJava.weatherStation.subject.Subject;

import java.util.ArrayList;

public class StatisticDisplay implements  DisplayElement, Observer{
    private float temperatureAvg;
    private float temperatureMax;
    private float temperatureMin;

    private float humidityAvg;
    private float humidityMax;
    private float humidityMin;

    private float pressureAvg;
    private float pressureMax;
    private float pressureMin;

    private Subject weatherData;

    private ArrayList<Float> listTemperature = new ArrayList<>();
    private ArrayList<Float> listHumidity = new ArrayList<>();
    private ArrayList<Float> listPressure = new ArrayList<>();

    private StringBuilder builderTemperature= new StringBuilder("Avg/Max/Min temperature is ").
            append(temperatureAvg).append("/").append(temperatureMax).append("/").
            append(temperatureMin).append("/");


    public StatisticDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
//        this.temperature = temperature;
//        this.humidity = humidity;
//        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println(builderTemperature.toString());
    }
}
