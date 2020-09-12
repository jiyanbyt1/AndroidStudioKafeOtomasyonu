package com.example.cafeotomasyonu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

import static android.app.PendingIntent.getActivity;

public class Masa_1 extends ListActivity {
    VeriKaynagi1 vk;
    Button temizle;



    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa_1);

        vk=new VeriKaynagi1(this);



        vk.ac();
        List<Masa1> SiparisListesi=vk.listele();
        final ArrayAdapter<Masa1> adaptor= new ArrayAdapter<Masa1>(this, android.R.layout.simple_list_item_1, SiparisListesi);
        setListAdapter(adaptor);




        Button badd=findViewById(R.id.btnaddkebap2);
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Masa1 k=new Masa1("kebap:10tl",1);
                vk.SiparisOlustur(k);
                adaptor.add(k);
            }
        });

        Button baddsulu=findViewById(R.id.btnaddsuluyemek2);
        baddsulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa1 k=new Masa1("Kuru Fasulye:15tl",1);
                vk.SiparisOlustur(k);
                adaptor.add(k);
            }
        });

        Button baddmakarna=findViewById(R.id.btnaddmakarna2);
        baddmakarna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa1 k=new Masa1("Makarna:8tl",1);
                vk.SiparisOlustur(k);
                adaptor.add(k);
            }
        });

        Button temizle=findViewById(R.id.temizle);
        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Masa1 k=(Masa1) getListAdapter().getItem(0);
                vk.SiparisSil(k);
                adaptor.remove(k);

                Intent i=new Intent(Masa_1.this,AdisyonIslemleri.class);
                startActivity(i);
                finish();


                //Button btn = findViewById(R.id.button1);
                //btn.setBackgroundResource(Color.green(1));
            }


        });

        Button sil=findViewById(R.id.btnSil);
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa1 k=(Masa1) getListAdapter().getItem(0);
                vk.Sil(k);
                adaptor.remove(k);

            }
        });








    }
    protected void onResume(){
        vk.ac();
        super.onResume();
    }
    protected void onPause(){
        vk.kapat();
        super.onPause();
    }


    public void add_onClick(View view) {
    }


    public void onClick(View view) {
    }
}
