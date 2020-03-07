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
        System.out.println("Current conditions: temperature is " +
                weatherData.getWeatherCondition().getTemperature() + " C degrees and " +
                weatherData.getWeatherCondition().getHumidity() + "% humidity and pressure is " +
                weatherData.getWeatherCondition().getPressure() + " mm Hg");
    }
}