package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom adapter to hold Earthquake objects
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        // Get restaurant at list position
        Earthquake currentEarthquake = getItem(position);

        // Find respective resource files to update from xml
        // Update restaurant information with name, description and image
        TextView earthquakeMag = (TextView) convertView.findViewById(R.id.quakeMag);
        earthquakeMag.setText(Double.valueOf(currentEarthquake.getEarthquakeMagnitude()).toString());

        TextView earthquakeLocation = (TextView) convertView.findViewById(R.id.quakeLocation);
        earthquakeLocation.setText(currentEarthquake.getEarthquakeLocation());

        TextView earthquakeDate = (TextView) convertView.findViewById(R.id.quakeDate);
        earthquakeDate.setText(currentEarthquake.getEarthquakeDate());

        return convertView;
    }
}
