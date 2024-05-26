package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class Firstscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstscreen);

        // Delay for 3 seconds (3000 milliseconds) before navigating to MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Firstscreen.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close WelcomeActivity
            }
        }, 3000);
    }
}
