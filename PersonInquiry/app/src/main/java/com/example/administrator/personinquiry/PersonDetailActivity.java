package com.example.administrator.personinquiry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PersonDetailActivity extends AppCompatActivity {

    Person person;
    TextView number;
    TextView name;
    TextView gender;
    TextView address;
    TextView workexperience;
    Button buttonModify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        number = (TextView) findViewById(R.id.numberTextView);
        name = (TextView) findViewById(R.id.nameTextView);
        gender = (TextView) findViewById(R.id.genderTextView);
        address = (TextView) findViewById(R.id.addressTextView);
        workexperience = (TextView) findViewById(R.id.workexperienceTextView);
        buttonModify=(Button)findViewById(R.id.buttonModify);
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

        buttonModify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(PersonDetailActivity.this, InformationModifyActivity.class);
                intent4.putExtra("Person_PD", person);
                startActivityForResult(intent4,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

           if ( requestCode==1&&resultCode==RESULT_OK) {
                person=(Person) data.getSerializableExtra("Person_IM");
                //workexperience.setText(person.getWorkexperience());
             Log.d("person_Workexperience", person.getWorkexperience());
            }

    }

}
