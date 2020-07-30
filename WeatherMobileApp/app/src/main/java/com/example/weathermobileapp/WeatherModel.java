package com.example.weathermobileapp;

public class WeatherModel {

    private String locationName;
    private String iconID;
    private int temperature;
    private int feelsLike;
    private String weatherDescription;
    private String windDescription;
    private String humidity;
    private int tempMin;
    private int tempMax;


    public WeatherModel(String locationName, String iconID, int temperature, int feelsLike, String weatherDescription, String windDescription, String humidity, int tempMin, int tempMax) {
        this.locationName = locationName;
        this.iconID = iconID;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.weatherDescription = weatherDescription;
        this.windDescription = windDescription;
        this.humidity = humidity;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getIconID() {
        return iconID;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getWindDescription() {
        return windDescription;
    }

    public String getHumidity() {
        return humidity;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }
}
