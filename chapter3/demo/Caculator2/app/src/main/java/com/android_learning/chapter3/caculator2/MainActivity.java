package com.android_learning.chapter3.caculator2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    private Button btnAdd;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEquals;
    private TextView tvResult;
    private int i;
//    private TextView tvResult2;
//    private TextView tvResult3;
//    private TextView tvResult4;
    private boolean isTypingNumber;
    private int firstNum = 0;
    private int secondNum = 0;
    private String operatorString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildControls();
    }

    private void buildControls() {
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
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        tvResult = (TextView) findViewById(R.id.tvResult);
//        tvResult2 = (TextView) findViewById(R.id.tvResult);
//        tvResult3 = (TextView) findViewById(R.id.tvResult);
//        tvResult4 = (TextView) findViewById(R.id.tvResult);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberClicked(v);
            }
        };

        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddClicked(v);
                i = 1;
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubClicked(v);
                i = 2;
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MutClicked(v);
                i = 3;
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DivClicked(v);
                i = 4;
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EqualsClicked(v);
            }
        });
        tvResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tvResult.setText("");
            }
        });
    }

    private void EqualsClicked(View v) {
//        isTypingNumber = false;
//        switch(i) {
            isTypingNumber = false;
            secondNum = Integer.parseInt(tvResult.getText().toString());
            if(i==1){
                String result = String.valueOf(firstNum + secondNum);
                tvResult.setText(result);
        }else if (i==2){
                String result = String.valueOf(firstNum - secondNum);
                tvResult.setText(result);
            }else if (i==3){
                String result = String.valueOf(firstNum * secondNum);
                tvResult.setText(result);
            }else if (i==4){
                String result = String.valueOf(firstNum / secondNum);
                tvResult.setText(result);
            }
    }

    private void AddClicked(View v) {
        isTypingNumber = false;
        firstNum = Integer.parseInt(tvResult.getText().toString());

        operatorString = ((Button) v).getText().toString();
    }
    private void SubClicked(View v) {
        isTypingNumber = false;
        firstNum = Integer.parseInt(tvResult.getText().toString());

        operatorString = ((Button) v).getText().toString();
    }
    private void MutClicked(View v) {
        isTypingNumber = false;
        firstNum = Integer.parseInt(tvResult.getText().toString());

        operatorString = ((Button) v).getText().toString();
    }
    private void DivClicked(View v) {
        isTypingNumber = false;
        firstNum = Integer.parseInt(tvResult.getText().toString());

        operatorString = ((Button) v).getText().toString();
    }

    private void NumberClicked(View v) {
        String num = ((Button) v).getText().toString();

        if (isTypingNumber) {
            tvResult.setText(tvResult.getText() + num);
        } else {
            tvResult.setText(num);
            isTypingNumber = true;
        }
    }
}


