package com.example.emandi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.emandi.Mri;

import java.util.ArrayList;


public class UserDataHelper {
    private static UserDataHelper instance;
    private SQLiteDatabase db;
    private DataManager dm;
    Context cx;

    public UserDataHelper(Context cx) {
        instance = this;
        this.cx = cx;
        dm = new DataManager(cx, DataManager.DATABASE_NAME, null, DataManager.DATABASE_VERSION);
    }

    public static UserDataHelper getInstance() {

        Mri.E("mri:-getInstance:-");

        return instance;
    }

    public void open() {
        db = dm.getWritableDatabase();

    }

    public void close() {
        //  db.close();
    }

    public void read() {
        db = dm.getReadableDatabase();
    }

    public void delete(int companyId) {
        open();
        db.delete(UserModel.TABLE_NAME, UserModel.KEY_ID + " = '" + companyId + "'", null);
        close();
    }

    public void deleteAll() {
        open();
        db.delete(UserModel.TABLE_NAME, null, null);
        close();
    }

    private boolean isExist(UserModel userModel) {
        read();
        Cursor cur = db.rawQuery("select * from " + UserModel.TABLE_NAME + " where " + UserModel.KEY_ID + "='"
                + userModel.getUser_userId() + "'", null);
        if (cur.moveToFirst()) {
            return true;
        }
        return false;
    }

    public void insertData(UserModel userModel) {

        Mri.E("mr insertData01 userModel");

        open();

        Mri.E("mr insertData02 userModel");

        ContentValues values = new ContentValues();
        values.put(UserModel.KEY_USER_ID, userModel.getUser_userId());
        values.put(UserModel.KEY_NAME, userModel.getUser_name());
        values.put(UserModel.KEY_PHONE, userModel.getUser_phone());
        values.put(UserModel.KEY_DATE, userModel.getUser_date());
        values.put(UserModel.KEY_EMAIL, userModel.getUser_email());
        values.put(UserModel.KEY_JINS, userModel.getUser_jins());
        values.put(UserModel.KEY_MARK, userModel.getUser_mark());
        values.put(UserModel.KEY_QUANTITY, userModel.getUser_quntity());
        values.put(UserModel.KEY_RATE, userModel.getUser_rate());
        values.put(UserModel.KEY_Amount, userModel.getUser_amount());

        if (!isExist(userModel)) {
            Mri.E("insert successfully");
            db.insert(UserModel.TABLE_NAME, null, values);
        } else {
            Mri.E("update successfully" + userModel.getUser_userId());
            db.update(UserModel.TABLE_NAME, values, UserModel.KEY_ID + "=" + userModel.getUser_userId(), null);
        }
        close();
    }

    public ArrayList<UserModel> getList() {
        ArrayList<UserModel> userItem = new ArrayList<UserModel>();
        read();
        Cursor cursor = db.rawQuery("select * from " + UserModel.TABLE_NAME, null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToLast();
            do {
                UserModel taxiModel = new UserModel();
                taxiModel.setUser_userId(cursor.getString(cursor.getColumnIndex(UserModel.KEY_USER_ID)));
                taxiModel.setUser_name(cursor.getString(cursor.getColumnIndex(UserModel.KEY_NAME)));
                taxiModel.setUser_phone(cursor.getString(cursor.getColumnIndex(UserModel.KEY_PHONE)));
                taxiModel.setUser_email(cursor.getString(cursor.getColumnIndex(UserModel.KEY_EMAIL)));
                taxiModel.setUser_date(cursor.getString(cursor.getColumnIndex(UserModel.KEY_DATE)));
                taxiModel.setUser_jins(cursor.getString(cursor.getColumnIndex(UserModel.KEY_JINS)));
                taxiModel.setUser_mark(cursor.getString(cursor.getColumnIndex(UserModel.KEY_MARK)));
                taxiModel.setUser_quntity(cursor.getString(cursor.getColumnIndex(UserModel.KEY_QUANTITY)));
                taxiModel.setUser_rate(cursor.getString(cursor.getColumnIndex(UserModel.KEY_RATE)));
                taxiModel.setUser_amount(cursor.getString(cursor.getColumnIndex(UserModel.KEY_Amount)));
                userItem.add(taxiModel);

            } while ((cursor.moveToPrevious()));
            cursor.close();
        }
        close();
        return userItem;
    }
}