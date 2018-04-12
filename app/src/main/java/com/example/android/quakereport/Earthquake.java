package com.example.android.quakereport;

/**
 * Custom Earthquake object to display relevant information to app
 */

public class Earthquake {

    private double earthquakeMagnitude;
    private String earthquakeLocation;
    private String earthquakeDate;

    public Earthquake(double earthquakeMagnitudeId, String earthquakeLocationId, String earthquakeDateId) {
        earthquakeMagnitude = earthquakeMagnitudeId;
        earthquakeLocation = earthquakeLocationId;
        earthquakeDate = earthquakeDateId;
    }

    public double getEarthquakeMagnitude() {
        return earthquakeMagnitude;
    }

    public String getEarthquakeLocation() {
        return earthquakeLocation;
    }

    public String getEarthquakeDate() {
        return earthquakeDate;
    }
}

