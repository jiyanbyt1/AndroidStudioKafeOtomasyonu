package com.example.cafeotomasyonu;

public class Masa3 {
    String Siparisler;
    int id;

    public String getSiparisler() {
        return Siparisler;
    }

    public void setSiparisler(String siparisler) {
        Siparisler = siparisler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Masa3(String siparisler, int id) {
        Siparisler = siparisler;
        this.id = id;
    }
    public String toString(){
        return ""+id+"-"+Siparisler;
    }

}
