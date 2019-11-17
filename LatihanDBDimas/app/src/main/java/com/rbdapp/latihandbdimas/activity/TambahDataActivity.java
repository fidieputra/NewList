package com.rbdapp.latihandbdimas.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rbdapp.latihandbdimas.MainActivity;
import com.rbdapp.latihandbdimas.R;
import com.rbdapp.latihandbdimas.database.AppDatabase;
import com.rbdapp.latihandbdimas.model.Mahasiswa;

public class TambahDataActivity extends AppCompatActivity {
    EditText edt_nim;
    EditText edt_nama;
    EditText edt_asal;
    Button btn_submit;
    AppDatabase db;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"db_mahasiswa").build();
        edt_asal = findViewById(R.id.edt_asal);
        edt_nama = findViewById(R.id.edt_nama);
        edt_nim = findViewById(R.id.edt_nim);
        btn_submit =  findViewById(R.id.btn_submit_tambah);

        mahasiswa = (Mahasiswa) getIntent().getSerializableExtra("data");

        if(mahasiswa!=null){
            edt_nim.setText((mahasiswa.getNim()));
            edt_nama.setText((mahasiswa.getNama()));
            edt_asal.setText((mahasiswa.getAlamat()));
            btn_submit.setText("Update");
            btn_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mahasiswa.setNim(Integer.parseInt(edt_nim.getText().toString()));
                    mahasiswa.setNama(edt_nama.getText().toString());
                    mahasiswa.setAlamat(edt_asal.getText().toString());
                    updateMahasiswa(mahasiswa);
                    startActivity(new Intent(TambahDataActivity.this, LihatDataActivity.class));
                }
            });
        }
        else
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswa = new Mahasiswa(Integer.parseInt(edt_nim.getText().toString()),
                        edt_nama.getText().toString(),edt_asal.getText().toString());
//                mahasiswa.setNim(Integer.parseInt(edt_nim.getText().toString()));
//                mahasiswa.setNama(edt_nama.getText().toString());
//                mahasiswa.setAlamat(edt_asal.getText().toString());
                insertMahasiswa(mahasiswa);
                startActivity(new Intent(TambahDataActivity.this, LihatDataActivity.class));
            }
        });
        getSupportActionBar().setTitle("Tambah Data Mahasiswa");
    }
    @SuppressLint("StaticFieldLeak")
    public void insertMahasiswa(final Mahasiswa mahasiswa){
        new AsyncTask<Void,Void,Long>(){

            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.mahasiswaDAO().insertMahasiswa(mahasiswa);
                return status;
            }

            @Override
            protected void onPostExecute(Long aLong) {
                super.onPostExecute(aLong);
                Toast.makeText(TambahDataActivity.this,"Data berhasil di insert",Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }
    @SuppressLint("StaticFieldLeak")
    public void updateMahasiswa(final Mahasiswa mahasiswa){
        new AsyncTask<Void,Void,Long>(){

            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.mahasiswaDAO().updateMahasiswa(mahasiswa);
                return status;
            }

            @Override
            protected void onPostExecute(Long aLong) {
                super.onPostExecute(aLong);
                Toast.makeText(TambahDataActivity.this,"Data berhasil di update",Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }
}
