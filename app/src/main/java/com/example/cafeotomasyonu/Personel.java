package com.example.cafeotomasyonu;

public class Personel {
    String personelad;
    String personelsoyad;
    String personeltel;
    String personelsifre;
    int id;

    public String getPersonelad() {
        return personelad;
    }

    public void setPersonelad(String personelad) {
        this.personelad = personelad;
    }

    public String getPersonelsoyad() {
        return personelsoyad;
    }

    public void setPersonelsoyad(String personelsoyad) {
        this.personelsoyad = personelsoyad;
    }

    public String getPersoneltel() {
        return personeltel;
    }

    public void setPersoneltel(String personeltel) {
        this.personeltel = personeltel;
    }

    public String getPersonelsifre() {
        return personelsifre;
    }

    public void setPersonelsifre(String personelsifre) {
        this.personelsifre = personelsifre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personel(String personelad, String personelsoyad, String personeltel, String personelsifre, int id) {
        this.personelad = personelad;
        this.personelsoyad = personelsoyad;
        this.personeltel = personeltel;
        this.personelsifre = personelsifre;
        this.id = id;
    }
}
