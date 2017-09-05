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

public class LoginActivity extends AppCompatActivity {


    private TextView register;
//    private Button login1;
//    private EditText email1;
//    private EditText password1;
    private int i = 0;
    public int w;
    private String[][] accountnew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        /**
         * 接受数据
         */
        Bundle bundle=this.getIntent().getExtras();
        String[][] account = (String[][]) bundle.getSerializable("account");
        if(account!=null) {
            accountnew = new String[100][2];
            for (int i = 0; i < 100; i++) {
                accountnew[i][0] = String.valueOf(account[i][0]);
                accountnew[i][1] = String.valueOf(account[i][1]);
            }
        }


        InitControlsBack();
        LoginControl();
    }

    private void LoginControl() {

        Button login1 = (Button) findViewById(R.id.login1);
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email1 = (EditText) findViewById(R.id.email1);
                EditText password1 = (EditText) findViewById(R.id.password1);
                String messageText = "This " + email1.getText() + " can not be found.";
                String messageTextFailed = "This password not right.";
                String messageTextAdmin = "This is admin.";

//                Toast.makeText(LoginActivity.this, messageTextAdmin, Toast.LENGTH_SHORT).show();

                if(String.valueOf(email1.getText()).equals("admin") && String.valueOf(password1.getText()).equals("password")){
                    Toast.makeText(LoginActivity.this, messageTextAdmin, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(LoginActivity.this, accountnew[3][0], Toast.LENGTH_SHORT).show();

                }else if(!String.valueOf(email1.getText()).equals("admin")){
                    for (i = 0; i < 100; i++) {
                        if (String.valueOf(accountnew[i][0]).equals(String.valueOf(email1.getText()))) {
                            w=3;
                            if (String.valueOf(accountnew[i][1]).equals(String.valueOf(password1.getText()))) {
                                w=4;
//                                Toast.makeText(LoginActivity.this, "yesyesyesyes", Toast.LENGTH_SHORT).show();
                            } else {
                                w = 1;
                                /**
                                 * Warning for wrong password.
                                 */
//                                Toast.makeText(LoginActivity.this, messageTextFailed, Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            w = 2;
                            /**
                             * Warning for wrong account.
                             */
//                            Toast.makeText(LoginActivity.this, messageText, Toast.LENGTH_SHORT).show();
                        }
                    }
                    if(w == 1){
                        Toast.makeText(LoginActivity.this, messageTextFailed, Toast.LENGTH_SHORT).show();
                    }else if( w == 2 ){
                        Toast.makeText(LoginActivity.this, messageText, Toast.LENGTH_SHORT).show();

                    }else if ( w==3 ){

                    }else if (w == 4){
                        Toast.makeText(LoginActivity.this, "yesyesyesyes", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
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
