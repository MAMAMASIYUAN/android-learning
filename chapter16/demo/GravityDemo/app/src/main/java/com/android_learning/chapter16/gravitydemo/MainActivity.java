package com.android_learning.chapter16.gravitydemo;

import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    CanvasView animView;
    Spinner numObjects;
    Spinner sensorType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numObjects = (Spinner) findViewById(R.id.num);
        sensorType = (Spinner) findViewById(R.id.sensorType);
        animView = (CanvasView) findViewById(R.id.v1);

        numObjects.setAdapter(new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, NUMBERS));
        sensorType.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SENSOR_NAMES));

        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                restart();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        };

        numObjects.setOnItemSelectedListener(listener);
        sensorType.setOnItemSelectedListener(listener);
    }

    static final Integer[] NUMBERS = {
            5, 10, 15, 20, 25, 30, 35, 40, 45, 50
    };

    static final String[] SENSOR_NAMES = {
            "Gravity", "Linear Accel", "Gyroscope"
    };

    static final int[] SENSOR_TYPES = {
            Sensor.TYPE_GRAVITY,
            Sensor.TYPE_LINEAR_ACCELERATION,
            Sensor.TYPE_GYROSCOPE,
    };

    public void restart() {
        animView.restart((Integer) numObjects.getSelectedItem(), SENSOR_TYPES[sensorType.getSelectedItemPosition()]);
    }

    @Override
    protected void onResume() {
        super.onResume();
        animView.startAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        animView.stopAnimation();
    }
}
