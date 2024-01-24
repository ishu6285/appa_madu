package com.example.burgerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;

import java.io.Serializable;

public class d1 extends AppCompatActivity {
    ImageButton back;
    ImageView cokee;
    Button cart;
    int total =0;

    double itemP =200.00;

    public int q;

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d1);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) NumberPicker quantityPicker = findViewById(R.id.quantityPicker);
        cart = findViewById(R.id.cartbtn);

        quantityPicker.setMinValue(1);
        quantityPicker.setMaxValue(10);

        quantityPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {

            q = newVal;
            total = newVal * 200;
            cart.setText("Add to cart LKR "+total+".00");
        });
        back = findViewById(R.id.backbtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(d1.this,drinks.class);
                startActivity(intent);
            }
        });

        // cokee =findViewById(R.id.coke);
        Drawable drawable =getResources().getDrawable(R.drawable.cocacola);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(d1.this, Cart.class);
                intent.putExtra("productName", "Coca-Cola");
                intent.putExtra("productQuantity",q);
                intent.putExtra("productPrice",itemP);
                intent.putExtra("productImageResId",bitmap);
                startActivity(intent);


            }
        });
    }
}