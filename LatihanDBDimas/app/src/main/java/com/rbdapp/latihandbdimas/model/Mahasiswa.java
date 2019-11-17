package com.rbdapp.latihandbdimas.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tb_mahasiswa")
public class Mahasiswa implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idMahasiswa;
    @ColumnInfo(name = "nim")
    int nim;
    @ColumnInfo(name = "nama")
    String nama;
    @ColumnInfo(name = "alamat")
    String alamat;

    public Mahasiswa(int nim, String nama, String alamat) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
    }

//    @Ignore
//    public Mahasiswa() {
//    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }


    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
