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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        db.close();
    }

    public void dropTable(String Table_Name){
        SQLiteDatabase db = this.getWritableDatabase();
        String SQL = "DROP TABLE IF EXISTS "+Table_Name;
        db.execSQL(SQL);
        db.close();
    }

    private void proses(String SQL){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SQL);
        db.close();
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

    int getCount(String SQL){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL,null);
        int hasil = cursor.getCount();
        cursor.close();
        db.close();
        return hasil;
    }

    List<List<String>> getData(String SQL){
        List<List<String>> data = new List<List<String>>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<List<String>> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(List<String> strings) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends List<String>> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends List<String>> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public List<String> get(int i) {
                return null;
            }

            @Override
            public List<String> set(int i, List<String> strings) {
                return null;
            }

            @Override
            public void add(int i, List<String> strings) {

            }

            @Override
            public List<String> remove(int i) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<List<String>> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<List<String>> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<List<String>> subList(int i, int i1) {
                return null;
            }
        };
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL,null);
        int hasil = cursor.getCount();
        cursor.close();
        db.close();
        return data;
    }

}
