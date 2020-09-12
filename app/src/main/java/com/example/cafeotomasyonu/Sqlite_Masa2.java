package com.example.cafeotomasyonu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite_Masa2 extends SQLiteOpenHelper {

    public Sqlite_Masa2(Context c){

        super (c,"Masa2",null,2);
    }
    public void onCreate(SQLiteDatabase db2){
        String komut2="create table tablomasa2(id integer primary key autoincrement, Siparisler text not null)";
        db2.execSQL(komut2);

    }
    public void onUpgrade(SQLiteDatabase db2, int eski2,int yeni2){
        db2.execSQL("drop table if exists tablomasa2");
    }
}
