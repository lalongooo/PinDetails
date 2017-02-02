package com.example.pindetails.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapStateManager {

    private static final String MARKER_LONGITUDE = "marker_longitude";
    private static final String MARKER_LATITUDE = "marker_latitude";
    private static final String LONGITUDE = "longitude";
    private static final String LATITUDE = "latitude";
    private static final String ZOOM = "zoom";
    private static final String BEARING = "bearing";
    private static final String TILT = "tilt";

    private static final String PREFS_NAME = "map_state_preferences";

    public static void saveMapState(Context context, GoogleMap googleMap) {
        SharedPreferences mapStatePrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mapStatePrefs.edit();
        CameraPosition position = googleMap.getCameraPosition();

        editor.putFloat(LATITUDE, (float) position.target.latitude);
        editor.putFloat(LONGITUDE, (float) position.target.longitude);
        editor.putFloat(ZOOM, position.zoom);
        editor.putFloat(TILT, position.tilt);
        editor.putFloat(BEARING, position.bearing);
        editor.apply();
    }

    public static void saveMarker(Context context, LatLng latLng) {
        SharedPreferences mapStatePrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mapStatePrefs.edit();
        editor.putString(MARKER_LATITUDE, String.valueOf(latLng.latitude));
        editor.putString(MARKER_LONGITUDE, String.valueOf(latLng.longitude));
        editor.apply();
        Log.i("MapState", "Marker saved. Latitude: " + latLng.latitude + ", Longitude: " + latLng.longitude);
    }

    public static MarkerOptions getMarker(Context context) {
        SharedPreferences mapStatePrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        double marker_latitude;
        double marker_longitude;
        try {
            marker_latitude = Double.valueOf(mapStatePrefs.getString(MARKER_LATITUDE, ""));
            marker_longitude = Double.valueOf(mapStatePrefs.getString(MARKER_LONGITUDE, ""));
        } catch (ClassCastException | NumberFormatException nfe) {
            return null;
        }

        LatLng latLng = new LatLng(marker_latitude, marker_longitude);
        Log.i("MapState", "Marker retrieved. Latitude: " + latLng.latitude + ", Longitude: " + latLng.longitude);
        return new MarkerOptions().position(latLng);
    }

    public static CameraPosition getSavedCameraPosition(Context context) {
        SharedPreferences mapStatePrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        double latitude = mapStatePrefs.getFloat(LATITUDE, 0);
        if (latitude == 0) {
            return null;
        }
        double longitude = mapStatePrefs.getFloat(LONGITUDE, 0);
        LatLng target = new LatLng(latitude, longitude);

        float zoom = mapStatePrefs.getFloat(ZOOM, 0);
        float bearing = mapStatePrefs.getFloat(BEARING, 0);
        float tilt = mapStatePrefs.getFloat(TILT, 0);

        return new CameraPosition(target, zoom, tilt, bearing);
    }
}