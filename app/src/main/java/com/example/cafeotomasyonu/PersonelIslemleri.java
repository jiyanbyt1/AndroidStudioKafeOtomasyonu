package com.example.cafeotomasyonu;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class PersonelIslemleri extends ListActivity {

    private EditText etAd,etSoyad,etTel,etSifre,etid;
    private Button btnKaydet, btnListele,btnSil,btnDuzenle;
    private ListView VeriListele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personel_islemleri);

        btnKaydet=findViewById(R.id.btnPersonelKaydet);
        btnSil=findViewById(R.id.btnPersonelSil);

        btnListele=findViewById(R.id.btnPersonelListele);

        etAd=findViewById(R.id.etxtPersonelAdi);
        etSoyad=findViewById(R.id.etxtPersonelSoyadi);
        etTel=findViewById(R.id.etxtPersonelTel);
        etSifre=findViewById(R.id.etxtPersonelSifre);


        etid=findViewById(R.id.etxtid);



            //BURAYA KADAR VERİLEN MALZEMELERİ TANIMLADIK. İŞLEMLER BURADAN SONRA YAPILMAKTADIR.

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gelenAd=etAd.getText().toString();
                String gelenSoyad=etSoyad.getText().toString();
                String gelenTel=etTel.getText().toString();
                String gelenSifre=etSifre.getText().toString();
                SQLite_Personel vt = new SQLite_Personel(PersonelIslemleri.this);
                vt.VeriEkle(gelenAd,gelenSoyad,gelenTel,gelenSifre);
                Listele();
                etAd.setText("");
                etSoyad.setText("");
                etSifre.setText("");
                etTel.setText("");
            }
        });


        btnListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Listele();

            }
        });

        // Birden fazla yerde kullanmak için bir metot tanımlıyoruz



        btnSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // VeriTabanı classımızı tanımlıyoruz
                SQLite_Personel vt = new SQLite_Personel(PersonelIslemleri.this);
                String str=etid.getText().toString();
                vt.VeriSil(str);
                //Sildikten Sonra tekrardan listeliyoruz
                Listele();
            }
        });



    }

    public void Pekle_onClick(View view) {
    }

    public void Psil_onClick(View view) {
    }

    public void Listele(){

        SQLite_Personel vt = new SQLite_Personel(PersonelIslemleri.this);
        List<String> list = vt.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(PersonelIslemleri.this, android.R.layout.simple_list_item_1,android.R.id.text1,list);
        setListAdapter(adapter);

    }

    public void onClick(View view) {
    }
}