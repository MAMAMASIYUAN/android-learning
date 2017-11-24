package com.example.administrator.personinquiry;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import static android.widget.Toast.LENGTH_SHORT;

public class RegisterActivity extends AppCompatActivity {

    private Person person_R;
    private TextView numberTextView_R;
    private EditText nameEditText_R;
    private TextView passwordEditText_R1;
    private TextView passwordEditText_R2;
    private TextView genderTextView_R;
    private Switch gender_switch;
    private TextView addressTextView_R;
    private Spinner spinneraddress_R;
    private EditText workexperience_R;
    private Button buttonReturn_R;
    private Button buttonRegister_R;
//    private Button buttonSendmail;
    private int addressposition;
    private String registernumber_R;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        numberTextView_R = (TextView) findViewById(R.id.numberTextView_R);
        nameEditText_R = (EditText) findViewById(R.id.nameEditText_R);
        passwordEditText_R1 = (EditText) findViewById(R.id.passwordEditText_R1);
        passwordEditText_R2 = (EditText) findViewById(R.id.passwordEditText_R2);
        genderTextView_R = (TextView) findViewById(R.id.genderTextView_R);
        gender_switch = (Switch) findViewById(R.id.genderswitch_R);
        addressTextView_R = (TextView) findViewById(R.id.addressTextView_R);
        spinneraddress_R = (Spinner) findViewById(R.id.spinneraddress_R);
        workexperience_R = (EditText) findViewById(R.id.workexperience_R);
        buttonReturn_R = (Button) findViewById(R.id.buttonReturn_R);
        buttonRegister_R = (Button) findViewById(R.id.buttonRegister_R);
//        buttonSendmail=(Button) findViewById(R.id.buttonSendmail);

        //获得注册编号
        Intent intent = getIntent();
        registernumber_R = intent.getStringExtra("RegisterNumber");
        numberTextView_R.setText(registernumber_R);


        //初始化需要注册的person
        person_R = new Person(registernumber_R, null, "", "", "", "",R.drawable.default_portrait);

        //设置性别
        gender_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                switchchanged(buttonView, isChecked);

            }
        });


        //设置地址信息
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SUBS);

        // ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.address_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneraddress_R.setAdapter(adapter);
        spinneraddress_R.setSelection(12);
        spinneraddress_R.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        addressTextView_R.setText(SUBS[position]);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


        //对于注册的对象person进行保存
        buttonRegister_R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Checkpassword() != null) {

                    person_R.setPassword(Checkpassword());
                    person_R.setName(nameEditText_R.getText().toString());
                    person_R.setGender(genderTextView_R.getText().toString());
                    person_R.setAddress(addressTextView_R.getText().toString());
                    person_R.setWorkexperience(workexperience_R.getText().toString());

                    //返回注册的对象
                    Intent intent_R = new Intent();
                    intent_R.putExtra("Person_R", person_R);
                    setResult(3, intent_R);
                    RegisterRemind();
                }
            }
        });


        buttonReturn_R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

//        buttonSendmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent data=new Intent(Intent.ACTION_SENDTO);
//                data.setData(Uri.parse("mailto:200487wei@163.com"));
//                data.putExtra(Intent.EXTRA_SUBJECT, "这是标题");
//                data.putExtra(Intent.EXTRA_TEXT, "这是内容");
//                startActivity(data);
//
//            }
//        });

    }


    //保存后提醒
    public void RegisterRemind(){
        Toast.makeText(this, "您注册成功",Toast.LENGTH_SHORT).show();
    }
    public void switchchanged(CompoundButton buttonView,boolean isChecked) {
        if (buttonView.isChecked()) {
            // 开启switch，设置提示信息
            genderTextView_R.setText("女");

        } else {
            // 关闭swtich，设置提示信息
            genderTextView_R.setText("男");

        }

    }


    //两次输入的密码检测
    public String Checkpassword(){
        String password_R=null;
        String password_R1=passwordEditText_R1.getText().toString();
        String password_R2=passwordEditText_R2.getText().toString();
        if(password_R1!= null && password_R1.length() != 0&&password_R2!= null && password_R2.length() != 0) {
            if (password_R1.equals(password_R2)) {
                password_R = password_R1;
            } else {
                Toast.makeText(this, "两次输入的密码不一致", LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "请输入密码", LENGTH_SHORT).show();
        }

            return password_R;

    }

    static final String[] SUBS = {
            "湖北",
            "江苏",
            "安徽",
            "湖南",
            "江西",
            "上海",
            "北京",
            "深圳",
            "广州",
            "西藏",
            "湖南",
            "河北",
            ""

    };



}



