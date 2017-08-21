package com.android_learning.chapter3.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private Button btn1;
    private int x = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Info:       onCreate");
        Log.d(TAG, "Debug:      onCreate");
        Log.w(TAG, "Warning:    onCreate");
        Log.e(TAG, "Error:      onCreate");
        Log.v(TAG, "Verbose:    onCreate");

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x++;
                Log.d(TAG, "现在X的值是：" + x);
            }
        });
    }
}
