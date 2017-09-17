package com.android_learning.chapter13.downloadtaskdemo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button btnStart;

    ProcessDialogAsyncTask processDialogAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnStart=(Button)findViewById(R.id.start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,
                        "预备......开始!",
                        Toast.LENGTH_LONG).show();

                processDialogAsyncTask = new ProcessDialogAsyncTask();
                processDialogAsyncTask.execute();

            }
        });
    }

    class ProcessDialogAsyncTask extends AsyncTask<Void, Integer, Void> {

        boolean running;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            running = true;

            progressDialog = ProgressDialog.show(Main2Activity.this,
                    "进度条对话框",
                    "马上开始");

            progressDialog.setCanceledOnTouchOutside(true);
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    running = false;
                }
            });

            Toast.makeText(Main2Activity.this,
                    "进度开始",
                    Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int i = 10;
            while(running){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(i-- == 0){
                    running = false;
                }

                publishProgress(i);

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressDialog.setMessage(String.valueOf(values[0]));
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(Main2Activity.this,
                    "进度结束",
                    Toast.LENGTH_LONG).show();

            progressDialog.dismiss();
        }

    }

}