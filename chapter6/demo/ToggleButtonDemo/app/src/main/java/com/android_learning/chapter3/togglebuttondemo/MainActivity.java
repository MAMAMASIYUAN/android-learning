package com.android_learning.chapter3.togglebuttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggleButton1 = (ToggleButton) findViewById(R.id.toggle1);
        ToggleButton toggleButton2 = (ToggleButton) findViewById(R.id.toggle2);
        ToggleButton toggleButton3 = (ToggleButton) findViewById(R.id.toggle3);
        ToggleButton toggleButton4 = (ToggleButton) findViewById(R.id.toggle4);
        toggleButton1.setOnCheckedChangeListener(this);
        toggleButton2.setOnCheckedChangeListener(this);
        toggleButton3.setOnCheckedChangeListener(this);
        toggleButton4.setOnCheckedChangeListener(this);

        Switch switch1 = (Switch) findViewById(R.id.switch1);
        Switch switch2 = (Switch) findViewById(R.id.switch2);
        Switch switch3 = (Switch) findViewById(R.id.switch3);
        Switch switch4 = (Switch) findViewById(R.id.switch4);
        switch1.setOnCheckedChangeListener(this);
        switch2.setOnCheckedChangeListener(this);
        switch3.setOnCheckedChangeListener(this);
        switch4.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        Toast.makeText(this, button.getTag() + " is " + (isChecked ? "on" : "off"),
                Toast.LENGTH_SHORT).show();
    }

    public void onToggleClicked(View view) {
        ToggleButton toggleButton = (ToggleButton) view;
        Log.d(TAG, "onToggleClicked() " + toggleButton.getTag() + " " + (toggleButton.isChecked() ? "on" : "off"));
    }

    public void onSwitchClicked(View view) {
        Switch sw = (Switch) view;
        Log.d(TAG, "onSwitchClicked() " + sw.getTag() + " " + (sw.isChecked() ? "on" : "off"));
    }
}
