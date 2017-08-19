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
                android.R.layout.simple_dropdown_item_1line, FRUITS);
        AutoCompleteTextView tv1 = (AutoCompleteTextView) findViewById(R.id.text1);
        tv1.setAdapter(adapter);

        MultiAutoCompleteTextView tv2 = (MultiAutoCompleteTextView) findViewById(R.id.text2);
        tv2.setAdapter(adapter);
        tv2.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    static final String[] FRUITS = new String[] {
            "苹果", "香蕉", "梨", "桃", "西瓜","草莓", "蓝莓", "菠萝", "葡萄柚", "葡萄","火龙果", "哈密瓜", "李子", "樱桃", "橘子",
            "柿子", "荔枝", "猕猴桃", "水蜜桃","桔子"

    };
}
