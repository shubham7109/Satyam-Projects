package com.example.weathermobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//TODO: WORK ON THIS CLASS
// Hint: https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private ArrayList<WeatherModel> weatherModelArrayList;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    WeatherAdapter(Context context, ArrayList<WeatherModel> weatherModels) {
        mInflater = LayoutInflater.from(context);
        weatherModelArrayList = weatherModels;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.weather_list_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //TODO: Bind the items to the view holder
    }

    // total number of rows
    @Override
    public int getItemCount() {
        //TODO: Find what the return value should be
        return 0;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //TODO: Declare the views you would like to bind.
        //TextView myTextView; // <-Example

        ViewHolder(View itemView) {
            super(itemView);
            //TODO: Define the views you would like to bind.
            //myTextView = itemView.findViewById(R.id.tvAnimalName); // <-Example

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // We will worry about this later...
            Toast.makeText(mInflater.getContext(), "Clicked: "+getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
