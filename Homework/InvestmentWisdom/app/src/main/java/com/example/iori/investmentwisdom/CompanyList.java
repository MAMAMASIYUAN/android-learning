package com.example.iori.investmentwisdom;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CompanyList extends ListActivity {

    private static final String TAG = "CompanyList";
    private Company selectedCompany;
    private MySQLiteOpenHelper helper;
    private TextView nNAME;
    private TextView nPRICE;
    private TextView nNUMBER;
    private EditText addNAME;
    private EditText addPRICE;
    private EditText addNUMBER;
    private Button addBUTTON;
    private Button delButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        helper = new MySQLiteOpenHelper(this, "mydb.db", null, 1);
        SQLiteDatabase sqliteDatabase = helper.getWritableDatabase();
        Toast.makeText(this, "数据库创建成功", 10000).show();
        initView();
        addNewTable();
        showTableName();
        setListAdapter(new CompanyAdapter(this));
    }

    public void initView()
    {
        nNAME = (TextView) findViewById(R.id.newNameView);
//        nPRICE = (TextView) findViewById(R.id.newPriceView);
//        nNUMBER = (TextView) findViewById(R.id.newNumberView);
        addNAME = (EditText) findViewById(R.id.editNAME);
//        addPRICE = (EditText) findViewById(R.id.editPRICE);
//        addNUMBER = (EditText) findViewById(R.id.editNUMBER);
        addBUTTON = (Button) findViewById(R.id.addBUTTON);
        delButton = (Button) findViewById(R.id.delButton);
    }



    private void addNewTable() {

        addBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String newCompany = addNAME.getText().toString();
//                String newPrice = addPRICE.getText().toString();
//                String newNumber = addNUMBER.getText().toString();
                addBUTTON.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        helper = new MySQLiteOpenHelper(CompanyList.this, "mydb.db", null, 1);
                        SQLiteDatabase sqliteDatabase = helper.getWritableDatabase();
                        sqliteDatabase.execSQL("CREATE TABLE if not exists GOOGL (id INTEGER PRIMARY KEY autoincrement, NAME, TIME, PRICE, NUMBER, RETURN, UNIQUE(NAME))");
                        sqliteDatabase.execSQL("CREATE TABLE if not exists'" + newCompany + "'(id INTEGER PRIMARY KEY autoincrement, NAME, TIME, PRICE, NUMBER, RETURN, UNIQUE(NAME))");

                        Toast.makeText(CompanyList.this, "数据表创建成功", 1000).show();
                    }
                });

            }
        });
    }

    private void showTableName()
    {

        helper = new MySQLiteOpenHelper(CompanyList.this, "mydb.db", null, 1);
        SQLiteDatabase sqliteDatabase = helper.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type = 'table'", null);

        while(cursor.moveToNext())
        {
            String name = cursor.getString(0);

            final DummyContent.DummyItem [] ITEMSS =
                    {
                            new DummyContent.DummyItem( name )
                    };


        }

    }


}
