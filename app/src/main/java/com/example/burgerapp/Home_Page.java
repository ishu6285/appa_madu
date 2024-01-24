package com.example.burgerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home_Page extends AppCompatActivity {
    Button home,profile;
    ImageButton burger1,burger2,burger3,burger4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        home =findViewById(R.id.home);
        profile =findViewById(R.id.profile);
        burger1 = findViewById(R.id.burger11);
        burger2 = findViewById(R.id.burger22);
        burger3 =findViewById(R.id.burger33);
        burger4 =findViewById(R.id.burger44);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Page.this, menu.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this,com.example.burgerapp.profile.class));
            }
        });

        burger1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this, item11.class));
            }
        });

        burger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this, item22.class));
            }
        });

        burger3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this, item33.class));
            }
        });

        burger4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Page.this, item44.class));
            }
        });



    }
}