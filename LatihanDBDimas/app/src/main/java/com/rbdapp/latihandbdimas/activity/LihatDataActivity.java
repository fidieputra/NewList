package com.rbdapp.latihandbdimas.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.rbdapp.latihandbdimas.R;
import com.rbdapp.latihandbdimas.adapter.MahasiswaAdapter;
import com.rbdapp.latihandbdimas.database.AppDatabase;
import com.rbdapp.latihandbdimas.model.Mahasiswa;

import java.util.ArrayList;

public class LihatDataActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MahasiswaAdapter adapter;
    ArrayList<Mahasiswa> data;
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
        getSupportActionBar().setTitle("Data Mahasiswa");

        recyclerView = findViewById(R.id.recycle_mahasiswa);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"db_mahasiswa").allowMainThreadQueries().build();
        getData();
    }
    void getData(){
        data = new ArrayList<>();
        data.clear();
        data.addAll(db.mahasiswaDAO().getMahasiswa());
        adapter = new MahasiswaAdapter(getApplicationContext(),data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }
}
