package com.example.weathermobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY = "27914fbb8e05872b1aff5491e81d6c4c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callAPI();
    }

    /**
     * Makes the API get request. Nothing needs to be edited here.
     * More info: https://developer.android.com/training/volley
     */
    private void callAPI() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.openweathermap.org/data/2.5/weather?q=Dubai&appid="+ MainActivity.API_KEY, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    setUpViews(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
    }

    //TODO: Step 1
    /**
     * Parse the JSONObject to a WeatherModel object
     * @param response Response from the API call
     * @return WeatherModel object with the weather values set.
     */
    private WeatherModel getWeatherModel(JSONObject response) throws JSONException {
        //TODO
        JSONObject responseObject = new JSONObject(String.valueOf(response));
        String locationName = responseObject.getString("name");
        String iconID = responseObject.getJSONArray("weather").getJSONObject(0).getString("id");
        int temperature = (int) ((responseObject.getJSONObject("main").getInt("temp")) - 273.15);
        String weatherDescription = responseObject.getJSONArray("weather").getJSONObject(0).getString("description");
        int feelsLike = (int) ((responseObject.getJSONObject("main").getDouble("feels_like")) - 273.25);
        String windDescription = "The wind speed and direction in degree is " + Math.round((responseObject.getJSONObject("wind").getDouble("speed"))*3.6) + " (Km/h) from the " + directionConverter(responseObject.getJSONObject("wind").getInt("deg"));
        String humidity = responseObject.getJSONObject("main").getString("humidity");
        return new WeatherModel(locationName, iconID, temperature, feelsLike, weatherDescription, windDescription, humidity);
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

    //TODO: Step 2
    /**
     * Set up the TextViews using the weatherModel object.
     * @param response JSON response from API call.
     */
    @SuppressLint("SetTextI18n")
    private void setUpViews(JSONObject response) throws JSONException {
        WeatherModel weatherModel = getWeatherModel(response);
        //TODO: Use weatherModel to set up the TextViews...
        //Example 1:
        TextView location = findViewById(R.id.location);
        location.setText(weatherModel.getLocationName()); //Should be "Dubai"
        //Now do the rest ...
        setIcon(weatherModel.getIconID());
        TextView temperature = findViewById(R.id.temperature);
        temperature.setText( "Temp : "+ weatherModel.getTemperature() + "C");
        TextView feelsLike = findViewById(R.id.feels_like);
        feelsLike.setText("Feels Like : "+ weatherModel.getFeelsLike() + "C");
        TextView weatherDescription = findViewById(R.id.description);
        weatherDescription.setText("Description : " + weatherModel.getWeatherDescription());
        TextView windDescription = findViewById(R.id.wind);
        windDescription.setText(weatherModel.getWindDescription());
        TextView humidity = findViewById(R.id.humidity);
        humidity.setText("Humidity : " + weatherModel.getHumidity());
    }

    /**
     * This will set the image icon using the iconID
     * @param iconID This is the ID received from the API response
     */
    private void setIcon(String iconID) {
        ImageView imageView = findViewById(R.id.weather_icon);
        Picasso picasso = Picasso.get();
        picasso.setLoggingEnabled(true);
        picasso.load("https://openweathermap.org/img/wn/"+iconID+"@2x.png").error(R.drawable.baseline_filter_drama_24).into(imageView);
    }


}
