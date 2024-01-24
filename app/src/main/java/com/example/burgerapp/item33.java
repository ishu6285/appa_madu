package com.example.burgerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;

public class item33 extends AppCompatActivity {

    ImageButton back;
    Button cart;
    int total =0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item33);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) NumberPicker quantityPicker = findViewById(R.id.quantityPicker);
        cart = findViewById(R.id.cartbtn);

        quantityPicker.setMinValue(1);
        quantityPicker.setMaxValue(10);

        quantityPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
            total = newVal * 1390;
            cart.setText("Add to cart LKR "+total+".00");
        });
        back = findViewById(R.id.backbtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(item33.this,Home_Page.class);
                startActivity(intent);
            }
        });
    }
}