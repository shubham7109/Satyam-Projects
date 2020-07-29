package com.example.weathermobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * This Activity will get the weather of any location!
 */
public class ListActivity extends AppCompatActivity {

    private WeatherModel weatherModel;

    //TODO's in order
    // 1. Replicate the layout in weather_list_item.xml
    // 2. Display AlertDialog in askUserLocation()
    // 3. Handle the error callback on setUpAPI()
    // 4. Fill out setUpViews() based on your weather_list_item.xml resources.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        askUserLocation();
    }


    private void setUpAPI(String location){
        WeatherController.makeAPICall(this, "Dubai", new WeatherController.WeatherCallback() {
            @Override
            public void onResponse(WeatherModel responseModel) {
                weatherModel = responseModel;
                setUpViews(weatherModel);
            }

            @Override
            public void onError(String errorMessage) {
                //TODO: Display message if there is an error.
            }
        });
    }

    /**
     * Displays an alert dialog to get user location
     * Hint: https://alvinalexander.com/source-code/android-mockup-prototype-dialog-text-field/
     */
    private void askUserLocation() {
        //TODO
        //Display alert dialog and then call setUpAPI() when user submit's location.
    }

    /**
     * Set up the view of your custom weather item.
     */
    private void setUpViews(WeatherModel weatherModel) {
        //TODO
        //Set up views from your custom layout.
    }
}