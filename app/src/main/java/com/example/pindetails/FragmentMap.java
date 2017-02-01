package com.example.pindetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by jorge.hernandez on 1/31/2017.
 */

public class FragmentMap extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = (MapView) fragmentView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mapView.getMapAsync(this);
    }


    @Override
    public void onMapLongClick(LatLng latLng) {
        Log.i(getClass().getCanonicalName(), "Map has been long clicked!");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.i(getClass().getCanonicalName(), "Map is ready!");
        googleMap.setOnMapLongClickListener(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

}
