package com.rbdapp.newlist;

public class Makanan {
    int id;
    String nama;
    int photo;

    public Makanan() {
        this.id = 0;
        this.nama = "";
        this.photo = 0;
    }

    public Makanan(int id, String nama, int photo) {
        this.id = id;
        this.nama = nama;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
