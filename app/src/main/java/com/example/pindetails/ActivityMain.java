package com.example.pindetails;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ActivityMain extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new FragmentMap()).commit();
    }
}
