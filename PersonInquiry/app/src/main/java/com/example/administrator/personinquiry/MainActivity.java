package com.example.administrator.personinquiry;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;


public class MainActivity extends AppCompatActivity {

    private TextView personNumber;
    private TextView personPassword;
    private Button buttonInquiry;
    private HashMap<String,Person> personMap = new HashMap<String,Person>();
    private Person inputPerson;
    private Person person_R;
    private Person Person_PD;
    private Button buttonRegister;
    private int mapsize;
    private String registernumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personNumber = (TextView) findViewById(R.id.editTextNumber);
        personPassword= (TextView) findViewById(R.id.editTextPassword);
        buttonInquiry = (Button) findViewById(R.id.buttonInquiry);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

      initPersons();

        try {
            readobj();
        } catch (Exception e) {

        }

        //        Log.d("MainActivity", this.toString());

    }



//    从文件读出对象
    public void readobj()throws Exception
    {
        FileInputStream in = null;
        in = openFileInput("personsfile");
        ObjectInputStream ois = new ObjectInputStream(in);
        personMap=(HashMap<String,Person>)ois.readObject();
        ois.close();

//        while(p!=null){
//            String mapkey=p.getNumber();
//            personMap.put(mapkey,p);
//        p=(Person)ois.readObject();
//       }

    }

    @Override
    protected void onStart() {
        super.onStart();
        clearPassword();

        //查询person的信息
        buttonInquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = personNumber.getText().toString();
                inputPerson = personMap.get(number);
                CheckRegister(number);
            }
        });

        //注册新person
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapsize=personMap.size();
                registernumber= String.valueOf(mapsize+2017000);
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                intent.putExtra("RegisterNumber", registernumber);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //map写入文件
        try {
            writeobj(personMap);
        } catch (Exception e) {
        }
    }

    //想文件写入对象
    public  void writeobj(HashMap<String,Person> p)throws Exception
    {
        FileOutputStream out = null;
        out =openFileOutput("personsfile", Context.MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(p);
        oos.close();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ( requestCode==2&&resultCode==3) {
            person_R=(Person) data.getSerializableExtra("Person_R");
            personMap.put(person_R.getNumber(),person_R);
        }

        if ( requestCode==4&&resultCode==5) {
            Person_PD=(Person) data.getSerializableExtra("Person_PD");
            personMap.put(Person_PD.getNumber(),Person_PD);}
    }

    //清除密码框
    public void clearPassword(){
        String Password=personPassword.getText().toString();
        if(Password!= null&&Password.length()!=0)
        {
            personPassword.setText("");
        }
    }

    //检查用户名和密码检查是否注册
    private boolean CheckRegister(String number){
        boolean result=false;
        if( number!= null && number.length() != 0){
          result=personMap.containsKey(number);
          if(result){
              String personpassword=personPassword.getText().toString();
              if(!number.equals("admin")) {
                  if(personpassword.equals(personMap.get(number).getPassword())){
                  Toast.makeText(this, "欢迎登陆",Toast.LENGTH_SHORT).show();

                  //进入信息查询activity
                  Intent intent = new Intent(MainActivity.this, PersonDetailActivity.class);
                  intent.putExtra("Person", inputPerson);
                      startActivityForResult(intent, 4);
//                      startActivity(intent);

                  } else {
                    Toast.makeText(this, "密码错误",Toast.LENGTH_SHORT).show();
                  }
              }else{
                  if(personpassword.equals(personMap.get(number).getPassword())){
                      Toast.makeText(this, "欢迎管理员登陆",Toast.LENGTH_SHORT).show();
                      mapsize=personMap.size();
                      SerializableMap sermap=new SerializableMap();
                      sermap.setMap(personMap);

                      //传送Personlist给TotalPersonActivity
                      Intent intent2 = new Intent(MainActivity.this, TotalPersonActivity.class);
                      Bundle bundle = new Bundle();
                      bundle.putSerializable("sermap_key",sermap);
                      intent2.putExtras(bundle);
                      startActivity(intent2);
                  } else {
                      Toast.makeText(this, "密码错误",Toast.LENGTH_SHORT).show();
                  }
              }
          }
          else {
              Toast.makeText(this, "无此编号",Toast.LENGTH_SHORT).show();
          }
          return result;
        }
        else{
            Toast.makeText(this, "请输入编号",Toast.LENGTH_SHORT).show();
            return result;
        }
    }


    private void initPersons(){
        personMap.put("admin",new Person("admin","admin","管理员","男","湖北",
                "无",R.drawable.default_portrait));
   }

}
