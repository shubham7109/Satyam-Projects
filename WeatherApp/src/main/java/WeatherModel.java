public class WeatherModel {

    private final Double lat;
    private final Double lon;
    private final Double windSpeed;
    private final int windDirection;
    private final String description;
    private final Double temperature;

    public WeatherModel(Double lat, Double lon, String description, Double temperature,Double windSpeed,int windDirection) {
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public String getDescription() {
        return description;
    }

    public Double getTemperature() {
        return temperature;
    }
}
