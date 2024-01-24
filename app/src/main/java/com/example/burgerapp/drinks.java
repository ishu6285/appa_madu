package com.example.burgerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class drinks extends AppCompatActivity {

    Button home,profile;
    ImageButton C,P,S,M;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        home= findViewById(R.id.homedrinks);
        profile = findViewById(R.id.profile);
        C =findViewById(R.id.coca);
        P =findViewById(R.id.pep);
        S= findViewById(R.id.sp);
        M =findViewById(R.id.md);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(drinks.this, menu.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(drinks.this,com.example.burgerapp.profile.class));
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(drinks.this, d1.class));
            }
        });

        P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(drinks.this, d2.class));
            }
        });


        S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(drinks.this, d3.class));
            }
        });

        M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(drinks.this, d4.class));
            }
        });


    }
}