package com.example.cafeotomasyonu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class VeriKaynagi1 {

    SQLiteDatabase db;
    Sqlite_Masa1 bdb;

    public VeriKaynagi1(Context c){
        bdb=new Sqlite_Masa1(c);

    }

    public void ac(){
        db=bdb.getWritableDatabase();
    }
    public void kapat(){
        bdb.close();
    }

    public void SiparisOlustur(Masa1 k){
        //String Siparisler="kebap";
        // Masa1 k=new Masa1();
        //k.setSiparisler(Siparisler);

        ContentValues val=new ContentValues();
        val.put("Siparisler",k.getSiparisler());

        db.insert("tablomasa1",null,val);



    }
    public void SiparisSil(Masa1 k){
        int id=k.getId();

        db.delete("tablomasa1",null,null);
        db.close();


    }
    public void Sil(Masa1 k){
        int id=k.getId();
        db.delete("tablomasa1","id="+id,null);

    }




    public List<Masa1> listele(){
        String[] Kolonlar = {"id", "Siparisler"};
        List<Masa1> liste=new ArrayList<Masa1>();
        Cursor c=db.query("tablomasa1",Kolonlar, null,null,null,null,null);
        c.moveToFirst();

        while (!c.isAfterLast()){
            int id=c.getInt(0);
            String Siparisler=c.getString(1);
            String eleman=""+id+"-"+Siparisler ;


            Masa1 k=new Masa1(Siparisler,id);

            liste.add(k);
            c.moveToNext();


        }
        c.close();
        return liste;
    }

}
