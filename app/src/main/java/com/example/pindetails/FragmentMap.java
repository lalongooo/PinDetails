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
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by jorge.hernandez on 1/31/2017.
 */

public class FragmentMap extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private MapView mMmapView;
    private GoogleMap mGoogleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_map, container, false);
        mMmapView = (MapView) fragmentView.findViewById(R.id.mapView);
        mMmapView.onCreate(savedInstanceState);

        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMmapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        googleMap.setOnMapLongClickListener(this);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        mGoogleMap.clear();
        mGoogleMap.addMarker(new MarkerOptions().position(latLng).title("Hi!"));
        Log.i(getClass().getCanonicalName(), "Map has been long clicked!");
    }

    @Override
    public void onResume() {
        super.onResume();
        mMmapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMmapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMmapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMmapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMmapView.onSaveInstanceState(outState);
    }

}
