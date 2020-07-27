package com.example.weathermobileapp;

public class WeatherModel {

    private String locationName;
    private String iconID;
    private String temperature;
    private String feelsLike;
    private String weatherDescription;
    private String windDescription;

    public WeatherModel(String locationName, String iconID, String temperature, String feelsLike, String weatherDescription, String windDescription) {
        this.locationName = locationName;
        this.iconID = iconID;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.weatherDescription = weatherDescription;
        this.windDescription = windDescription;
    }

    public WeatherModel() {
    }

    public String getLocationName() {
        return locationName;
    }

    public String getIconID() {
        return iconID;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getWindDescription() {
        return windDescription;
    }
}
