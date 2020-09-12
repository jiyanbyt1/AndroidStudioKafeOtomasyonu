package com.example.cafeotomasyonu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite_Masa1 extends SQLiteOpenHelper {


    //VERİTABANI İŞLEMLERİ İÇİN KULLANILIYOR...

    public Sqlite_Masa1(Context c){

        super(c,"Masa1",null,1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql="create table tablomasa1(id integer primary key autoincrement , Siparisler text not null)";
        db.execSQL(sql);


    }
    public void onUpgrade(SQLiteDatabase db, int eski, int yeni){
        db.execSQL("drop table if exists tablomasa1");

    }
   /* public void resetTables(){
        // Tüm verileri siler. tabloyu resetler.
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("tablomasa1",null,null);
        db.close();
    }*/
}
