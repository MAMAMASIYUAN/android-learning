package com.example.iori.inq;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private MySQLiteOpenHelper helper;
    ListView listView;
    private List<Company> mlistCompany = new ArrayList<Company>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new MySQLiteOpenHelper(this, "mydb.db", null, 1);
        SQLiteDatabase sqliteDatabase = helper.getWritableDatabase();

        //Create an example for test.
        sqliteDatabase.execSQL("CREATE TABLE if not exists GOOGLE (id INTEGER PRIMARY KEY AUTOINCREMENT, NAME String, TIME int, PRICE float, NUMBER int, COST float, RETURN float, UNIQUE(NAME))");
        sqliteDatabase.execSQL("CREATE TABLE if not exists APPLE (id INTEGER PRIMARY KEY AUTOINCREMENT, NAME String, TIME int, PRICE float, NUMBER int, COST float, RETURN float, UNIQUE(NAME))");
        ContentValues values = new ContentValues();
        values.put("TIME", 1);
        values.put("PRICE", 100.1f);
        values.put("NUMBER", 1);
        values.put("COST", 98.1f);
//        values.put("RETURN", 1.1f);
        sqliteDatabase.insert("GOOGLE", null, values);
        sqliteDatabase.insert("APPLE", null, values);
//        Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_LONG).show();
        sqliteDatabase.close();
        helper.close();

        listView = (ListView) this.findViewById(R.id.listView);
        setCompany();
        listView.setAdapter(new ListViewAdapter(mlistCompany));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Send Company Name to Activity CompanyDetailes.
                Company getObject = mlistCompany.get(position);
                String companyTitle = getObject.getTitle();
                Intent intent = new Intent(MainActivity.this, CompanyDetailes.class);
                intent.putExtra("companyTitle", companyTitle);
                startActivity(intent);
//                Toast.makeText(MainActivity.this, "信息ID:"+ companyTitle,Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                //Set Add, Delete menus
                contextMenu.setHeaderTitle("Menu");
                contextMenu.add(0, 0, 0, "Add");
                contextMenu.add(0, 1, 1, "Delete");
//                contextMenu.add(0, 2, 2, "Item3");

            }
        });

    }

    public boolean onContextItemSelected(MenuItem aItem) {
        AdapterView.AdapterContextMenuInfo Company = (AdapterView.AdapterContextMenuInfo) aItem.getMenuInfo();
        switch (aItem.getItemId()) {
            case 0:
                Intent intent = new Intent(MainActivity.this, CompanyAdd.class);
                startActivity(intent);
                return true;
            case 1:
                Intent deleteIntent = new Intent(MainActivity.this, DeleteDialog.class);
                startActivity(deleteIntent);
                return true;
//            case 2:
//                Toast.makeText(MainActivity.this, "You clicked Item3", Toast.LENGTH_SHORT).show();
//                return true;
        }
        return false;
    }


    public class ListViewAdapter extends BaseAdapter {

        //List view
        View[] itemViews;

        public ListViewAdapter(List<Company> mlistCompany) {

            itemViews = new View[mlistCompany.size()];
            for(int i = 0; i < mlistCompany.size(); i++) {
                Company getCampany = (Company) mlistCompany.get(i);
                itemViews[i] = makeItemView (getCampany.getTitle(), getCampany.getTime(),getCampany.getRreturn());
            }
        }

        @Override
        public int getCount() {
            return itemViews.length;
        }

        @Override
        public Object getItem(int position) {
            return itemViews[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView (int position, View converView, ViewGroup parent) {
            if (converView == null) {
                return itemViews[position];
            }
            return converView;
        }

        //Set items for list view
        private View makeItemView(String strTitle, Integer strTime, Float strReturn) {
            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflater.inflate(R.layout.item, null);
            TextView title = (TextView) itemView.findViewById(R.id.title);
            title.setText(strTitle);
            TextView time = (TextView) itemView.findViewById(R.id.timeContent);
            time.setText(String.valueOf(strTime));
            TextView rrturn = (TextView) itemView.findViewById(R.id.returnContent);
            rrturn.setText(String.valueOf(strReturn * 100) + "%");

            return itemView;
        }
    }
    //Set Company information
    public void setCompany() {
        mlistCompany.clear();
        helper = new MySQLiteOpenHelper(this, "mydb.db", null, 1);
        SQLiteDatabase sqliteDatabase = helper.getWritableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type = 'table'", null);
        while(cursor.moveToNext()) {
            String name = cursor.getString(0);
            if( !name.equals("android_metadata") && !name.equals("sqlite_sequence")) {

                Cursor cursorDetail = sqliteDatabase.rawQuery("SELECT * FROM " + name, null);
                while(cursorDetail.moveToNext()) {

                    int allNumber = 0;
                    float allCOST = 0;
                    float newPrice = cursorDetail.getFloat(cursorDetail.getColumnIndex("PRICE"));
                    int newNumber = cursorDetail.getInt(cursorDetail.getColumnIndex("NUMBER"));
                    float newCost = cursorDetail.getFloat(cursorDetail.getColumnIndex("COST"));
                    allCOST = newCost + allCOST;
                    allNumber = newNumber + allNumber;
                    float allReturn = allNumber * newPrice;
                    float newReturn = (allReturn - allCOST) / allCOST;
                    Company information = new Company();
                    information.setTitle(name);
                    while(cursorDetail.moveToLast()) {
                        int newTime = cursorDetail.getInt(cursorDetail.getColumnIndex("TIME"));
                        information.setTime(newTime);
                        break;
                    }
                    information.setRreturn((float)(Math.round(newReturn * 100)) / 100);
                    mlistCompany.add(information);
                }

                cursorDetail.close();

            }
        }
        cursor.close();
        helper.close();
    }
}
