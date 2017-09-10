//package com.android_learning.chapter3.caculator2;
package com.example.masi6f.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.masi6f.myapplication.AccountArray;
import com.example.masi6f.myapplication.LoginActivity;
import com.example.masi6f.myapplication.R;
import com.example.masi6f.myapplication.Validator;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView login;
    private Button register;
    private TextView fullName;
    private EditText email;
    private EditText editText3;
    private static final String MESSAGE_TEXT_PASSWORD = "This is not an available Password.";
    private static final String MESSAGE_TEXT_OK = "Registration finished successfully.";

//    public String[][] account = new String[100][2];
    private int i = 0;

//    AccountArray account = new AccountArray();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        retisterListener();
    }

    //初始化View
    private void initView() {
        login = (TextView) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        fullName = (TextView) findViewById(R.id.fullname);
        email = (EditText) findViewById(R.id.email);
        editText3 = (EditText) findViewById(R.id.editText3);
    }

    //注册事件
    private void retisterListener() {
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    //触发点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                //传递数据
//                Bundle map = new Bundle();
//                map.putSerializable("account", account);
//                intent.putExtras(map);
                startActivity(intent);
                break;
            case R.id.register:
                String preEmail = email.getText().toString();
                String prePassword = editText3.getText().toString();

                if (!Validator.isEmail(preEmail)) {
                    String messageText = "This " + email.getText() + " is not available Email address.";
                    Toast.makeText(MainActivity.this, messageText, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Validator.isPassword(prePassword)) {
                    Toast.makeText(MainActivity.this, MESSAGE_TEXT_PASSWORD, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (AccountArray.account[i][0] != null) {
                    i++;
                } else {
                    AccountArray.account[i][0] = email.getText().toString();
                    AccountArray.account[i][1] = editText3.getText().toString();
                    Toast.makeText(MainActivity.this, MESSAGE_TEXT_OK, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}