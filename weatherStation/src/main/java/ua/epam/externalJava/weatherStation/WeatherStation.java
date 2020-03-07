package ua.epam.externalJava.weatherStation;

import ua.epam.externalJava.weatherStation.observer.CurrentConditionsDisplay;
import ua.epam.externalJava.weatherStation.observer.StatisticDisplay;
import ua.epam.externalJava.weatherStation.parser.ParserJSON;
import ua.epam.externalJava.weatherStation.subject.WeatherCondition;
import ua.epam.externalJava.weatherStation.subject.WeatherData;

import java.io.IOException;

public class WeatherStation {
    public static void main(String[] args) throws IOException {
        WeatherData weatherData = new WeatherData();

        WeatherCondition weatherCondition = new WeatherCondition.Builder().
                temperature(ParserJSON.getTempCurrent()).
                humidity(ParserJSON.getHumidity()).
                pressure(ParserJSON.getPressure()).build();
        weatherData.setWeatherCondition(weatherCondition);

        CurrentConditionsDisplay currentConditionsDisplay =
                new CurrentConditionsDisplay(weatherData);
        StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData);


        weatherData.setMeasurements(weatherCondition);
    }
}
