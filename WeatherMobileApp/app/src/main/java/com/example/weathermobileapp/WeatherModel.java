package com.example.weathermobileapp;

public class WeatherModel {

    private String locationName;
    private String iconID;
    private int temperature;
    private int feelsLike;
    private String weatherDescription;
    private String windDescription;
    private String humidity;

    public WeatherModel(String locationName, String iconID, int temperature, int feelsLike, String weatherDescription, String windDescription, String humidity) {
        this.locationName = locationName;
        this.iconID = iconID;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.weatherDescription = weatherDescription;
        this.windDescription = windDescription;
        this.humidity = humidity;
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
}
