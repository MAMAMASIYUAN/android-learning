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
    private Button login1;
    private EditText email1;
    private EditText password1;
    private int i = 0;
    private String[][] accountnew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        /**
         * 接受数据
         */
        Bundle bundle=this.getIntent().getExtras();
        String[][] accountnew = (String[][]) bundle.getSerializable("account");
//        if(accountnew!=null){
//            accountnew = new String[100][];
//            for(int i = 0;i < 100;i++){
//                accountnew[i]=(String[]) account[i];
//            }


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
                String messageTextFailed = "This " + email1.getText() + " can not be found.";
                String messageTextAdmin = "This is admin.";

                Toast.makeText(LoginActivity.this, messageTextAdmin, Toast.LENGTH_SHORT).show();

//                if(email1.getText().equals("admin") && password1.getText().equals("password")){
//                    Toast.makeText(LoginActivity.this, messageTextAdmin, Toast.LENGTH_SHORT).show();
//
//                }else {

//                    for (i = 0; i < 100; i++) {
//
//                        if (accountnew[i][0].equals(email1.getText())) {
//                            if (accountnew[i][1].equals(password1.getText())) {
//
//                            } else {
//                                /**
//                                 * Warning for wrong password.
//                                 */
//                                Toast.makeText(LoginActivity.this, messageTextFailed, Toast.LENGTH_SHORT).show();
//
//                            }
//
//                        } else {
//                            /**
//                             * Warning for wrong account.
//                             */
//                            Toast.makeText(LoginActivity.this, messageText, Toast.LENGTH_SHORT).show();
//
//
//                        }


//                    }
//                }
//
//
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
