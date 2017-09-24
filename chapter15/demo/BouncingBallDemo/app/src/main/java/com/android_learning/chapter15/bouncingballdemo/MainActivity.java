package com.android_learning.chapter15.bouncingballdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyView v1 = (MyView) findViewById(R.id.v1);
        v1.startAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyView v1 = (MyView) findViewById(R.id.v1);
        v1.stopAnimation();
    }
}
