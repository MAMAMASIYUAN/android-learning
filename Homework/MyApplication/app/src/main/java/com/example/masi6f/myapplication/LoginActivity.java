package com.example.masi6f.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

       InitControlsBack();
    }

    private void InitControlsBack(){
        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }

}
