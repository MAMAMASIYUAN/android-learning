package com.example.iori.inq;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CompanyDetailAdd extends AppCompatActivity implements View.OnClickListener{

    private MySQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail_add);

        String title = CompanyArray.companyName[0];
        TextView companyName = (TextView) findViewById(R.id.selectedCompany);
        companyName.setText(title);

        helper = new MySQLiteOpenHelper(this, "mydb.db", null, 1);
        addNewCompanyDetail();
        cancelAdd();
    }

    private void cancelAdd() {
        Button cancelAdd = (Button) findViewById(R.id.cancelAddDetail);
        cancelAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String companyTitle = CompanyArray.companyName[0];
                Intent intent = new Intent(CompanyDetailAdd.this, CompanyDetailes.class);
                intent.putExtra("companyTitle", companyTitle);
                startActivity(intent);

            }
        });
    }

    private void addNewCompanyDetail() {


        Button addCompanyDetail = (Button) findViewById(R.id.addCompanyDetail);

        addCompanyDetail.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText addTime = (EditText) findViewById(R.id.addTimeDetail);
                EditText addPrice = (EditText) findViewById(R.id.addPriceDetail);
                EditText addNumber = (EditText) findViewById(R.id.addNumberDetail);

                SQLiteDatabase sqliteDatabase = helper.getWritableDatabase();
//                sqliteDatabase.execSQL("CREATE TABLE if not exists GOOGLE (id INTEGER PRIMARY KEY autoincrement, NAME String, TIME int, PRICE float, NUMBER int, RETURN float, UNIQUE(NAME))");
                ContentValues values = new ContentValues();
                String  time = addTime.getText().toString();
                String price = addPrice.getText().toString();
                String number = addNumber.getText().toString();
                Float cost = Float.valueOf(price) * Float.valueOf(number);
                values.put("TIME", Integer.valueOf(time));
                values.put("PRICE", Float.valueOf(price));
                values.put("NUMBER", Integer.valueOf(number));
                values.put("COST", cost);
                sqliteDatabase.insert("GOOGLE", null, values);
//                Toast.makeText(CompanyDetailAdd.this, "yes", Toast.LENGTH_LONG).show();
                sqliteDatabase.close();
                helper.close();

            }
        });

    }


    @Override
    public void onClick(View view) {

    }
}
