package com.example.burgerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home_page_meat extends AppCompatActivity {

    Button home,profile;
    ImageButton burger1,burger2,burger3,burger4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_meat);

        home= findViewById(R.id.homemeat);
        burger1 = findViewById(R.id.BBQPISTON);
        burger2 = findViewById(R.id.crispy1_0);
        burger3 =findViewById(R.id.burger3);
        burger4 = findViewById(R.id.burger4);
        profile = findViewById(R.id.profile);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_page_meat.this, menu.class);
                startActivity(intent);
            }
        });

        burger1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_page_meat.this, iteam1.class);
                startActivity(intent);
            }
        });

        burger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_page_meat.this, item2.class);
                startActivity(intent);
            }
        });

        burger3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_page_meat.this, item3.class);
                startActivity(intent);
            }
        });

        burger4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home_page_meat.this, item4.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_page_meat.this,com.example.burgerapp.profile.class));
            }
        });
    }
}