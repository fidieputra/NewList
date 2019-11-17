package com.rbdapp.newlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    Button bt_view,bt_add;
    Makanan makanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_view = (Button)findViewById(R.id.bt_view_makanan);
        bt_add = (Button)findViewById(R.id.bt_tambah_makanan);
        makanan=new Makanan();
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahView();
            }
        });
        bt_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tampilView();
            }
        });

    }

    private void tampilView() {
        Intent pindah = new Intent(MainActivity.this,ViewMakananActivity.class);
        //Glide.with(context).load(dataMakanan.get(position).getPhoto()).into(holder.gambar);
        startActivity(pindah);
    }

    private void tambahView() {
        Intent pindah = new Intent(MainActivity.this,TambahActivity.class);
        startActivity(pindah);
    }
}
