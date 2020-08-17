package com.example.weathermobileapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * This Activity will get the weather of any location!
 */
public class ListActivity extends AppCompatActivity {

    private WeatherModel weatherModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        askUserLocation(ListActivity.this);
    }


    private void setUpAPI(final String location){
        WeatherController.makeAPICall(this, location , new WeatherController.WeatherCallback() {
            @Override
            public void onResponse(WeatherModel responseModel) {
                weatherModel = responseModel;
                setUpViews(weatherModel);
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(ListActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Displays an alert dialog to get user location
     * Hint: https://alvinalexander.com/source-code/android-mockup-prototype-dialog-text-field/
     */
    private void askUserLocation(Context c) {
        //Display alert dialog and then call setUpAPI() when user submit's location.
        final EditText taskEditText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Add a location")
                .setMessage("Insert your location")
                .setView(taskEditText)
                .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String location = String.valueOf(taskEditText.getText());
                        setUpAPI(location);
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }

    /**
     * Set up the view of your custom weather item.
     */
    @SuppressLint("SetTextI18n")
    private void setUpViews(WeatherModel weatherModel) {
        //Set up views from your custom layout.
        TextView location = findViewById(R.id.location);
        location.setText(weatherModel.getLocationName());
        TextView temperature = findViewById(R.id.temperature);
        temperature.setText(weatherModel.getTemperature() + "\u00BAC");
        setIcon(weatherModel.getIconID());
        TextView weatherDescription = findViewById(R.id.description);
        weatherDescription.setText(weatherModel.getWeatherDescription());
        TextView minMax = findViewById(R.id.minMax);
        minMax.setText(weatherModel.getTempMin() + "\u00BAC /" + weatherModel.getTempMax() + "\u00BAC");
        TextView windDescription = findViewById(R.id.windDescription);
        windDescription.setText(weatherModel.getWindDescription());

    }

    private void setIcon(String iconID) {
        ImageView imageView = findViewById(R.id.weather_icon);
        Picasso picasso = Picasso.get();
        picasso.setLoggingEnabled(true);
        picasso.load("https://openweathermap.org/img/wn/"+iconID+"@2x.png").error(R.drawable.baseline_filter_drama_24).into(imageView);
    }

}