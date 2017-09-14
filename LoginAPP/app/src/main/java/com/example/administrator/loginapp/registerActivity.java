package com.example.administrator.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.*;


public class registerActivity extends AppCompatActivity {
    private TextView Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        showdata();
    }
    private void showdata(){
        String DateValue;
        Date = (TextView) findViewById(R.id.Date);
        Calendar c1 = Calendar.getInstance();
        // 获得年份
        String year =String.valueOf( c1.get(Calendar.YEAR));

        // 获得月份
        String month = String.valueOf(c1.get(Calendar.MONTH) + 1);
        // 获得日期
        String date = String.valueOf(c1.get(Calendar.DATE));
        // 获得小时
        String hour = String.valueOf(c1.get(Calendar.HOUR_OF_DAY));
        // 获得分钟
        String minute = String.valueOf(c1.get(Calendar.MINUTE));
        // 获得秒
        String second = String.valueOf(c1.get(Calendar.SECOND));
        // 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
        String day = String.valueOf(c1.get(Calendar.DAY_OF_WEEK));

        DateValue=year+"年"+month+"月"+date+"日"+hour+"时"+minute+"分"+second+"秒"+" "+"星期"+day;
        Date.setText(DateValue);


    }


}
