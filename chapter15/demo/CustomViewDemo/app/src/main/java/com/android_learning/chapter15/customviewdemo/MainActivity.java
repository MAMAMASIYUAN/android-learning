package com.android_learning.chapter15.customviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LovelyView customView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        //customView = (LovelyView)findViewById(R.id.customView);
    }
}
