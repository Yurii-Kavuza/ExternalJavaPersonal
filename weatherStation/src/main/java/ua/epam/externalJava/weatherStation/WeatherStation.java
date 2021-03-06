package ua.epam.externalJava.weatherStation;

import ua.epam.externalJava.weatherStation.observer.CurrentConditionsDisplay;
import ua.epam.externalJava.weatherStation.observer.ForecastDisplay;
import ua.epam.externalJava.weatherStation.observer.StatisticDisplay;
import ua.epam.externalJava.weatherStation.parser.ParserXML;
import ua.epam.externalJava.weatherStation.subject.WeatherCondition;
import ua.epam.externalJava.weatherStation.subject.WeatherData;
import java.io.IOException;

public class WeatherStation {
    public static void main(String[] args) throws IOException {
        WeatherData weatherData = new WeatherData();
        WeatherCondition weatherCondition = new WeatherCondition.Builder().
                temperature(ParserXML.getTempCurrent()).
                humidity(ParserXML.getHumidity()).
                pressure(ParserXML.getPressure()).build();

        CurrentConditionsDisplay curCondDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(weatherCondition);
    }
}