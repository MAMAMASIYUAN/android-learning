package com.android_learning.chapter13.downloadtaskdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageview;
    private ImageView imageview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button1);
        imageview = (ImageView)findViewById(R.id.imageView1);
        imageview1 = (ImageView)findViewById(R.id.imageView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadImageTask downloadImageTask = new
                        DownloadImageTask("http://img002.21cnimg.com/photos/album/20150702/m600/2D79154370E073A2BA3CD4D07868861D.jpeg");
                DownloadImageTask downloadImageTask1 = new
                        DownloadImageTask("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg");
                downloadImageTask.execute(imageview);
                downloadImageTask1.execute(imageview1);
            }
        });
    }
}
