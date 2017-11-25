package com.example.iori.inq;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteDialog extends Activity implements View.OnClickListener{

    private EditText nameView;
    private MySQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_dialog);
        init();
    }
    //init view
    private void init() {

        findViewById(R.id.delete_confirm).setOnClickListener(this);
        findViewById(R.id.delete_cancel).setOnClickListener(this);
        nameView = (EditText) findViewById(R.id.delete_company_name);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.delete_confirm:
                confirm();
                break;
            case R.id.delete_cancel:
                cancel();
                break;
        }

    }
    // cancel delete
    private void cancel() {
        Intent Intent = new Intent(DeleteDialog.this, MainActivity.class);
        startActivity(Intent);
    }
    //Perform the delete
    private void confirm() {

        String choosedTable;
        choosedTable = String.valueOf(nameView.getText());
        helper =  new MySQLiteOpenHelper(this, "mydb.db", null, 1);
        SQLiteDatabase sqliteDatabase = helper.getWritableDatabase();
        sqliteDatabase.execSQL("DROP TABLE IF EXISTS " + choosedTable);
        helper.close();
        Toast.makeText(DeleteDialog.this, "Deleted successfully, please click Cancel to back.", Toast.LENGTH_LONG).show();


    }
}
