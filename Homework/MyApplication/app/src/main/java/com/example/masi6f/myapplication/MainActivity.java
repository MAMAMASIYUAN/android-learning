package com.example.masi6f.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView login;
    private Button register;
    private EditText fullname;
    private EditText email;
    private EditText editText3;
    private String preEmail = "";
    private String PrePassword = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitControls();
        RegiterControl();
    }

    private void InitControls() {
        login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void RegiterControl(){

        TextView fullName = (TextView) findViewById(R.id.fullname);
        EditText email = (EditText) findViewById(R.id.email);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        Button register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
            }
        });

        String preEmail = String.valueOf(email.getText());

        String prePassword = String.valueOf(editText3.getText());
        String messageText = "This" + email.getText() + " is not available Email address";
        if(Validator.isEmail(preEmail)){
            if(Validator.isPassword(prePassword)){

            }else{
                //报密码不对
            }

        }else{
            //报账号不对
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, messageText, duration);
            toast.show();
        }


        

    }
}

