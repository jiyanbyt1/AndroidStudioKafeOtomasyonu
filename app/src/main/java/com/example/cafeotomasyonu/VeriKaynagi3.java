package com.example.cafeotomasyonu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class VeriKaynagi3 {
    SQLiteDatabase db3;
    Sqlite_Masa3 bdb3;

    public VeriKaynagi3(Context c){
        bdb3=new Sqlite_Masa3(c);
    }
    public void masa3ac(){
        db3=bdb3.getWritableDatabase();
    }
    public void masa3kapat(){
        bdb3.close();
    }

    public void Masa3SiparisOlustur(Masa3 k3){
        ContentValues val3=new ContentValues();
        val3.put("Siparisler",k3.getSiparisler());
        db3.insert("tablomasa3",null,val3);
    }

    public void Masa3SiparisSil(Masa3 k3){
        int id=k3.getId();
        db3.delete("tablomasa3",null,null);
        db3.close();
    }

    public void Masa3Silme(Masa3 k3){
        int id=k3.getId();
        db3.delete("tablomasa3","id="+id,null);
    }


    public List<Masa3> Masa3Listele(){
        String[] Masa3Kolonlar={"id","Siparisler"};
        List<Masa3> Masa3Liste=new ArrayList<Masa3>();
        Cursor c=db3.query("tablomasa3",Masa3Kolonlar,null,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            int id=c.getInt(0);
            String Siparisler=c.getString(1);
            String eleman3=""+id+"-"+Siparisler;
            Masa3 k3=new Masa3(Siparisler,id);
            Masa3Liste.add(k3);
            c.moveToNext();
        }
        c.close();
        return Masa3Liste;
    }

}
