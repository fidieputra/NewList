package com.rbdapp.latihandbdimas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rbdapp.latihandbdimas.activity.LihatDataActivity;
import com.rbdapp.latihandbdimas.activity.TambahDataActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_lihat;
    Button btn_tambah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_lihat = findViewById(R.id.btn_lihat);
        btn_tambah = findViewById(R.id.btn_tambah);

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TambahDataActivity.class));
            }
        });
        btn_lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LihatDataActivity.class));
            }
        });
    }
}
