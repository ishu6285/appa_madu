package com.example.burgerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;

public class iteam1 extends AppCompatActivity {

    ImageButton back;
    Button cart;
    int total =0;
    public double itemP = 1840.00;
    public int q;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iteam1);

        NumberPicker quantityPicker = findViewById(R.id.quantityPicker);
        cart = findViewById(R.id.cartbtn);

        quantityPicker.setMinValue(1);
        quantityPicker.setMaxValue(10);

        quantityPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
            q =newVal;
            total = newVal * 1840;
            cart.setText("Add to cart LKR "+total+".00");
        });
        back = findViewById(R.id.backbtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(iteam1.this,Home_page_meat.class);
                startActivity(intent);
            }
        });
        Drawable drawable =getResources().getDrawable(R.drawable.b1);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(iteam1.this, Cart.class);
                intent.putExtra("productName", "TREASURE ISLAND");
                intent.putExtra("productQuantity",q);
                intent.putExtra("productPrice",itemP);
                intent.putExtra("productImageResId",bitmap);
                startActivity(intent);
            }
        });





    }
}