package com.example.android.quakereport;

/**
 * Custom Earthquake object to display relevant information to app
 */

public class Earthquake {

    private double earthquakeMagnitude;
    private String earthquakeLocation;
    private long earthquakeDate;
    private String earthquakeUrl;

    public Earthquake(double earthquakeMagnitudeId, String earthquakeLocationId, long earthquakeDateId, String earthquakeUrlId) {
        earthquakeMagnitude = earthquakeMagnitudeId;
        earthquakeLocation = earthquakeLocationId;
        earthquakeDate = earthquakeDateId;
        earthquakeUrl = earthquakeUrlId;
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

    public String getEarthquakeUrl() {
        return earthquakeUrl;
    }
}

