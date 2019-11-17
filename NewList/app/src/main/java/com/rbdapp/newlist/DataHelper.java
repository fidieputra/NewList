package com.rbdapp.newlist;

import android.content.Context;
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
    public String test;

    public DataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    public DataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public DataHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, DATABASE_NAME, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table biodata(no integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
        test = sql;
        Log.d("Data", "onCreate: " + sql);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
