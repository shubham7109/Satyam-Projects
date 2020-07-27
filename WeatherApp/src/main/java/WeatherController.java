import java.util.*;
import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class WeatherController {
    public static void main(String[] args) throws Exception {
        WeatherController weatherController = new WeatherController();
        String location = weatherController.getLocationFromUser();
        String output = weatherController.makeGETRequest("https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=27914fbb8e05872b1aff5491e81d6c4c");
        WeatherModel weatherModel = weatherController.parseWeather(output);
        System.out.println("The latitude is " + weatherModel.getLat());
        System.out.println("The longitude is " + weatherModel.getLon());
        System.out.println("The weather description is " + weatherModel.getDescription());
        System.out.println("The current temperature in (c) " + Math.round((weatherModel.getTemperature() - 273.15)));
        System.out.println("The current temperature in (f) " + Math.round((1.8 * (weatherModel.getTemperature() - 273.15) + 32)));
        int directionDegree = weatherModel.getWindDirection();
        System.out.println("The wind speed and direction in degree is " + Math.round((weatherModel.getWindSpeed()*3.6)) + " (Km/h) from the " + weatherController.directionConverter(directionDegree));
    }

    //TODO: Step 1
    /**
     * Print a question and the location from
     * user.
     * @return String of the location: Eg. "Dubai"
     */

    private String getLocationFromUser(){
        //TODO
        System.out.print("Enter the desired location : ");
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    //TODO: Step 2
    //Hint: Look up how to make Java GET request: https://stackoverflow.com/questions/1485708/how-do-i-do-a-http-get-in-java
    /**
     * Make a GET request.
     * @return String of the GET response
     */

    private String makeGETRequest(String urlToRead) throws Exception {
        //TODO
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public String directionConverter(int directionDegree) {
        String direction = null;
        if (directionDegree < 30 || directionDegree > 330) {
            direction = "North";
        } else if (directionDegree > 30 && directionDegree < 60) {
            direction = "North East";
        } else if (directionDegree > 60 && directionDegree < 120) {
            direction = "East";
        } else if (directionDegree > 120 && directionDegree < 150) {
            direction = "South East";
        } else if (directionDegree > 150 && directionDegree < 210) {
            direction = "South";
        } else if (directionDegree > 210 && directionDegree < 240) {
            direction = "South West";
        } else if (directionDegree > 240 && directionDegree < 300) {
            direction = "West";
        } else if (directionDegree > 300 && directionDegree < 330) {
            direction = "North West";
        }
        return direction;
    }


    //TODO: Step 3
    /**
     * Parse the JSON String response to a
     * WeatherModel object.
     * @return A weather model object based on the response given.
     */

    private WeatherModel parseWeather(String response) {
        //TODO
        JSONObject responseObject = new JSONObject(response);
        Double lon = responseObject.getJSONObject("coord").getDouble("lon");
        Double lat = responseObject.getJSONObject("coord").getDouble("lat");
        String description = responseObject.getJSONArray("weather").getJSONObject(0).getString("description");
        Double temperature = responseObject.getJSONObject("main").getDouble("temp");
        Double windSpeed = responseObject.getJSONObject("wind").getDouble("speed");
        int windDirection = responseObject.getJSONObject("wind").getInt("deg");
        return new WeatherModel(lat,lon,description,temperature,windSpeed,windDirection);
    }

    //TODO: Step 4
    /**
     * Saves the location as a location.txt file
     * @param location Location string
     */

    private void saveLocation(String location){

    }
}

