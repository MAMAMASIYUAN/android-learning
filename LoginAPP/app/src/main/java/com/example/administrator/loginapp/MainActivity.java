package com.example.administrator.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import java.util.regex.Pattern;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private Button btnlogin;
    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitControls();
    }


    private void InitControls() {
        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent();
                intentLogin.setClass(MainActivity.this, registerActivity.class);
                  if(CheckUserFormat()&&CheckPasswordFormat()&&CheckRegister()){startActivity(intentLogin);}

            }
        });

    }
    //检查用户名格式是否正确
    private boolean CheckUserFormat(){
        boolean RightUserFormate;
        username = (TextView) findViewById(R.id.username);
        RightUserFormate=Validator.isUsername(username.getText().toString());
        if(RightUserFormate){
            //Toast.makeText(this, "用户名格式正确",Toast.LENGTH_SHORT).show();
            return true;}
        else{
            Toast.makeText(this, "用户名格式不对",Toast.LENGTH_SHORT).show();
            return false;}

        }
    //检查密码格式是否正确
    private boolean CheckPasswordFormat(){
        boolean RightPasswordFormate;
        password = (TextView) findViewById(R.id.password);
        RightPasswordFormate=Validator.isUsername(password.getText().toString());
        if(RightPasswordFormate){
            //Toast.makeText(this, "密码格式正确",Toast.LENGTH_SHORT).show();
            return true;}
        else{
            Toast.makeText(this, "密码格式不对",Toast.LENGTH_SHORT).show();
            return false;}

    }

    //检查是否注册
    private boolean CheckRegister(){
        boolean CheckRegister;
        boolean CheckUser=false;
        boolean CheckPassword=false;
        boolean ExistUser=false;
        int i;
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        String User=username.getText().toString();
        String Password=password.getText().toString();

        String [][] ListRegister=new String[3][2];
        ListRegister[0][0]="abc123";
        ListRegister[0][1]="w123456";
        ListRegister[1][0]="def123";
        ListRegister[1][1]="w345678";
        ListRegister[2][0]="ghi123";
        ListRegister[2][1]="w456789";
        //用户名检查
        for(i=0;i<=2;i++) {
            CheckUser=User.equals(ListRegister[i][0]);
            if(CheckUser){
                ExistUser=true;
                //密码检查
                CheckPassword=Password.equals(ListRegister[i][1]);
                if(CheckPassword){ Toast.makeText(this, "欢迎登陆",Toast.LENGTH_SHORT).show();
                    break;}
                else{Toast.makeText(this, "密码不正确",Toast.LENGTH_SHORT).show();}
            }
        }

        if (!ExistUser){ Toast.makeText(this, "无此用户名",Toast.LENGTH_SHORT).show();}
        CheckRegister=CheckUser&&CheckPassword;
        return CheckRegister;
    }

}

class Validator{
    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";
    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public  static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }}