package com.example.iori.downloading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textUrl;
    private TextView showResultText;
    private Button button;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        downloadListener();

    }


    //Initial View
    private void initView() {
         textUrl = (EditText) findViewById(R.id.textUrl);
         showResultText = (TextView) findViewById(R.id.showResultText);
         button = (Button) findViewById(R.id.button);

    }
    //zhuce shijian
    private void downloadListener() {
        button.setOnClickListener(this);
    }
    // dianji chufa shijian
    @Override
    public void onClick(View v) {
        url = textUrl.getText().toString();//Try to input url:https://raw.githubusercontent.com/steve-li-xsdx/android-learning/master/chapter12/demo/hello.txt
        DownloadTextTask downloadTextTask = new DownloadTextTask(url);
        downloadTextTask.execute(showResultText);
    }
}
