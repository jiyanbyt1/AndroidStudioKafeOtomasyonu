package com.example.cafeotomasyonu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

public class Masa_2 extends ListActivity {
    VeriKaynagi2 vk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa_2);
        vk=new VeriKaynagi2(this);
        vk.masa2ac();
        List<Masa2>SiparisListesi=vk.Masa2Listele();
        final ArrayAdapter<Masa2> adaptor= new ArrayAdapter<Masa2>(this, android.R.layout.simple_list_item_1, SiparisListesi);
        setListAdapter(adaptor);

        Button badd2=findViewById(R.id.btnKebap);
        badd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa2 k=new Masa2("kebap:10tl",1);
                vk.Masa2SiparisOlustur(k);
                adaptor.add(k);
            }
        });

        Button baddsulu2=findViewById(R.id.btnKuruFasulye);
        baddsulu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa2 k=new Masa2("Kuru Fasulye:15tl",1);
                vk.Masa2SiparisOlustur(k);
                adaptor.add(k);
            }
        });

        Button baddmakarna2=findViewById(R.id.btnMakarna);
        baddmakarna2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa2 k=new Masa2("Makarna:8tl",1);
                vk.Masa2SiparisOlustur(k);
                adaptor.add(k);
            }
        });

        Button Masakapat=findViewById(R.id.temizle2);
        Masakapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa2 k=(Masa2) getListAdapter().getItem(0);
                vk.Masa2SiparisSil(k);
                adaptor.remove(k);

                Intent i=new Intent(Masa_2.this,AdisyonIslemleri.class);
                startActivity(i);
                finish();
            }
        });

        Button sil2=findViewById(R.id.btnSil2);
        sil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa2 k=(Masa2) getListAdapter().getItem(0);
                vk.Masa2Silme(k);
                adaptor.remove(k);
            }
        });








    }
    protected void onResume(){
        vk.masa2ac();
        super.onResume();
    }
    protected void onPause(){
        vk.masa2kapat();
        super.onPause();
    }

    public void add_onClick(View view) {

    }
}
