package com.example.burgerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.TextView;

public class getstarted extends AppCompatActivity {
    Button start;
    TextView countdownText;
    private CountDownTimer countDownTimer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);

        start = findViewById(R.id.btn11);
        countdownText = findViewById(R.id.count);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountdown();

            }

        });
    }

        private void startCountdown () {
            CountDownTimer CountDownTimer = new CountDownTimer(5000, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    countdownText.setText((""+millisUntilFinished / 1000));


                }

                @Override
                public void onFinish() {

                    countdownText.setText("Let's Go");
                    goToNextActivity();

                }
            }.start();
        }
        protected void goToNextActivity(){
            startActivity(new Intent(getstarted.this, MainActivity.class));
            finish();;

        }

         @Override
        protected void onDestroy() {


             super.onDestroy();
             if(countDownTimer!= null){
                 countDownTimer.cancel();
             }
         }
    }