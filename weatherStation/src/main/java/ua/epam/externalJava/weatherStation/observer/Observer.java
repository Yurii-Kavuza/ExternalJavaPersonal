package ua.epam.externalJava.weatherStation.observer;

public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
