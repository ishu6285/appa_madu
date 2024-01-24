package com.example.burgerapp;

import static com.example.burgerapp.R.id.chicken;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class menu extends AppCompatActivity {

    ImageButton chi,veg,dr;
    Button profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        chi = this.<ImageButton>findViewById(chicken);
        veg = this.<ImageButton>findViewById(R.id.vegetable);
        dr  = this.<ImageButton>findViewById(R.id.drinks);
        profile =findViewById(R.id.profile);


        chi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this,Home_page_meat.class);
                startActivity(intent);
            }
        });

        veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, Home_Page.class);
                startActivity(intent);
            }
        });

        dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, drinks.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this,com.example.burgerapp.profile.class));
            }
        });


    }
}