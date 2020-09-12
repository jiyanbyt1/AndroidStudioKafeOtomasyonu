package com.example.cafeotomasyonu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class VeriKaynagi2 {
    SQLiteDatabase db2;
    Sqlite_Masa2 bdb2;

    public VeriKaynagi2(Context c){
        bdb2=new Sqlite_Masa2(c);
    }
    public void masa2ac(){
        db2=bdb2.getWritableDatabase();
    }
    public void masa2kapat(){
        bdb2.close();
    }

    public void Masa2SiparisOlustur(Masa2 k2){
        ContentValues val2=new ContentValues();
        val2.put("Siparisler",k2.getSiparisler());
        db2.insert("tablomasa2",null,val2);

    }
    public void Masa2SiparisSil(Masa2 k2){
        int id= k2.getId();
        db2.delete("tablomasa2",null,null);
        db2.close();

    }
    public void Masa2Silme(Masa2 k2){
        int id=k2.getId();
        db2.delete("tablomasa2","id="+id,null);

    }


    public List<Masa2> Masa2Listele(){
        String[] Masa2Kolonlar={"id","Siparisler"};
        List<Masa2> Masa2Liste=new ArrayList<Masa2>();
        Cursor c=db2.query("tablomasa2",Masa2Kolonlar,null,null,null,null,null);
        c.moveToFirst();

        while (!c.isAfterLast()){
            int id=c.getInt(0);
            String Siparisler=c.getString(1);
            String eleman2=""+id+"-"+Siparisler;
            Masa2 k2=new Masa2(Siparisler,id);
            Masa2Liste.add(k2);
            c.moveToNext();

        }
        c.close();
        return Masa2Liste;
    }
}
