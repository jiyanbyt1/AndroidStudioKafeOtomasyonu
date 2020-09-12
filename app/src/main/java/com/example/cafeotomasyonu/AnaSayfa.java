package com.example.cafeotomasyonu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnaSayfa<SecondActivity> extends AppCompatActivity {
    Button btnadisyon;
    Button PersonelIslemleri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);
        final EditText et1=findViewById(R.id.etxtKullaniciAdi);
        final EditText et2=findViewById(R.id.etxtSifre);
        btnadisyon=findViewById(R.id.btnAdisyonislemleri);
        btnadisyon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AnaSayfa.this,AdisyonIslemleri.class);
                startActivity(i);
            }
        });

        PersonelIslemleri=findViewById(R.id.btnPersonelIslemleriYonetici);
        PersonelIslemleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AnaSayfa.this,PersonelIslemleri.class);
                startActivity(i);
            }
        });
    }





    @Override
    public void onBackPressed() {

        backButtonHandler();
        return;
    }
    public void backButtonHandler() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                AnaSayfa.this);
        alertDialog.setTitle("ÇIKIŞ YAP?");
        alertDialog.setMessage("Bu Hesaptan Çıkmak İstediğinizden Emin Misiniz?");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setPositiveButton("EVET",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                });
        alertDialog.setNegativeButton("HAYIR",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }
}
