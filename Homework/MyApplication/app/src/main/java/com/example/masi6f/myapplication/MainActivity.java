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
//    private Button register;
//    private EditText fullname;
//    private EditText email;
//    private EditText editText3;
//    private String preEmail = "";
//    private String PrePassword;
    public String[][] account = new String[100][2];
    private int i = 0;


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
/**
 * 传递数据
 */

                Bundle map = new Bundle();
                map.putSerializable("account",account);
                intent.putExtras(map);

                startActivity(intent);
            }
        });
    }

    private void RegiterControl(){

        Button register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                TextView fullName = (TextView) findViewById(R.id.fullname);
                EditText email = (EditText) findViewById(R.id.email);
                EditText editText3 = (EditText) findViewById(R.id.editText3);
                String preEmail = String.valueOf(email.getText());
                String prePassword = String.valueOf(editText3.getText());
                String messageText = "This " + email.getText() + " is not available Email address.";
                String messageTextPassWord = "This is not an available Password.";
                String messageTextOk = "Registration finished successfully.";
                if(Validator.isEmail(preEmail)){
                    if(Validator.isPassword(prePassword)){

                          if(account[i][0] != null){

                              i++;
                          }else{
                              account[i][0] = String.valueOf(email.getText());
                              account[i][1] = String.valueOf(editText3.getText());
                              Toast.makeText(MainActivity.this, messageTextOk, Toast.LENGTH_SHORT).show();
//                              Toast.makeText(MainActivity.this, account[i][1], Toast.LENGTH_SHORT).show();
                          }

                    }else{
                        /**
                         * Error message for invalid password.
                         */
                        Toast.makeText(MainActivity.this, messageTextPassWord, Toast.LENGTH_SHORT).show();
                    }

                }else {
                    /**
                     * Error message for invalid email address.
                     */
//                    int duration = Toast.LENGTH_SHORT;
//                    Toast toast = Toast.makeText(MainActivity.this, messageText, duration);
//                    toast.show();
                      Toast.makeText(MainActivity.this, messageText, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

