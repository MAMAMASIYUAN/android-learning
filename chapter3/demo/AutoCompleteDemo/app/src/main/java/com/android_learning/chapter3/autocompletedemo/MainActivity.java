package com.android_learning.chapter3.autocompletedemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView tv1 = (AutoCompleteTextView) findViewById(R.id.text1);
        tv1.setAdapter(adapter);

        MultiAutoCompleteTextView tv2 = (MultiAutoCompleteTextView) findViewById(R.id.text2);
        tv2.setAdapter(adapter);
        tv2.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    static final String[] COUNTRIES = new String[] {
            "王者荣耀", "王者毒药", "英雄联盟", "LOL", "DOTA",
            "刀塔传奇", "龙之谷", "斗地主", "麻将", "德州扑克",
            "考拉快跑","WOW","魔兽世界"
    };
}
