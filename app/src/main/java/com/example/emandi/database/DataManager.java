package com.example.emandi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class DataManager extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyMandi";

    public DataManager(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        UserModel.creteTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int paramInt1, int paramInt2) {

        UserModel.dropTable(db);
        onCreate(db);
    }
}