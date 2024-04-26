package com.example.hivapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FindDoctorActivity extends AppCompatActivity {
    LinearLayout cardExit, familydoctor, dietician, cancer, surgeon, cardiologist, tb;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Initialize Firebase Realtime Database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        cardExit = findViewById(R.id.cardFDBack);
        familydoctor = findViewById(R.id.cardFDFamilyPhysician);
        dietician = findViewById(R.id.cardFDDietician);
        cancer = findViewById(R.id.cardFDCancer);
        surgeon = findViewById(R.id.cardFDsurgeon);
        cardiologist = findViewById(R.id.cardFDFamilyCardiologist);
        tb = findViewById(R.id.cardFDTB);

        familydoctor.setOnClickListener(view -> startDoctorDetailsActivity("FAMILY DOCTOR"));
        dietician.setOnClickListener(view -> startDoctorDetailsActivity("DIETICIAN"));
        tb.setOnClickListener(view -> startDoctorDetailsActivity("TUBERCULOSIS"));
        cardiologist.setOnClickListener(view -> startDoctorDetailsActivity("CARDIOLOGIST"));
        surgeon.setOnClickListener(view -> startDoctorDetailsActivity("SURGEON"));
        cancer.setOnClickListener(view -> startDoctorDetailsActivity("CANCER DOCTORS"));

        cardExit.setOnClickListener(v -> showLogoutDialog());
    }

    private void startDoctorDetailsActivity(String title) {
        Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
        intent.putExtra("title", title);
        startActivity(intent);
    }

    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to go back?");
        builder.setPositiveButton("Yes", (dialog, which) -> startActivity(new Intent(FindDoctorActivity.this, homeActivity.class)));
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}
