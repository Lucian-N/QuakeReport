package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Custom adapter to hold Earthquake objects
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    final String STRING_SPLIT = " of ";
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

        /**
         *Find respective resource files to update from xml
         *Update earthquake information with time, location and magnitude
         */

        TextView earthquakeMag = (TextView) convertView.findViewById(R.id.quakeMag);
        DecimalFormat magFormat = new DecimalFormat("0.0");
        String output = magFormat.format(Double.valueOf(currentEarthquake.getEarthquakeMagnitude()));
        earthquakeMag.setText(output);

        TextView earthquakeLocation = (TextView) convertView.findViewById(R.id.quakeLocation);
        TextView earthquakeCoords = (TextView) convertView.findViewById(R.id.quakeCoords);
        String quakeLoc = currentEarthquake.getEarthquakeLocation();
        String[] locationString = quakeLoc.split(STRING_SPLIT);

        if (locationString.length == 2) {
            String locationOne = locationString[0];
            String locationTwo = locationString[1];
            earthquakeCoords.setText(locationOne);
            earthquakeLocation.setText(locationTwo);
        } else {
            earthquakeCoords.setText(R.string.noCoords);
            earthquakeLocation.setText(currentEarthquake.getEarthquakeLocation());
        }
        Date dateObject = new Date(currentEarthquake.getEarthquakeDate());

        // Find the TextView with view ID date
        TextView dateView = (TextView) convertView.findViewById(R.id.quakeDate);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) convertView.findViewById(R.id.quakeHour);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) earthquakeMag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getEarthquakeMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return convertView;
    }


    private int getMagnitudeColor(double magnitude) {
        // Change magnitude circle color based on magnitude
        int magnitudeResColor;
        int magnitudeInt = (int) Math.floor(magnitude);
        switch (magnitudeInt) {
            case 0:
            case 1:
                magnitudeResColor = R.color.magnitude1;
                break;
            case 2:
                magnitudeResColor = R.color.magnitude2;
                break;
            case 3:
                magnitudeResColor = R.color.magnitude3;
                break;
            case 4:
                magnitudeResColor = R.color.magnitude4;
                break;
            case 5:
                magnitudeResColor = R.color.magnitude5;
                break;
            case 6:
                magnitudeResColor = R.color.magnitude6;
                break;
            case 7:
                magnitudeResColor = R.color.magnitude7;
                break;
            case 8:
                magnitudeResColor = R.color.magnitude8;
                break;
            case 9:
                magnitudeResColor = R.color.magnitude9;
                break;
            default:
                magnitudeResColor = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeResColor);
    }

    //Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    //Return the formatted date string (i.e. "4:30 PM") from a Date object.
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm");
        return timeFormat.format(dateObject);
    }
}
