package com.example.iori.inq;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class DeleteDetailDialog extends Activity implements View.OnClickListener {

    private EditText idView;
    private MySQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_detail_dialog);

        Intent intent = getIntent();
        String title = intent.getStringExtra("companyTitle");
        TextView companyName = (TextView) findViewById(R.id.chooseCompany);
        companyName.setText(title);
        CompanyArray.companyName[0] = title;

        init();
    }

    private void init() {

        findViewById(R.id.delete_detail_confirm).setOnClickListener(this);
        findViewById(R.id.delete_detail_cancel).setOnClickListener(this);
        idView = (EditText) findViewById(R.id.delete_text_id);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.delete_detail_confirm:
                confirm();
                break;
            case R.id.delete_detail_cancel:
                cancel();
                break;

        }

    }
    // Perform the delete
    private void confirm() {

        helper = new MySQLiteOpenHelper(this, "mydb.db", null, 1);
        SQLiteDatabase sqliteDabase = helper.getWritableDatabase();
        String sql = "id = ?";
        String wheres[] = {String.valueOf(idView.getText())};
        sqliteDabase.delete(String.valueOf(CompanyArray.companyName[0]), sql, wheres);
        sqliteDabase.close();
        helper.close();

    }
    // cancel the delete
    private void cancel() {

        String companyTitle = CompanyArray.companyName[0];
        Intent intent = new Intent(DeleteDetailDialog.this, CompanyDetailes.class);
        intent.putExtra("companyTitle", companyTitle);
        startActivity(intent);
    }
}
