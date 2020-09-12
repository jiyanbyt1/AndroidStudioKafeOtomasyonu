package com.example.cafeotomasyonu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdisyonIslemleri extends AppCompatActivity {
    Button Masa1giris;
    Button Masa2giris;
    Button Masa3giris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adisyon_islemleri);
        Masa1giris=findViewById(R.id.btnMasa1);
        Masa1giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdisyonIslemleri.this,Masa_1.class);
                startActivity(i);

                Masa1giris.setBackgroundResource(Color.green(2));
                            }
        });

        Masa2giris=findViewById(R.id.btnMasa2);
        Masa2giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdisyonIslemleri.this,Masa_2.class);
                startActivity(i);

                Masa2giris.setBackgroundResource(Color.green(2));
            }
        });

        Masa3giris=findViewById(R.id.MASA_3);
        Masa3giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdisyonIslemleri.this,Masa_3.class);
                startActivity(i);
                Masa3giris.setBackgroundResource(Color.green(2));
            }
        });

    }
}
