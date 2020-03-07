package ua.epam.externalJava.weatherStation.subject;

import org.apache.log4j.Logger;
import ua.epam.externalJava.weatherStation.observer.Observer;

import java.io.*;
import java.util.ArrayList;

public class WeatherData implements Subject {
    private String sourcePath = "resources/savedData/weatherData.csv";
    private final static Logger logger = Logger.getLogger(WeatherData.class);

    private ArrayList<Observer> observers;
    private  WeatherCondition weatherCondition;
    private ArrayList<Float> listTemperature = new ArrayList<>();
    private ArrayList<Float> listHumidity = new ArrayList<>();
    private ArrayList<Float> listPressure = new ArrayList<>();

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update());
    }

    public void measurementChanged(){
        notifyObserver();
    }

    public void setMeasurements(WeatherCondition weatherCondition) throws IOException {
        setWeatherCondition(weatherCondition);
        saveData(weatherCondition);
        readData();
        measurementChanged();
    }

    private void saveData(WeatherCondition weatherCondition) throws IOException {
        String data = new StringBuilder().append(weatherCondition.getTemperature()).append(";").
                append(weatherCondition.getHumidity()).append(";").
                append(weatherCondition.getPressure()).append("\n").toString();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(sourcePath,true))){
            writer.write(data);
        }catch (FileNotFoundException e) {
            logger.info(e);
        }
    }

    private void readData(){
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath))
        ) {
            String line = "";

            while ((line=reader.readLine())!=null){
                String [] data = line.split(";");
                listTemperature.add(Float.parseFloat(data[0]));
                listHumidity.add(Float.parseFloat(data[1]));
                listPressure.add(Float.parseFloat(data[2]));
            }
        } catch (FileNotFoundException e) {
            logger.info(e);
        } catch (IOException e) {
            logger.info(e);
        }
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public ArrayList<Float> getListTemperature() {
        return listTemperature;
    }

    public ArrayList<Float> getListHumidity() {
        return listHumidity;
    }

    public ArrayList<Float> getListPressure() {
        return listPressure;
    }
}
