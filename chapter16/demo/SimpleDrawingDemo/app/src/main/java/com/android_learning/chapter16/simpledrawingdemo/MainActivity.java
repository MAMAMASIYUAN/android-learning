package com.android_learning.chapter16.simpledrawingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final MyView v1 = (MyView) findViewById(R.id.v1);

        final Spinner s1 = (Spinner) findViewById(R.id.colors);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, COLORS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        v1.setColor(COLORS[position]);
                    }
                    public void onNothingSelected(AdapterView<?> parent) { }
                });

        final Spinner s2 = (Spinner) findViewById(R.id.shapes);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SHAPES);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter);
        s2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        v1.setShapeType(SHAPES[position]);
                    }
                    public void onNothingSelected(AdapterView<?> parent) { }
                });

    }


    static final String[] COLORS = {
            "Black",
            "Blue",
            "Cyan",
            "Gray",
            "Green",
            "Magenta",
            "Red",
            "Yellow"
    };

    static final String[] SHAPES = {
            "Trace",
            "Line",
            "Rectangle",
            "Oval",
    };
}
