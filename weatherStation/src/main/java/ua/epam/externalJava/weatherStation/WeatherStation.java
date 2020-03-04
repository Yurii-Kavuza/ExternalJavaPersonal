package ua.epam.externalJava.weatherStation;

import ua.epam.externalJava.weatherStation.observer.CurrentConditionsDisplay;
import ua.epam.externalJava.weatherStation.parser.ParserJSON;
import ua.epam.externalJava.weatherStation.subject.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        float currentTemperature = ParserJSON.getTempCurrent();
        float currentHumidity = ParserJSON.getHumidity();
        float currentPressure = ParserJSON.getPressure();

        CurrentConditionsDisplay currentConditionsDisplay =
                new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(currentTemperature,currentHumidity,currentPressure);
//        weatherData.setMeasurements(25,80,750);
//        weatherData.setMeasurements(20,75,755);
    }
}
