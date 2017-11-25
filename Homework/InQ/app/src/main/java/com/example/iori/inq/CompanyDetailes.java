package com.example.iori.inq;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CompanyDetailes extends AppCompatActivity {

    private MySQLiteOpenHelper helper;
    ListView listView;
    private List<Company> mlistComanyDetail = new ArrayList<Company>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_detailes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get the Company Name
        Intent intent = getIntent();
        String title = intent.getStringExtra("companyTitle");
        TextView companyName = (TextView) findViewById(R.id.companyName);
        companyName.setText(title);
        CompanyArray.companyName[0] = title;

        listView = (ListView) this.findViewById(R.id.listViewDetails);
        setCompany();
        listView.setAdapter(new ListViewAdapter(mlistComanyDetail));

        //Set long click items
        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

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


                Intent intent = new Intent(CompanyDetailes.this, CompanyDetailAdd.class);
                startActivity(intent);
                return true;
            case 1:

                String chooseCompany = CompanyArray.companyName[0];
                Intent intentChoose = new Intent(CompanyDetailes.this, DeleteDetailDialog.class);
                intentChoose.putExtra("companyTitle", chooseCompany);
                startActivity(intentChoose);
                Intent deleteIntent = new Intent(CompanyDetailes.this, DeleteDetailDialog.class);
                return true;
//            case 2:
//                Toast.makeText(CompanyDetailes.this, "You clicked Item3", Toast.LENGTH_SHORT).show();
//                return true;
        }
        return false;
    }

    public class ListViewAdapter extends BaseAdapter {

        //list view
        View[] itemViews;

        public ListViewAdapter(List<Company> mlistCompanyDetail) {

            itemViews = new View[mlistCompanyDetail.size()];
            for(int i = 0; i < mlistCompanyDetail.size(); i++) {
                Company getCompany = (Company) mlistCompanyDetail.get(i);
                itemViews[i] = makeItemView (getCompany.getId(), getCompany.getTime(), getCompany.getPrice(), getCompany.getNumber(), getCompany.getRreturn());
            }

        }

        @Override
        public int getCount() {
            return itemViews.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent) {
            if (converView == null) {
                return itemViews[position];
            }
            return  converView;
        }

        //Set items for list view
        private View makeItemView(int strId, int strTime, float strPrice, int strNumber, float strReturn) {
            LayoutInflater inflater = (LayoutInflater) CompanyDetailes.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflater.inflate(R.layout.item_detail, null);
            TextView mId = (TextView) itemView.findViewById(R.id.idDetailContent);
            mId.setText(String.valueOf(strId));
            TextView mTime = (TextView) itemView.findViewById(R.id.timeDetailContent);
            mTime.setText(String.valueOf(strTime));
            TextView mPrice = (TextView) itemView.findViewById(R.id.priceDetailContent);
            mPrice.setText(String.valueOf(strPrice));
            TextView mNumber = (TextView) itemView.findViewById(R.id.numberDetailContent);
            mNumber.setText(String.valueOf(strNumber));
            TextView mRetrun = (TextView) itemView.findViewById(R.id.returnDetailContent);
            mRetrun.setText(String.valueOf(strReturn * 100) + "%");

            return itemView;

        }
    }

    //Set Company information
    public void setCompany() {
        mlistComanyDetail.clear();
        String selectedCompany = CompanyArray.companyName[0];
        helper = new MySQLiteOpenHelper(this, "mydb.db", null, 1);
        SQLiteDatabase sqliteDatabase = helper.getWritableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery("SELECT * FROM " + selectedCompany , null);
        while(cursor.moveToNext()) {

            int allNumber = 0;
            float allCOST = 0;
            int newId = cursor.getInt(cursor.getColumnIndex("id"));
            int newTime = cursor.getInt(cursor.getColumnIndex("TIME"));
            float newPrice = cursor.getFloat(cursor.getColumnIndex("PRICE"));
            int newNumber = cursor.getInt(cursor.getColumnIndex("NUMBER"));
            float newCost = cursor.getFloat(cursor.getColumnIndex("COST"));
            allCOST = newCost + allCOST;
            allNumber = newNumber + allNumber;
            float allReturn = allNumber * newPrice;
            float newReturn = (allReturn - allCOST) / allCOST;

            Company information = new Company();
            information.setId(newId);
            information.setTime(newTime);
            information.setPrice(newPrice);
            information.setNumber(newNumber);
            information.setRreturn((float)(Math.round(newReturn * 100)) / 100);
            mlistComanyDetail.add(information);

        }
        cursor.close();
        sqliteDatabase.close();
        helper.close();
    }

}

