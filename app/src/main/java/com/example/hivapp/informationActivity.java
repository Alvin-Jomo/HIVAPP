package com.example.hivapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class informationActivity extends AppCompatActivity {
Button buttonReadAboutHIV,buttonWatchClips,buttonSearchHere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

       buttonReadAboutHIV = findViewById(R.id.buttonReadAboutHIV);
        buttonWatchClips = findViewById(R.id.buttonWatchClips);
         buttonSearchHere = findViewById(R.id.buttonSearchHere);

        buttonReadAboutHIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to read about HIV page
                Intent intent = new Intent(informationActivity.this, ReadAboutHivActivity.class);
                startActivity(intent);
            }
        });

        buttonWatchClips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show some clips
                // You can implement this based on your specific requirements
            }
        });

        buttonSearchHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a small chatbot or any other search functionality
                // You can implement this based on your specific requirements
            }
        });
    }
}
