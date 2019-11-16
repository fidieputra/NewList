package com.rbdapp.newlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.rbdapp.newlist.Makanan;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {
    // static variable
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "latihan";

    // table name
    private static final String TABLE_Name = "makanan";

    // column tables
    private static final String KEY_ID = "id";
    private static final String V1 = "nama";
    private static final String V2 = "photo";
    public String test;

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Name+ "("
                + KEY_ID + " INTEGER PRIMARY KEY," + V1 + " TEXT,"
                + V2 + " TEXT" + ")";
        test = CREATE_TABLE;
        db.execSQL(CREATE_TABLE);
    }

    // on Upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Name);
        onCreate(db);
    }

    public void addRecord(Makanan userModels){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, userModels.getId());
        values.put(V1, userModels.getNama());
        values.put(V2, userModels.getPhoto());

        db.insert(TABLE_Name, null, values);
        db.close();
    }

    public Makanan getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Name, new String[] { KEY_ID,
                        V1, V2 }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Makanan data = new Makanan(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2));
        // return contact
        return data;
    }

    // get All Record
    public List<Makanan> getAllRecord() {
        List<Makanan> makanantList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_Name;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Makanan userModels = new Makanan();
                userModels.setId(Integer.parseInt(cursor.getString(0)));
                userModels.setNama(cursor.getString(1));
                userModels.setPhoto(cursor.getInt(2));

                makanantList.add(userModels);
            } while (cursor.moveToNext());
        }

        // return contact list
        return makanantList;
    }
    //get jumlah data
    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_Name;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    //update
    public int updateData(Makanan data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(V1, data.getNama());
        values.put(V2, data.getPhoto());

        // updating row
        return db.update(TABLE_Name, values, KEY_ID + " = ?",
                new String[] { String.valueOf(data.getId()) });
    }
    //delete
    public void deleteData(Makanan data) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Name, KEY_ID + " = ?",
                new String[] { String.valueOf(data.getId()) });
        db.close();
    }
}
