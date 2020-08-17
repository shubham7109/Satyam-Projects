package com.example.weathermobileapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * This Activity will get the weather of any location!
 */
public class ListActivity extends AppCompatActivity {

    private ArrayList<WeatherModel> weatherModelArrayList = new ArrayList<>();
    private WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setUpRV();
    }

    /**
     * Called when the FloatingActionButton is clicked
     * Opens the AlertDialog to add a new Location
     * @param view Don't need to use this
     */
    public void fabOnClick(View view) {
        //TODO
        Toast.makeText(this, "Make this open the alert dialog", Toast.LENGTH_SHORT).show();
    }

    /**
     * Sets up the recycler view to be used
     */
    private void setUpRV() {
        //TODO:
        //Set it to be a LinearLayoutManager
        //Create the adapter by using the instance variable
        //Set the adapter to the RV
        //Hint: https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
        //More hints: https://developer.android.com/guide/topics/ui/layout/recyclerview
    }


    private void setUpAPI(final String location){
        WeatherController.makeAPICall(this, location , new WeatherController.WeatherCallback() {
            @Override
            public void onResponse(WeatherModel responseModel) {
                //TODO: Add the response to the weatherModelArrayList
                updateRecyclerView();
                //We don't need this anymore
                //setUpViews(weatherModel);

            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(ListActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Updates the recycler view adapter when a new item is added.
     */
    private void updateRecyclerView() {
        adapter.notifyDataSetChanged();
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