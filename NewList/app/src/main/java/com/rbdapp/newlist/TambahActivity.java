package com.rbdapp.newlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper  dbHelper;
    TextView et_tambah;
    Button bt_tambah;
    Makanan makanan;
    Context context;
    //SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_et);
        dbHelper = new DataHelper(TambahActivity.this);
        makanan = new Makanan();
        et_tambah = (EditText)findViewById(R.id.et_tambah);
        bt_tambah = (Button)findViewById(R.id.bt_tambah);
        bt_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDatabase();
            }
        });
    }

    private void addToDatabase() {
        dbHelper.getWritableDatabase();
        String input = et_tambah.getText().toString();
        Toast.makeText(TambahActivity.this, dbHelper.test, Toast.LENGTH_SHORT).show();
        if(!input.isEmpty()){
            //int urut=dbHelper.getCount();
//            makanan.setId(urut);
//            makanan.setNama(input);
//            makanan.setPhoto(R.mipmap.img1_foreground+(urut*3));
//            dbHelper.addRecord(makanan);
            //Toast.makeText(this, "Add "+input+" Berhasil", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
    }

}
