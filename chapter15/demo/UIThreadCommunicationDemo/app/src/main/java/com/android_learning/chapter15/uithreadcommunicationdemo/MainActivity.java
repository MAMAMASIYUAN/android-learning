package com.android_learning.chapter15.uithreadcommunicationdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MainActivity context = MainActivity.this;
    private ProgressBar progressBar;
    private TextView textView;
    private Button button;
    private int status = 0;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setProgress(0);
        textView = (TextView) findViewById(R.id.loading);
        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(view);
            }
        });
    }

    private void testRunOnUiThread() {
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public void start(View view) {
        status = 0;
        progressBar.setProgress(0);
        textView.setText("Loading ...");
        new Thread(new Runnable() {
            public void run() {
                while (status <= 100) {
                    status = doWork();

                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(status);
                            if (status < 100) {
                                textView.setText("Loading ... " + status + "%");
                            } else {
                                textView.setText("Done");
                            }
                        }
                    });

                }
            }
        }).start();
    }


    // bad code

//  public void start(View view) {
//    status = 0;
//    progressBar.setProgress(0);
//    textView.setText("Loading ...");
//    new Thread(new Runnable() {
//      public void run() {
//        while (status <= 100) {
//          status = doWork();
//
//          progressBar.setProgress(status);
//          if (status < 100) {
//            textView.setText("Loading ... " + status + "%");
//          } else {
//            textView.setText("Done");
//          }
//        }
//      }
//    }).start();
//  }


    private int doWork() {
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
        }
        return ++status; // ++status;
    }
}
