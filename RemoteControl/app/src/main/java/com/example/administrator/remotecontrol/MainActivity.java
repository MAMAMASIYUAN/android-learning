package com.example.administrator.remotecontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.CompoundButton;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnMV1;
    private Button btnMV2;
    private Button btnMV3;
    private Button btnAdd;
    private Button btnSubtract;
    private TextView tvResult;
    private TextView value1;
    private TextView value2;
    private SeekBar seekbar1;
    private Switch switch1;





        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            btn1 = (Button) findViewById(R.id.btn1);
            btn2 = (Button) findViewById(R.id.btn2);
            btn3 = (Button) findViewById(R.id.btn3);
            btn4 = (Button) findViewById(R.id.btn4);
            btn5 = (Button) findViewById(R.id.btn5);
            btn6 = (Button) findViewById(R.id.btn6);
            btn7 = (Button) findViewById(R.id.btn7);
            btn8 = (Button) findViewById(R.id.btn8);
            btn9 = (Button) findViewById(R.id.btn9);
            btn0 = (Button) findViewById(R.id.btn0);
            btnMV1 = (Button) findViewById(R.id.btnMV1);
            btnMV2 = (Button) findViewById(R.id.btnMV2);
            btnMV3 = (Button) findViewById(R.id.btnMV3);
            btnAdd = (Button) findViewById(R.id.btnAdd);
            btnSubtract = (Button) findViewById(R.id.btnSubtract);
            seekbar1 = (SeekBar) findViewById(R.id.seekbar1);
            tvResult = (TextView) findViewById(R.id.tvResult);
            value1 = (TextView) findViewById(R.id.value1);
            value2 = (TextView) findViewById(R.id.value2);
            switch1 = (Switch) findViewById(R.id.switch1);


            value2.setText("OFF");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            btn0.setEnabled(false);
            btnMV1.setEnabled(false);
            btnMV2.setEnabled(false);
            btnMV3.setEnabled(false);
            btnAdd.setEnabled(false);
            btnSubtract.setEnabled(false);
            seekbar1.setEnabled(false);

            switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                    switchchanged(buttonView,isChecked);

                }
            });



        }


    public void switchchanged(CompoundButton buttonView,boolean isChecked) {
        if (buttonView.isChecked()) {
            // 开启switch，设置提示信息
            value2.setText("ON");
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);
            btn0.setEnabled(true);
            btnMV1.setEnabled(true);
            btnMV2.setEnabled(true);
            btnMV3.setEnabled(true);
            btnAdd.setEnabled(true);
            btnSubtract.setEnabled(true);
            seekbar1.setEnabled(true);
            buildControls();

        } else {
            // 关闭swtich，设置提示信息
            value2.setText("OFF");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            btn0.setEnabled(false);
            btnMV1.setEnabled(false);
            btnMV2.setEnabled(false);
            btnMV3.setEnabled(false);
            btnAdd.setEnabled(false);
            btnSubtract.setEnabled(false);
            seekbar1.setEnabled(false);

        }

    }


        private void buildControls() {

            seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                value1.setText(String.valueOf(i));}


        });

        View.OnClickListener listenerAdd = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add(v);
            }
        };

        View.OnClickListener listenerSubtract = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subtract(v);
            }
        };
        View.OnClickListener listenerMV1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MV1(v);
            }
        };
        View.OnClickListener listenerMV2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MV2(v);
            }
        };
        View.OnClickListener listenerMV3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MV3(v);
            }
        };
        View.OnClickListener listenerSetChannel = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SetChannel(v);
            }
        };



        btn0.setOnClickListener(listenerSetChannel);
        btn1.setOnClickListener(listenerSetChannel);
        btn2.setOnClickListener(listenerSetChannel);
        btn3.setOnClickListener(listenerSetChannel);
        btn4.setOnClickListener(listenerSetChannel);
        btn5.setOnClickListener(listenerSetChannel);
        btn6.setOnClickListener(listenerSetChannel);
        btn7.setOnClickListener(listenerSetChannel);
        btn8.setOnClickListener(listenerSetChannel);
        btn9.setOnClickListener(listenerSetChannel);
        btnMV1.setOnClickListener(listenerMV1);
        btnMV2.setOnClickListener(listenerMV2);
        btnMV3.setOnClickListener(listenerMV3);
        btnAdd.setOnClickListener(listenerAdd);
        btnSubtract.setOnClickListener(listenerSubtract);

    }
    private void SetChannel(View v){
        int i= Integer.parseInt(((Button) v).getText().toString());
        tvResult.setTextColor(getResources().getColor(R.color.colorPrimary));
        switch (i){
            case 1:tvResult.setText("001");break;
            case 2:tvResult.setText("002");break;
            case 3:tvResult.setText("003");break;
            case 4:tvResult.setText("004");break;
            case 5:tvResult.setText("005");break;
            case 6:tvResult.setText("006");break;
            case 7:tvResult.setText("007");break;
            case 8:tvResult.setText("008");break;
            case 9:tvResult.setText("009");break;
            case 0:tvResult.setText("000");break;
            default:;
        }

    }

    private void MV1(View v) {
        tvResult.setTextColor(getResources().getColor(R.color.red));
        tvResult.setText("011");

    }private void MV2(View v) {
        tvResult.setTextColor(getResources().getColor(R.color.red));
        tvResult.setText("012");

    }private void MV3(View v) {
        tvResult.setTextColor(getResources().getColor(R.color.red));
        tvResult.setText("013");

    }

    private void Add(View v){
        int num =  Integer.parseInt(tvResult.getText().toString());
        num=num+1;
        if(num==11||num==12||num==13){
        tvResult.setTextColor(getResources().getColor(R.color.red));}
        else {tvResult.setTextColor(getResources().getColor(R.color.colorPrimary));}
        if(num<10){
            tvResult.setText("00"+String.valueOf(num));
        }else if(10<=num&&num<=99){
            tvResult.setText("0"+String.valueOf(num));
        }else if(100<=num&&num<=999){
            tvResult.setText(String.valueOf(num));
        }else if(999<=num){
            tvResult.setText("999");
        }

    }
    private void Subtract(View v){
        int num =  Integer.parseInt(tvResult.getText().toString());
        num=num-1;
        if(num==11||num==12||num==13){
            tvResult.setTextColor(getResources().getColor(R.color.red));}
        else {tvResult.setTextColor(getResources().getColor(R.color.colorPrimary));}
        if(num<0){
            tvResult.setText("000");
        } else if(0<=num&&num<10){
            tvResult.setText("00"+String.valueOf(num));
        }else if(10<=num&&num<=99){
            tvResult.setText("0"+String.valueOf(num));
        }else if(100<=num&&num<=999){
            tvResult.setText(String.valueOf(num));
        }else if(999<=num){
            tvResult.setText("999");
        }

    }





    }








