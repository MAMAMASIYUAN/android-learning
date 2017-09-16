package com.android_learning.chapter13.downloadtaskdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button1);
        imageview = (ImageView)findViewById(R.id.imageView1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadImageTask downloadImageTask = new
                        DownloadImageTask("https://www.google.com/logos/2013/estonia_independence_day_2013-1057005.3-hp.jpg");
                downloadImageTask.execute(imageview);
            }
        });
    }
}
