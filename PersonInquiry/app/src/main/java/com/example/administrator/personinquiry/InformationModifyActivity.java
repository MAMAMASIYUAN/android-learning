package com.example.administrator.personinquiry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InformationModifyActivity extends AppCompatActivity {
    private Person person_IM;
    private Person person_IM_modify;
    private TextView number;
    private TextView name;
    private TextView gender;
    private TextView address;
    private EditText workexperience;
    private Spinner spinneraddress;
    private int addressposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_modify);

    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Intent intent = getIntent();
        number = (TextView) findViewById(R.id.numberTextView_IM);
        name = (TextView) findViewById(R.id.nameTextView_IM);
        gender = (TextView) findViewById(R.id.genderTextView_IM);
        spinneraddress= (Spinner) findViewById(R.id.spinneraddress);
        address = (TextView) findViewById(R.id.addressTextView_IM);
        workexperience = (EditText) findViewById(R.id.workexperienceEditText);

            person_IM = intent.getParcelableExtra("Person_PD");
            person_IM_modify=person_IM;
            number.setText(person_IM.getNumber());
            name.setText(person_IM.getName());
            gender.setText(person_IM.getGender());
            address.setText(person_IM.getAddress());
            workexperience.setText(person_IM.getWorkexperience());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SUBS);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneraddress.setAdapter(adapter);
        spinneraddress.setSelection(getAddressID());
        spinneraddress.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        address.setText(SUBS[position]);
                        addressposition=position;
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person_IM_modify.setAddress(SUBS[addressposition]);
                person_IM_modify.setWorkexperience(workexperience.getText().toString());
                saveRemind();
            }
        });

        Button buttonReturn = (Button) findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Person_IM", person_IM_modify);
                setResult(RESULT_OK,intent);
                finish();
            }

        });
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(InformationModifyActivity.this,PersonDetailActivity.class);
        intent.putExtra("Person_IM", person_IM_modify);
        setResult(RESULT_OK,intent);
        finish();
    }

    //保存后提醒
    public void saveRemind(){
        Toast.makeText(this, "信息已保存",Toast.LENGTH_SHORT).show();
    }


    //获取传进来来的person的地址在SUBS中的位置
    public int getAddressID(){
        int AdressID=0;
        int i;
        for (i=0;i<SUBS.length-1;i++){
            if(person_IM.getAddress().equals(SUBS[i]))
            {AdressID=i;}
        }
        return AdressID;

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






