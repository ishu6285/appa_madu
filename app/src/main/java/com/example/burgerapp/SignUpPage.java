package com.example.burgerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpPage extends AppCompatActivity {

    Button Login,Signup;
    EditText editTextName,editTextEmail,editTextMobile,editTextPassword,editTextAddress;

     DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        Login = findViewById(R.id.login);
        Signup =findViewById(R.id.btnSignUp);

        final EditText fullname =findViewById(R.id.editTextName);
        final EditText email =findViewById(R.id.editTextEmail);
        final EditText phone =findViewById(R.id.editTextMobile);
        final EditText password =findViewById(R.id.editTextPassword);
        final EditText address =findViewById(R.id.editTextAddress);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String fullnameTxt = fullname.getText().toString();
                final String emailTxt = email.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();
                final String addressTxt = address.getText().toString();

                //check if user fill all fields

                if(fullnameTxt.isEmpty()|| emailTxt.isEmpty() || phoneTxt.isEmpty() || passwordTxt.isEmpty() || addressTxt.isEmpty()){
                    Toast.makeText(SignUpPage.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                }
                else{

                     databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull DataSnapshot snapshot) {
                             if(snapshot.hasChild(phoneTxt)){
                                 Toast.makeText(SignUpPage.this,"Your Phone number is already registered",Toast.LENGTH_SHORT).show();

                             }

                             else{
                                 //data to firebase
                                 //unique id is phone number
                                 databaseReference.child("users").child(phoneTxt).child("fullname").setValue(fullnameTxt);
                                 databaseReference.child("users").child(phoneTxt).child("email").setValue(emailTxt);
                                 databaseReference.child("users").child(phoneTxt).child("phone").setValue(phoneTxt);
                                 databaseReference.child("users").child(phoneTxt).child("password").setValue(passwordTxt);
                                 databaseReference.child("users").child(phoneTxt).child("address").setValue(addressTxt);
                                 Toast.makeText(SignUpPage.this,"User registered successfully",Toast.LENGTH_SHORT).show();
                                 finish();

                             }

                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError error) {


                         }
                     });


                }


            }
        });


         Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();

            }
        });
    }
}