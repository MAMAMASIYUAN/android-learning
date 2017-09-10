package com.example.masi6f.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView register;
    private Button login1;
    private EditText email1;
    private EditText password1;

    private int i = 0;
    public int w;

    String messageTextFailed = "This password not right.";
    String messageTextAdmin = "This is admin.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);




        InitView();
        LoginPage();
    }

    //初始化View
    public void InitView(){
        login1 = (Button) findViewById(R.id.login1);
        email1 = (EditText) findViewById(R.id.email1);
        password1 = (EditText) findViewById(R.id.password1);
        register = (TextView) findViewById(R.id.register);


    }

    //注册事件

    private void LoginPage(){
        login1.setOnClickListener(this);
        register.setOnClickListener(this);
    }


    //触发点击事件
    @Override
    public void onClick(View view) {
        String messageText = "This " + email1.getText() + " can not be found.";
        switch (view.getId()) {
            case R.id.login1:
                if (String.valueOf(email1.getText()).equals("admin") && String.valueOf(password1.getText()).equals("password")) {
                    Toast.makeText(LoginActivity.this, messageTextAdmin, Toast.LENGTH_SHORT).show();

                } else if (!String.valueOf(email1.getText()).equals("admin")) {
                    for (i = 0; i < 100; i++) {
                        if (String.valueOf(email1.getText()).equals(AccountArray.account[i][0])) {
                            w = 3;
                            if (String.valueOf(password1.getText()).equals(AccountArray.account[i][1])) {
                                w = 4;
                                break;
                            } else {
                                w = 1;
                                break;
                            }

                        } else {
                            w = 2;
                        }
                    }
                    if (w == 1) {
                        Toast.makeText(LoginActivity.this, messageTextFailed, Toast.LENGTH_SHORT).show();
                    } else if (w == 2) {
                        Toast.makeText(LoginActivity.this, messageText, Toast.LENGTH_SHORT).show();

                    } else if (w == 3) {

                    } else if (w == 4) {
                        Toast.makeText(LoginActivity.this, "yesyesyesyes", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
            case R.id.register:
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }


        }
}
