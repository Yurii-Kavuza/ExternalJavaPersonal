package ua.epam.externalJava.weatherStation.observer;

import org.apache.log4j.Logger;
import ua.epam.externalJava.weatherStation.subject.Subject;

import java.io.*;
import java.util.ArrayList;

public class StatisticDisplay implements  DisplayElement, Observer{
    private final static Logger logger = Logger.getLogger(StatisticDisplay.class);

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
    private String sourcePath = "resources/savedData/weatherData.csv";


    private ArrayList<Float> listTemperature = new ArrayList<>();
    private ArrayList<Float> listHumidity = new ArrayList<>();
    private ArrayList<Float> listPressure = new ArrayList<>();

    public StatisticDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        try {
            saveData(temperature,humidity, pressure);
        } catch (IOException e) {
            logger.info(e);
        }
        readData();
        setValues(temperature,humidity,pressure);
        display();
    }

    @Override
    public void display() {
        System.out.println(result(temperatureAvg,temperatureMax,temperatureMin,"temperature"));
        System.out.println(result(humidityAvg, humidityMax, humidityMin,"humidity"));
        System.out.println(result(pressureAvg, pressureMax, pressureMin,"pressure"));
    }

    private void saveData(float temperature, float humidity, float pressure) throws IOException {
        String data = new StringBuilder().append(temperature).append(";").
                append(humidity).append(";").append(pressure).append("\n").toString();
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

    private void setValues(float temperature, float humidity, float pressure){
        temperatureAvg=temperature;
        temperatureMax=temperature;
        temperatureMin=temperature;

        humidityAvg=humidity;
        humidityMax=humidity;
        humidityMin=humidity;

        pressureAvg=pressure;
        pressureMax=pressure;
        pressureMin=pressure;

        float total=0;
        for (int i = 0; i < listTemperature.size(); i++) {
            temperatureMin = temperatureMin>listTemperature.get(i)?
                    listTemperature.get(i):temperatureMin;
            temperatureMax = temperatureMax<listTemperature.get(i)?
                    listTemperature.get(i):temperatureMax;
            total += listTemperature.get(i);
        }
        temperatureAvg = total/listTemperature.size();

        total=0;

        for (int i = 0; i < listHumidity.size(); i++) {
            humidityMin = humidityMin>listHumidity.get(i)?
                    listHumidity.get(i):humidityMin;
            humidityMax = humidityMax<listHumidity.get(i)?
                    listHumidity.get(i):humidityMax;
            total += listHumidity.get(i);
        }
        humidityAvg = total/listHumidity.size();

        total=0;

        for (int i = 0; i < listPressure.size(); i++) {
            pressureMin = pressureMin>listPressure.get(i)?
                    listPressure.get(i):pressureMin;
            pressureMax = pressureMax<listPressure.get(i)?
                    listPressure.get(i):pressureMax;
            total += listPressure.get(i);
        }
        pressureAvg = total/listPressure.size();

//        setValueByList(listTemperature, temperatureAvg, temperatureMax, temperatureMin);
//        setValueByList(listHumidity, humidityAvg, humidityMax, humidityMin);
//        setValueByList(listPressure, pressureAvg, pressureMax, pressureMin);

    }

//    private void setValueByList(ArrayList<Float> list, float valueAvg, float valueMax, float valueMin) {
//        float total=0;
//        for (int i = 0; i < list.size(); i++) {
//            valueMin = valueMin>list.get(i)?
//                    list.get(i):valueMin;
//            valueMax = valueMax<list.get(i)?
//                    list.get(i):valueMax;
//            total += list.get(i);
//        }
//        valueAvg = total/list.size();
//        System.out.println(" " + valueAvg + " " + valueMax + " " + valueMin);
//    }

    private String result(float valueAvg, float valueMax, float valueMin, String value){
        StringBuilder builder= new StringBuilder("Avg/Max/Min ").append(value).
                append(" is ").append(valueAvg).append("/").append(valueMax).
                append("/").append(valueMin).append("/");
        return builder.toString();
    }
}
