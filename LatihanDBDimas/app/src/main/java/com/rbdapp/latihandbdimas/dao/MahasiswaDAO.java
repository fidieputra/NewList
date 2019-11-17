package com.rbdapp.latihandbdimas.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.rbdapp.latihandbdimas.model.Mahasiswa;

@Dao
public interface MahasiswaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMahasiswa(Mahasiswa mahasiswa);
}
