package com.example.cafeotomasyonu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//VERİTABANI İŞLEMLERİ İÇİN KULLANILIYOR...
public class SQLite_Personel extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Cafe";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO_PERSONELLER = "Personeller";
    private static final String ROW_ID = "id";
    private static final String ROW_AD = "personelad";
    private static final String ROW_SOYAD = "personelsoyad";
    private static final String ROW_TEL = "personeltel";
    private static final String ROW_SIFRE = "personelsifre";
    public SQLite_Personel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_PERSONELLER + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_AD + " TEXT NOT NULL, "
                + ROW_SOYAD + " TEXT NOT NULL, "
                + ROW_TEL + " TEXT NOT NULL, "
                + ROW_SIFRE+" TEXT NOT NULL )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
    public void VeriEkle(String personelad, String personelsoyad, String personeltel, String personelsifre){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_AD, personelad);
            cv.put(ROW_SOYAD, personelsoyad);
            cv.put(ROW_TEL, personeltel);
            cv.put(ROW_SIFRE, personelsifre);
            db.insert(TABLO_PERSONELLER, null,cv);
        }catch (Exception e){
        }
        db.close();
    }

    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_ID,ROW_AD,ROW_SOYAD,ROW_TEL,ROW_SIFRE};
            Cursor cursor = db.query(TABLO_PERSONELLER, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                veriler.add(cursor.getInt(0)
                        + " -ADI= "
                        + cursor.getString(1)
                        + " -SOYADI: "
                        + cursor.getString(2)
                        + " -NUMARASI: "
                        + cursor.getString(3)
                        +" -ŞİFRESİ: "
                        + cursor.getString(4));
                cursor.moveToNext();
            }
        }catch (Exception e){
        }
        db.close();
        return veriler;
    }


    public void VeriSil(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            // id ye göre verimizi siliyoruz
            String where = ROW_ID + " = " + id ;
            db.delete(TABLO_PERSONELLER,where,null);
        }catch (Exception e){
        }
        db.close();
    }
}
