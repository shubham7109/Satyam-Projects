package com.example.weathermobileapp;

import android.content.Context;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherController {

    /**
     * Performs the API call and gives the WeatherModel object.
     * @param context Context of the activity. (Just type "this")
     * @param callback CallBack listener for error or response
     * @param location Location of the user based on text entry
     */
    public static void makeAPICall(Context context, String location, final WeatherCallback callback) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.openweathermap.org/data/2.5/weather?q="+location+"&appid="+ MainActivity.API_KEY, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    callback.onResponse(getWeatherModel(response));
                } catch (JSONException e) {
                    callback.onError(e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error.getMessage());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
    }

    /**
     * Parse the JSONObject to a WeatherModel object
     * @param response Response from the API call
     * @return WeatherModel object with the weather values set.
     */
    private static WeatherModel getWeatherModel(JSONObject response) throws JSONException {
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

    private static String directionConverter(int directionDegree) {
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

    /**
     * This will set the image icon using the iconID
     * @param iconID This is the ID received from the API response
     */
    private void setIcon(String iconID, ImageView imageView) {
        Picasso picasso = Picasso.get();
        picasso.setLoggingEnabled(true);
        picasso.load("https://openweathermap.org/img/wn/"+iconID+"@2x.png").error(R.drawable.baseline_filter_drama_24).into(imageView);
    }

    /**
     * Interface to help the activity streamline API calls.
     */
    interface WeatherCallback{
        void onResponse(WeatherModel weatherModel);
        void onError(String errorMessage);
    }

}
