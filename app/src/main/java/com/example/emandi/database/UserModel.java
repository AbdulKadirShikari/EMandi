package com.example.emandi.database;

import android.database.sqlite.SQLiteDatabase;

import com.example.emandi.Mri;


public class UserModel {
    public static final String TABLE_NAME = "UserModelFuel";
    public static final String KEY_ID = "_id";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_NAME = "user_name";
    public static final String KEY_PHONE = "user_phone";
    public static final String KEY_DATE = "user_date";
    public static final String KEY_EMAIL = "user_email";
    public static final String KEY_JINS = "user_jins";
    public static final String KEY_MARK = "user_mark";
    public static final String KEY_QUANTITY = "user_quantity";
    public static final String KEY_RATE = "user_rate";
    public static final String KEY_Amount = "user_amount";

    public static void creteTable(SQLiteDatabase db) {
        String CREATE_CLIENTTABLE = "create table " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_USER_ID + " text," +
                KEY_NAME + "text," +
                KEY_PHONE +" text," +
                KEY_DATE +" text," +
                KEY_EMAIL +"text," +
                KEY_JINS +"text, " +
                KEY_MARK +"text," +
                KEY_QUANTITY +"text,"+
                KEY_RATE +"text," +
                KEY_Amount +"text"+
                ")";

        db.execSQL(CREATE_CLIENTTABLE);
        Mri.E("check Create table::"+CREATE_CLIENTTABLE);
    }

    public static void dropTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    String user_name;
    String user_email;
    String user_date;
    String user_phone;
    String user_jins;
    String user_mark;
    String user_quntity;
    String user_rate;
    String user_amount;
    String user_userId;


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_date() {
        return user_date;
    }

    public void setUser_date(String user_date) {
        this.user_date = user_date;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_jins() {
        return user_jins;
    }

    public void setUser_jins(String user_jins) {
        this.user_jins = user_jins;
    }

    public String getUser_mark() {
        return user_mark;
    }

    public void setUser_mark(String user_mark) {
        this.user_mark = user_mark;
    }

    public String getUser_quntity() {
        return user_quntity;
    }

    public void setUser_quntity(String user_quntity) {
        this.user_quntity = user_quntity;
    }

    public String getUser_rate() {
        return user_rate;
    }

    public void setUser_rate(String user_rate) {
        this.user_rate = user_rate;
    }

    public String getUser_amount() {
        return user_amount;
    }

    public void setUser_amount(String user_amount) {
        this.user_amount = user_amount;
    }

    public String getUser_userId() {
        return user_userId;
    }

    public void setUser_userId(String user_userId) {
        this.user_userId = user_userId;
    }
}
