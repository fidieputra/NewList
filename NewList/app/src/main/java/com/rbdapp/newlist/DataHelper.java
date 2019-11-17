package com.rbdapp.newlist;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "data.db";
    private static final int DATABASE_VERSION = 1;
    private String TABLE_NAME = "makanan";
//    public String test;

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Buat Table
        String sql = "create table "+TABLE_NAME+"(id integer primary key, nama text, photo integer);";
        Log.d("Data", "onCreate: " + sql);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void createTable(String SQL){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SQL);
    }

    public void dropTable(String Table_Name){
        SQLiteDatabase db = this.getWritableDatabase();
        String SQL = "DROP TABLE IF EXISTS "+Table_Name;
        db.execSQL(SQL);
    }

    private void proses(String SQL){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SQL);
    }

    public void insert(String SQL){
        proses(SQL);
    }
    public void update(String SQL){
        proses(SQL);
    }
    public void delete(String SQL){
        proses(SQL);
    }

    int getCOut(String SQL){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor = db.(SQL,null);
    }
}
