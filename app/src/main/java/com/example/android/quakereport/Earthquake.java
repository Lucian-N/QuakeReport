package com.example.android.quakereport;

/**
 * Custom Earthquake object to display relevant information to app
 */

public class Earthquake {

    private double earthquakeMagnitude;
    private String earthquakeLocation;
    private long earthquakeDate;

    public Earthquake(double earthquakeMagnitudeId, String earthquakeLocationId, long earthquakeDateId) {
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

    public long getEarthquakeDate() {
        return earthquakeDate;
    }
}

