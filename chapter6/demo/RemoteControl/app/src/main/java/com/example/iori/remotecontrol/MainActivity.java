package com.example.iori.remotecontrol;

import android.graphics.Color;
import android.net.sip.SipAudioCall;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import static android.R.attr.seekBarStyle;
import static android.R.attr.switchTextOff;
import static android.R.attr.textOff;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    static private final String TAG = "MainActivity";
    private TextView power;
    private TextView voise;
    private SeekBar seekBar;
    private Switch switch1;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button CCTV5;
    private Button CCTV6;
    private Button CCTV8;
    private TextView channel;
    private int realchannel;
    private int j;
    private  String prechannel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildControls();

    }

    private void buildControls(){
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2) ;
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8) ;
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        channel = (TextView) findViewById(R.id.channel);

        CCTV5 = (Button) findViewById(R.id.CCTV5);
        CCTV6 = (Button) findViewById(R.id.CCTV6);
        CCTV8 = (Button) findViewById(R.id.CCTV8);
        switch1 = (Switch) findViewById(R.id.switch1);
        power = (TextView) findViewById(R.id.power);
        voise = (TextView) findViewById(R.id.voise);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                NumberClicked(v);
            }

        };
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        button10.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AddClick(view);
            }
        });
        button11.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                SubClick(view);
            }

        });
        CCTV5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fav5Click(view);
            }
        });
        CCTV6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fav6Click(view);
            }
        });
        CCTV8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fav8Click(view);
            }
        });
        channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoClick(view);

            }
        });
        switch1.setOnCheckedChangeListener(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                voise.setText(""+i);
                Log.d(TAG, "onProgressChanged");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch");

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChanged) {
    }
    public void onSwitchClicked(View view) {
        Switch sw = (Switch) view;
        power.setText(sw.isChecked() ? "开" : "关");
        if(sw.isChecked()){
            seekBar.setEnabled(true);
            button0.setEnabled(true);
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);
            button5.setEnabled(true);
            button6.setEnabled(true);
            button7.setEnabled(true);
            button8.setEnabled(true);
            button9.setEnabled(true);
            button10.setEnabled(true);
            button11.setEnabled(true);
            CCTV5.setEnabled(true);
            CCTV6.setEnabled(true);
            CCTV8.setEnabled(true);
            channel.setEnabled(true);
            CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
            CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
            CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
        }else{
            seekBar.setEnabled(false);
            seekBar.setEnabled(false);
            button0.setEnabled(false);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            button10.setEnabled(false);
            button11.setEnabled(false);
            CCTV5.setEnabled(false);
            CCTV6.setEnabled(false);
            CCTV8.setEnabled(false);
            channel.setEnabled(false);
            CCTV5.setTextColor(getResources().getColor(R.color.colorDisable));
            CCTV6.setTextColor(getResources().getColor(R.color.colorDisable));
            CCTV8.setTextColor(getResources().getColor(R.color.colorDisable));

        }
    }
    public void AddClick(View view){
        CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
        j = j + 1;
        if(j >= 1000){
            j = j - 999;
            if(9 < j && j < 100){
                prechannel = "0" + String.valueOf(j);
                channel.setTextColor(getResources().getColor(R.color.colorBlack));

            }else if (0 < j && j < 10) {
                prechannel = "00" + String.valueOf(j);
                if(j == 5){
                    channel.setTextColor(getResources().getColor(R.color.colorFav));
                    CCTV5.setTextColor(getResources().getColor(R.color.colorFav));
                }else if(j == 6){
                    channel.setTextColor(getResources().getColor(R.color.colorFav));
                    CCTV6.setTextColor(getResources().getColor(R.color.colorFav));
                }else if(j == 8){
                    channel.setTextColor(getResources().getColor(R.color.colorFav));
                    CCTV8.setTextColor(getResources().getColor(R.color.colorFav));
                }else{
                    CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
                    CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
                    CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));

                }

            }
        }else if(9 < j && j < 100){
            prechannel = "0" + String.valueOf(j);
            channel.setTextColor(getResources().getColor(R.color.colorBlack));

        }else if (0 < j && j < 10){
            prechannel = "00" + String.valueOf(j);
            if(j == 5){
                channel.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV5.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
            }else if(j == 6){
                channel.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV6.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
            }else if(j == 8){
                channel.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV8.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
            }else{
                CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
                channel.setTextColor(getResources().getColor(R.color.colorBlack));

            }
        }else if(100 <= j && j<= 999){
            prechannel = String.valueOf(j);
            channel.setTextColor(getResources().getColor(R.color.colorBlack));

        } else if(j == 0 && realchannel == 0){
            prechannel = "000";
            channel.setTextColor(getResources().getColor(R.color.colorNotAvailable));

        }
        channel.setText(prechannel);
    }
    public void SubClick(View view){
        CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
        j = j - 1;

        if(j <= 0){
            j = j + 999;
            prechannel = String.valueOf(j);
            channel.setTextColor(getResources().getColor(R.color.colorBlack));

        }else if(9 < j && j < 100){
            prechannel = "0" + String.valueOf(j);
            channel.setTextColor(getResources().getColor(R.color.colorBlack));
        }else if (0 < j && j < 10){
            prechannel = "00" + String.valueOf(j);
            if(j == 5){
                channel.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV5.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
            }else if(j == 6){
                channel.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV6.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));

                CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
            }else if(j == 8){
                channel.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV8.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));

            }else{
                CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
                channel.setTextColor(getResources().getColor(R.color.colorBlack));

            }
        }else if(100 <= j && j<= 999){
            prechannel = String.valueOf(j);
            channel.setTextColor(getResources().getColor(R.color.colorBlack));
        }
        channel.setText(prechannel);
    }
    public void NumberClicked(View v){
        CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
        String num = ((Button) v).getText().toString();
        prechannel = channel.getText()+ num;
        realchannel = Integer.parseInt(prechannel);
        j = realchannel % 1000;
        if(j == 0 && realchannel !=0){
            prechannel = "00" + String.valueOf(1);
            channel.setTextColor(getResources().getColor(R.color.colorBlack));

        }else if(9 < j && j < 100){
            prechannel = "0" + String.valueOf(j);
            channel.setTextColor(getResources().getColor(R.color.colorBlack));

        }else if (0 < j && j < 10){
            prechannel = "00" + String.valueOf(j);
            if(j == 5){
                channel.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV5.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
            }else if(j == 6){
                channel.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV6.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));

                CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
            }else if(j == 8){
                channel.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV8.setTextColor(getResources().getColor(R.color.colorFav));
                CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));

            }else{
                CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
                CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
                channel.setTextColor(getResources().getColor(R.color.colorBlack));

            }
        }else if(100 <= j && j<= 999){
            prechannel = String.valueOf(j);
            channel.setTextColor(getResources().getColor(R.color.colorBlack));

        } else if(j == 0 && realchannel == 0){
            prechannel = "000";
            channel.setTextColor(getResources().getColor(R.color.colorNotAvailable));

        }
        channel.setText(prechannel);
    }
    public void Fav5Click(View view){
        j = 5;
        channel.setText("005");
        CCTV5.setTextColor(getResources().getColor(R.color.colorFav));
        CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
        channel.setTextColor(getResources().getColor(R.color.colorFav));
    }
    public void Fav6Click(View view){
        j = 6;
        channel.setText("006");
        CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV6.setTextColor(getResources().getColor(R.color.colorFav));
        CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));
        channel.setTextColor(getResources().getColor(R.color.colorFav));
    }
    public void Fav8Click(View view){
        j = 8;
        channel.setText("008");
        CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV8.setTextColor(getResources().getColor(R.color.colorFav));
        channel.setTextColor(getResources().getColor(R.color.colorFav));
    }

    public void NoClick(View view){
        channel.setText(null);
        CCTV5.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV6.setTextColor(getResources().getColor(R.color.colorBlack));
        CCTV8.setTextColor(getResources().getColor(R.color.colorBlack));

    }
}
