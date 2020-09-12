package com.example.cafeotomasyonu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

public class Masa_3 extends ListActivity {
    VeriKaynagi3 vk3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa_3);
        vk3=new VeriKaynagi3(this);
        vk3.masa3ac();
        List<Masa3>SiparisListesi=vk3.Masa3Listele();
        final ArrayAdapter<Masa3> adaptor= new ArrayAdapter<Masa3>(this, android.R.layout.simple_list_item_1, SiparisListesi);
        setListAdapter(adaptor);




        Button badd3=findViewById(R.id.btnkebap3);
        badd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa3 k=new Masa3("kebap:10tl",1);
                vk3.Masa3SiparisOlustur(k);
                adaptor.add(k);
            }
        });

        Button baddsulu3=findViewById(R.id.btnKuruFasulye3);
        baddsulu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa3 k=new Masa3("Kuru Fasulye:15tl",1);
                vk3.Masa3SiparisOlustur(k);
                adaptor.add(k);

            }
        });


        Button baddmakarna3=findViewById(R.id.btnMakarna3);
        baddmakarna3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa3 k=new Masa3("Makarna:8tl",1);
                vk3.Masa3SiparisOlustur(k);
                adaptor.add(k);
            }
        });


        Button MasaKapat3=findViewById(R.id.temizle3);
        MasaKapat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa3 k=(Masa3) getListAdapter().getItem(0);
                vk3.Masa3SiparisSil(k);
                adaptor.remove(k);

                Intent i=new Intent(Masa_3.this,AdisyonIslemleri.class);
                startActivity(i);
                finish();

            }
        });

        Button btnsil3=findViewById(R.id.btnSil3);
        btnsil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Masa3 k=(Masa3) getListAdapter().getItem(0);
                vk3.Masa3Silme(k);
                adaptor.remove(k);
            }
        });
    }





    protected void onResume(){
        vk3.masa3ac();
        super.onResume();
    }
    protected void onPause(){
        vk3.masa3ac();
        super.onPause();
    }
}
