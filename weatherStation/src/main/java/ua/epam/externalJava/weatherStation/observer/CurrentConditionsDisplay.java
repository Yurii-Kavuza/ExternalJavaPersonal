package ua.epam.externalJava.weatherStation.observer;

import ua.epam.externalJava.weatherStation.subject.WeatherData;

public class CurrentConditionsDisplay implements DisplayElement, Observer {
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        display();
    }

    @Override
    public void display() {
        StringBuilder builder=new StringBuilder("\n");
        System.out.println(builder.append("Current weather in ").
                append(weatherData.getLocation()).append(": temperature is ").
                append(weatherData.getWeatherCondition().getTemperature()).
                append(" C degrees and ").
                append(weatherData.getWeatherCondition().getHumidity()).
                append("% humidity and pressure is ").
                append(weatherData.getWeatherCondition().getPressure()).
                append(" mm Hg").toString());
    }
}