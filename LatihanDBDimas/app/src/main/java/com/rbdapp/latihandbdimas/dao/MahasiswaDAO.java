package com.rbdapp.latihandbdimas.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.rbdapp.latihandbdimas.model.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMahasiswa(Mahasiswa mahasiswa);

    @Query("Select * From tb_mahasiswa")
    List<Mahasiswa> getMahasiswa();

    @Update
    int updateMahasiswa(Mahasiswa mahasiswa);

    @Delete
    int deleteMahasiswa(Mahasiswa mahasiswa);

    @Query("Select * From tb_mahasiswa Where idMahasiswa=:id Limit 1")
    Mahasiswa detailMahasiswa(int id);

}
