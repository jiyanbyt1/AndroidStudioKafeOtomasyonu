package com.example.cafeotomasyonu;

public class Masa1 {
    String Siparisler;
    int id;

//KULLANDIĞIMIZ GEÇİCİ BİR YAPI...


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

    public Masa1(String siparisler, int id) {
        Siparisler = siparisler;
        this.id = id;
    }

    public String toString(){
        return ""+id+"-"+Siparisler;
    }
}
