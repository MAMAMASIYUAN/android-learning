package com.example.masi6f.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    /**
     * 接受数据
     */
    Bundle bundle=this.getIntent().getExtras();
    String[][] account = (String[][]) bundle.getSerializable("account");

    private TextView register;
    private Button login1;
    private EditText email1;
    private EditText password1;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
//        Intent intent = getIntent();
//        String[][] account = intent.getStringArrayExtra("account");

       InitControlsBack();
        LoginControl();
    }

    private void LoginControl() {

        Button login1 = (Button) findViewById(R.id.lgoin1);
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email1 = (EditText) findViewById(R.id.email1);
                EditText password1 = (EditText) findViewById(R.id.password1);
                String messageText = "This " + email1.getText() + " can not be found.";
                String messageTextFailed = "This " + email1.getText() + " can not be found.";
                for(i = 0; i < 100; i++){

                    if(account[i][0].equals(email1.getText())){
                        if(account[i][1].equals(password1.getText())){

                        }else{
                            /**
                             * Warning for wrong password.
                             */
                            Toast.makeText(LoginActivity.this, messageTextFailed, Toast.LENGTH_SHORT).show();

                        }

                    }else{
                        /**
                         * Warning for wrong account.
                         */
                        Toast.makeText(LoginActivity.this, messageText, Toast.LENGTH_SHORT).show();



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
