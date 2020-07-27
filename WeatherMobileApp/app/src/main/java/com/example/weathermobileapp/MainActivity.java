package com.example.weathermobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY = "27914fbb8e05872b1aff5491e81d6c4c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callAPI("Dubai",API_KEY);
    }

    /**
     * Makes the API get request. Nothing needs to be edited here.
     * More info: https://developer.android.com/training/volley
     * @param location Location of the user
     * @param api_key Key of the API call.
     */
    private void callAPI(String location, String api_key) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.openweathermap.org/data/2.5/weather?q="+location+"&appid="+api_key, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                setUpViews(response);
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
    private WeatherModel getWeatherModel(JSONObject response) {
        //TODO
        return new WeatherModel();
    }

    //TODO: Step 2
    /**
     * Set up the TextViews using the weatherModel object.
     * @param response JSON response from API call.
     */
    private void setUpViews(JSONObject response) {
        WeatherModel weatherModel = getWeatherModel(response);
        //TODO: Use weatherModel to set up the TextViews...
        //Example 1:
        //TextView location = findViewById(R.id.location);
        //location.setText(weatherModel.getLocationName()); //Should be "Dubai"
        //Now do the rest ...
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
