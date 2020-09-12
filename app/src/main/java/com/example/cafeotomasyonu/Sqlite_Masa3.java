package com.example.cafeotomasyonu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite_Masa3 extends SQLiteOpenHelper {
    public Sqlite_Masa3(Context c){

        super (c,"Masa3",null,3);
    }
    public void onCreate(SQLiteDatabase db3){
        String komut3="create table tablomasa3(id integer primary key autoincrement, Siparisler text not null)";
        db3.execSQL(komut3);
    }
    public void onUpgrade(SQLiteDatabase db3,int eski3,int yeni3){
        db3.execSQL("drop table if exists tablomasa3");
    }
}
