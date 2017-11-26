package com.example.administrator.personinquiry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class changepassword extends AppCompatActivity {

    private EditText oldpassword;
    private EditText newpassword01;
    private EditText newpassword02;
    private Button buttonSavepassword;
    private String inputpassword;
    private String newpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        Intent intent = getIntent();
        inputpassword=intent.getStringExtra("password_key");
        newpassword=inputpassword;


        oldpassword=(EditText) findViewById(R.id.oldpassword);
        newpassword01=(EditText) findViewById(R.id.newpassword01);
        newpassword02=(EditText) findViewById(R.id.newpassword02);
        buttonSavepassword = (Button) findViewById(R.id.buttonSavepassword);

        buttonSavepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rpassword=changepassword();
               if(rpassword!=null&&rpassword.length() != 0){
                   newpassword=rpassword;
               }
            }
        });

        Button buttonreturnCP = (Button) findViewById(R.id.buttonreturnCP);
        buttonreturnCP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(changepassword.this,InformationModifyActivity.class);
                intent.putExtra("newpassword_key", newpassword);
                setResult(32,intent);
                finish();
            }

        });


    }

    public String changepassword(){
        String returnpassword=null;
        if(oldpassword.getText().toString().equals(inputpassword)){
            if(!(newpassword01.getText().toString().isEmpty())){
                if(!(newpassword02.getText().toString().isEmpty())){
                    if(newpassword01.getText().toString().equals(newpassword02.getText().toString())){
                        returnpassword=newpassword02.getText().toString();
                        Toast.makeText(this, "密码修改成功",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "两次输入密码不一致",Toast.LENGTH_SHORT).show();
                    }


                }else{
                    Toast.makeText(this, "您再次输入新密码",Toast.LENGTH_SHORT).show();
                }


            }else{
                Toast.makeText(this, "您输入新密码",Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(this, "您输入的密码不正确",Toast.LENGTH_SHORT).show();

        }

        return returnpassword;

    }




    @Override
    public void onBackPressed(){
        Intent intent = new Intent(changepassword.this,InformationModifyActivity.class);
        intent.putExtra("newpassword_key", newpassword);
        setResult(32,intent);
        finish();
    }


}
