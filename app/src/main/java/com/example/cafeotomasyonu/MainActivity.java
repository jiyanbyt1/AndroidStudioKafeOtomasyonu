package com.example.cafeotomasyonu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String YoneticiAdi="ahmet";
    String Sifre1= "123456";
    Button btngiris;
    Button btncikic;
    EditText etkullanici;
    EditText etSifre;
    String KullaniciAdi;
    String Sifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngiris=findViewById(R.id.btnGiris);
        btncikic=findViewById(R.id.btncikis);
        etkullanici=findViewById(R.id.etxtKullaniciAdi);
        etSifre=findViewById(R.id.etxtSifre);
        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KullaniciAdi=etkullanici.getText().toString();
                Sifre=etSifre.getText().toString();

                SQLite_Personel vt=new SQLite_Personel(MainActivity.this);
                List<String> str=vt.VeriListele();

                    if(KullaniciAdi.equals("jiyan") && Sifre.equals("123456")){
                        Toast.makeText(MainActivity.this, "Kullanıcı Giriş Başarılı", Toast.LENGTH_SHORT).show(); //DOĞRUYSA EKRANA TOAST MESAJ YAZDIRDIK
                        Intent gorev = new Intent(MainActivity.this,AnaSayfa.class); //VE BİR GÖREV VERDİK BU GÖREV MAİN ACTİVTYİ OYUN CLASSINI AÇMA
                        startActivity(gorev); //GÖREVİ BAŞLADIK
                        etkullanici.setText("");
                        etSifre.setText("");

                    }

                    else if(KullaniciAdi.equals("ahmet") && Sifre.equals("654321")){
                        Toast.makeText(MainActivity.this, "Personel Girişi Başarılı",Toast.LENGTH_SHORT).show();
                        Intent gorev2=new Intent(MainActivity.this,AnaSayfaPersonel.class);
                        startActivity(gorev2);
                        etkullanici.setText("");
                        etSifre.setText("");

                    }

                    else
                        Toast.makeText(MainActivity.this, "Hatalı Giriş", Toast.LENGTH_SHORT).show();

            }
        });
        btncikic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
