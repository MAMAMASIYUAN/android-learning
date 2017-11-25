package com.example.iori.investmentwisdom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IORI on 11/10/2017.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {


    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);

    }


    public void onCreate(SQLiteDatabase db) {


    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }


    public void onOpen(SQLiteDatabase db) {


        super.onOpen(db);

    }
}
