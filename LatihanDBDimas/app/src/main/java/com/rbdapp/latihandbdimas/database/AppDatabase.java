package com.rbdapp.latihandbdimas.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.rbdapp.latihandbdimas.dao.MahasiswaDAO;
import com.rbdapp.latihandbdimas.model.Mahasiswa;

@Database(entities = Mahasiswa.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MahasiswaDAO mahasiswaDAO();
}
