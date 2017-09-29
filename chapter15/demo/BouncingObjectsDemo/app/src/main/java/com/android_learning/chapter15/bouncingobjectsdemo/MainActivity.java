package com.android_learning.chapter15.bouncingobjectsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    MyView animView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.num);
        animView = (MyView) findViewById(R.id.v1);

        spinner.setAdapter(new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, NUMBERS));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                restart();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

    }

    static final Integer[] NUMBERS = {
            5, 10, 15, 20, 25, 30, 35, 40, 45, 50
    };

    public void restart() {
        animView.restart((Integer) spinner.getSelectedItem());
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
