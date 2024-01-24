package com.example.burgerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.function.Function;

public class MainActivity extends AppCompatActivity {




    Button Register;
    Button Log;
    EditText username,password;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

    public static String No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Register = findViewById(R.id.register);
        Log =findViewById(R.id.login);
        username=findViewById(R.id.username);
        password= findViewById(R.id.password);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUpPage.class);
                startActivity(intent);
            }
        });

            Log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String phoneTxt = username.getText().toString();
                    final String passwordTxt = password.getText().toString();

                    No = phoneTxt;


                    if(phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                        Toast.makeText(MainActivity.this, "Please enter your phone number or password",Toast.LENGTH_SHORT).show();
                    }

                    else{

                        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                // check mobile phone number in database

                                if(snapshot.hasChild(phoneTxt)){
                                    final String getPassword = snapshot.child(phoneTxt).child("password").getValue(String.class);

                                    if(getPassword.equals(passwordTxt)){
                                        //directValue = phoneTxt;
                                        Toast.makeText(MainActivity.this,"Successfully Logged in",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(MainActivity.this, menu.class));
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(MainActivity.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else{
                                    Toast.makeText(MainActivity.this,"Wrong Mobile Number",Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }

                }

            });



    }}

