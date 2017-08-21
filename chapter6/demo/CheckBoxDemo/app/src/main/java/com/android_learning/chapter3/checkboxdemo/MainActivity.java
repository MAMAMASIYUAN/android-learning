package com.android_learning.chapter3.checkboxdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox4);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        checkBox4.setOnCheckedChangeListener(this);

        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radio3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.radio4);
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.radio5);
        RadioButton radioButton6 = (RadioButton) findViewById(R.id.radio6);
        radioButton1.setOnCheckedChangeListener(this);
        radioButton2.setOnCheckedChangeListener(this);
        radioButton3.setOnCheckedChangeListener(this);
        radioButton4.setOnCheckedChangeListener(this);
        radioButton5.setOnCheckedChangeListener(this);
        radioButton6.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        Toast.makeText(this, button.getText() + "被" + (isChecked ? "选中" : "取消"),
                Toast.LENGTH_SHORT).show();
    }

    public void onCheckboxClicked(View view) {
        CheckBox checkBox = (CheckBox) view;
        Log.d(TAG, "onCheckboxClicked() " + checkBox.getText() + " " + (checkBox.isChecked() ? "选中" : "取消"));
    }

    public void onRadioButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        Log.d(TAG, "onRadioButtonClicked() " + radioButton.getText() + " " + (radioButton.isChecked() ? "选中" : "取消"));
    }

}