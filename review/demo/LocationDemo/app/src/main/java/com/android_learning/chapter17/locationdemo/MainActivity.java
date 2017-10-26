package com.android_learning.chapter17.locationdemo;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android_learning.chapter17.locationdemo.location.Address;
import com.android_learning.chapter17.locationdemo.location.MyLocation;

public class MainActivity extends AppCompatActivity {

    Activity activity;
    View rootView;

    Button btnGetLocation;
    TextView tvAddress;
    TextView tvLatitude;
    TextView tvLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = this.getWindow().getDecorView().getRootView();

        btnGetLocation = (Button) findViewById(R.id.button);
        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLocation();
            }
        });
        tvAddress = (TextView) findViewById(R.id.address);
        tvLatitude = (TextView) findViewById(R.id.latitude);
        tvLongitude = (TextView) findViewById(R.id.longitude);
    }

    private void updateLocation() {
        btnGetLocation.setEnabled(false);
        MyLocation location = new MyLocation(this, rootView);
        Address address = location.getCurrentLocation();
        String newAddress = address.toString();
        if (newAddress.contains("null")) {
            Snackbar.make(rootView, "Please click again for get new location!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else {
            tvAddress.setText(address.toString());
            if (address.stringLatitude != null) {
                tvLatitude.setText(address.stringLatitude);
            }
            if (address.stringLongitude != null) {
                tvLongitude.setText(address.stringLongitude);
            }
        }
        btnGetLocation.setEnabled(true);
    }
}
