package com.example.burgerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Cart extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cart);

            Intent intent = getIntent();
            String productName = intent.getStringExtra("productName");
            int productQuantity = intent.getIntExtra("productQuantity", 0);
            double productPrice = intent.getDoubleExtra("productPrice", 0.002);
          //  int productImageResId = intent.getIntExtra("productImageResId", 0);
            Bitmap reciveimg = getIntent().getParcelableExtra("productImageResId");


            TextView productNameTextView = findViewById(R.id.cartProductNameTextView);
            TextView quantityTextView = findViewById(R.id.cartQuantityTextView);
            TextView priceTextView = findViewById(R.id.cartPriceTextView);
            ImageView productImageView = findViewById(R.id.cartProductImageView);

            productNameTextView.setText("Product Name: " + productName);
            quantityTextView.setText("Quantity: " + String.valueOf(productQuantity));
             productImageView.setImageBitmap(reciveimg);

            // total
            double totalPrice = productPrice * productQuantity;
            priceTextView.setText("Total Price: Rs. " + String.valueOf(totalPrice));


        }


}
