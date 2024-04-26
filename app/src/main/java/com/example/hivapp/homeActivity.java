package com.example.hivapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class homeActivity extends AppCompatActivity {
    LinearLayout laboratory, pharmacy, doctor, health, track, emergency, order;
    Button logout;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        Toast.makeText(getApplicationContext(), "Welcome " + username, Toast.LENGTH_SHORT).show();

        laboratory = findViewById(R.id.cardLabTest);
       // pharmacy = findViewById(R.id.cardBuyMedicine);
        doctor = findViewById(R.id.cardFindDoctor);
        health = findViewById(R.id.cardHealthArticles);
        track = findViewById(R.id.cardPatientTracker);
        emergency = findViewById(R.id.cardEmergencies);
       // order = findViewById(R.id.cardOrderDetails);
        logout = findViewById(R.id.logout);

        fAuth= FirebaseAuth.getInstance();


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });


        laboratory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this, LabTestActivity.class));
                Toast.makeText(homeActivity.this, "LAB TEST clicked", Toast.LENGTH_SHORT).show();
            }
        });

//        pharmacy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle buy medicine click
//                startActivity(new Intent(homeActivity.this, BuyMedicineActivity.class));
//                Toast.makeText(homeActivity.this, "BUY MEDICINE clicked", Toast.LENGTH_SHORT).show();
//                // Open virtual chemist
//            }
//        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this, FindDoctorActivity.class));
                Toast.makeText(homeActivity.this, "FIND DOCTOR clicked", Toast.LENGTH_SHORT).show();
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this, informationActivity.class));
                // Handle health article click
                Toast.makeText(homeActivity.this, "HEALTH INFORMATION clicked", Toast.LENGTH_SHORT).show();
                // Show health articles/videos
            }
        });

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle patient tracker click
                startActivity(new Intent(homeActivity.this, TrackActivity.class));
                Toast.makeText(homeActivity.this, "PATIENT TRACKER clicked", Toast.LENGTH_SHORT).show();
                // Track patient activities
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle emergencies click
                startActivity(new Intent(homeActivity.this,emergencyActivity.class));
                Toast.makeText(homeActivity.this, "EMERGENCIES clicked", Toast.LENGTH_SHORT).show();
                // Show emergency contacts
            }
        });

//        order.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle order details click
//                startActivity(new Intent(homeActivity.this, OrderDetailsActivity.class));
//                Toast.makeText(homeActivity.this, "ORDER DETAILS clicked", Toast.LENGTH_SHORT).show();
//                // Show order details
//            }
//        });
    }
}