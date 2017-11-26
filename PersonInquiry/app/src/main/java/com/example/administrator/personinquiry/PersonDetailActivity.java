package com.example.administrator.personinquiry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PersonDetailActivity extends AppCompatActivity {

    Person person;
    TextView number;
    TextView name;
    TextView gender;
    TextView address;
    TextView workexperience;
    TextView websitetext;
    ImageView portrait;
    Button buttonModify;
    Button buttongo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        number = (TextView) findViewById(R.id.numberTextView);
        name = (TextView) findViewById(R.id.nameTextView);
        gender = (TextView) findViewById(R.id.genderTextView);
        address = (TextView) findViewById(R.id.addressTextView);
        websitetext = (TextView) findViewById(R.id.websitetext);
        workexperience = (TextView) findViewById(R.id.workexperienceTextView);
        portrait=(ImageView)findViewById(R.id.portrait);
        buttonModify=(Button)findViewById(R.id.buttonModify);
        buttongo=(Button)findViewById(R.id.buttongo);

        Intent intent = getIntent();
        person = (Person)intent.getSerializableExtra("Person");

    }
    @Override
    protected void onStart() {
        super.onStart();

        number.setText(person.getNumber());
        name.setText(person.getName());
        gender.setText(person.getGender());
        address.setText(person.getAddress());
        workexperience.setText(person.getWorkexperience());
        websitetext.setText(person.getWebsite());
        portrait.setImageResource(person.getPortraitId());






        buttonModify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(PersonDetailActivity.this, InformationModifyActivity.class);
                intent4.putExtra("Person_PD", person);
                startActivityForResult(intent4,1);
            }
        });

        buttongo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String website=null;
                website=person.getWebsite();
                if(!(website.isEmpty())){
                    Intent intent = new Intent(PersonDetailActivity.this, WebviewActivity.class);
                    intent.putExtra("websitekey",website );
                    startActivity(intent);
                }else{
                    remind();
                }


            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

           if ( requestCode==1&&resultCode==RESULT_OK) {
                person=(Person) data.getSerializableExtra("Person_IM");
//             Log.d("person_Workexperience", person.getWorkexperience());
            }
    }

    @Override
    public void onBackPressed(){
//        返回查询的Person
        Intent intent1 = new Intent();
        intent1.putExtra("Person_PD", person);
        setResult(5,intent1);
        finish();
    }

    private void remind(){
        Toast.makeText(this, "请输入您的githu地址",Toast.LENGTH_SHORT).show();

    }




}
