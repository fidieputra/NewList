package com.rbdapp.latihandbdimas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rbdapp.latihandbdimas.R;

public class LihatDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        getSupportActionBar().setTitle("Data Mahasiswa");
    }
}
