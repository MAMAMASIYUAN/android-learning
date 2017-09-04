package com.android_learning.chapter3.dinnerorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner s1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SUBS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Log.d(TAG, "Spinner1: " + SUBS[position] +
                                " position=" + position + " id=" + id);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Log.d(TAG, "Spinner1: unselected");
                    }
                });

        final Spinner s2 = (Spinner) findViewById(R.id.spinner2);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SIZES);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter);
        s2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Log.d(TAG, "Spinner2: " + SIZES[position] +
                                " position=" + position + " id=" + id);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Log.d(TAG, "Spinner2: unselected");
                    }
                });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "您选择了: " + s2.getSelectedItem() + " " + s1.getSelectedItem(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    static final String[] SUBS = {
            "川菜",
            "鲁菜",
            "粤菜",
            "湘菜",
            "京味",
            "本帮",
            "烧烤",
            "火锅"
    };

    static final String[] SIZES = {
            "2 位",
            "3 位",
            "4 位",
            "5 位",
            "6 位",
            "8 位"
    };

}