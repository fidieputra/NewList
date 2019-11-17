package com.rbdapp.latihandbdimas.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.rbdapp.latihandbdimas.R;
import com.rbdapp.latihandbdimas.activity.TambahDataActivity;
import com.rbdapp.latihandbdimas.database.AppDatabase;
import com.rbdapp.latihandbdimas.model.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {

    Context context;
    ArrayList<Mahasiswa> data;
    AppDatabase db;

    public MahasiswaAdapter(Context context, ArrayList<Mahasiswa> data) {
        this.context = context;
        this.data = data;
        db = Room.databaseBuilder(context,
                AppDatabase.class,"db_mahasiswa").allowMainThreadQueries().build();
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mahasiswa,parent,false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, final int position) {
        holder.txtNim.setText(Integer.toString(data.get(position).getNim()));
        holder.txtNama.setText(data.get(position).getNama());
        holder.txtAlamat.setText(data.get(position).getAlamat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mahasiswa mahasiswa = db.mahasiswaDAO().detailMahasiswa(data.get(position).getIdMahasiswa());
                Intent intent = new Intent(context, TambahDataActivity.class);
                intent.putExtra("data",mahasiswa);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        TextView txtNama,txtNim,txtAlamat;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNim = itemView.findViewById(R.id.text_nim);
            txtNama = itemView.findViewById(R.id.text_nama);
            txtAlamat = itemView.findViewById(R.id.text_asal);
        }
    }
}
