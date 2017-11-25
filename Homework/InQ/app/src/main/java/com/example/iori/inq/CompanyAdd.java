package com.example.iori.inq;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CompanyAdd extends AppCompatActivity implements View.OnClickListener{

    private MySQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_add);
        helper = new MySQLiteOpenHelper(this, "mydb.db", null, 1);
        addNewCompany();
        cancelAdd();
    }

    private void cancelAdd() {
        Button cancelAdd = (Button) findViewById(R.id.cancelAdd);
        cancelAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CompanyAdd.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    private void addNewCompany() {


        Button addCompany = (Button) findViewById(R.id.addCompany);

        addCompany.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText addName = (EditText) findViewById(R.id.addName);
                EditText addTime = (EditText) findViewById(R.id.addTime);
                EditText addPrice = (EditText) findViewById(R.id.addPrice);
                EditText addNumber = (EditText) findViewById(R.id.addNumber);


                SQLiteDatabase sqliteDatabase = helper.getWritableDatabase();
                sqliteDatabase.execSQL("CREATE TABLE if not exists'" + addName.getText() + "'(id INTEGER PRIMARY KEY autoincrement, NAME String, TIME int, PRICE float, NUMBER int, RETURN float, UNIQUE(NAME))");
                ContentValues values = new ContentValues();
                String  time = addTime.getText().toString();
                String price = addPrice.getText().toString();
                String number = addNumber.getText().toString();
                values.put("TIME", Integer.valueOf(time));
                values.put("PRICE", Float.valueOf(price));
                values.put("NUMBER", Integer.valueOf(number));
                sqliteDatabase.insert(String.valueOf(addName.getText()), null, values);
                Toast.makeText(CompanyAdd.this, "yes", Toast.LENGTH_LONG).show();
                sqliteDatabase.close();
                helper.close();

            }
        });

    }


    @Override
    public void onClick(View view) {

    }
}
