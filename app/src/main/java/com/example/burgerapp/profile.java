package com.example.burgerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class profile extends AppCompatActivity {
    Button back,out;


    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
    DatabaseReference profilesRef = databaseReference.child("users").child(MainActivity.No);


    TextView setname,setaddress,setemail,setmobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        setname =findViewById(R.id.settextname);
        setaddress =findViewById(R.id.settextaddress);
        setemail = findViewById(R.id.settextemail);
        setmobile =findViewById(R.id.settexphonenumber);


        profilesRef.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){
                    Toast.makeText(profile.this, "Profile", Toast.LENGTH_SHORT).show();
                    String name = snapshot.child("fullname").getValue(String.class);
                    //
                    String address = snapshot.child("address").getValue(String.class);
                    String email = snapshot.child("email").getValue(String.class);
                    String mobileNumber = snapshot.child("phone").getValue(String.class);
                    //
                    Log.e("sss",name);
                    setname.setText(name);
                    //
                    setaddress.setText(address);
                    setemail.setText(email);
                    setmobile.setText(mobileNumber);
                    //

                }else{
                    Toast.makeText(profile.this, " wrong Profile", Toast.LENGTH_SHORT).show();
                }

             /*   for (DataSnapshot profileSnapshot : snapshot.getChildren()) {
                    // Retrieve data
                    String name = profileSnapshot.child("fullname").getValue(String.class);
                    String address = profileSnapshot.child("address").getValue(String.class);
                    String email = profileSnapshot.child("email").getValue(String.class);
                    String mobileNumber = profileSnapshot.child("phone").getValue(String.class);

                    // Do something with the data


                        //setname.setText(name);
                        //setaddress.setText(address);
                        //setemail.setText(email);
                        //setmobile.setText(mobileNumber);

                }*/
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        back = findViewById(R.id.backbtn);
        out =findViewById(R.id.signout);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, menu.class);
                startActivity(intent);
            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profile.this, getstarted.class));
            }
        });


    }
}