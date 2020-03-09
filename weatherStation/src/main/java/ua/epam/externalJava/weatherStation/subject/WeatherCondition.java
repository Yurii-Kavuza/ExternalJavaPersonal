package ua.epam.externalJava.weatherStation.subject;

public class WeatherCondition {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherCondition() {
    }

    public WeatherCondition(Builder builder) {
        temperature = builder.temperature;
        humidity = builder.humidity;
        pressure = builder.pressure;
    }

    public static class Builder{
        private float temperature;
        private float humidity;
        private float pressure;

        public Builder temperature (float value){
            temperature = value;
            return this;
        }

        public Builder humidity(float value){
            humidity = value;
            return this;
        }

        public Builder pressure(float value){
            pressure = value;
            return this;
        }

        public WeatherCondition build(){
            return new WeatherCondition(this);
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
