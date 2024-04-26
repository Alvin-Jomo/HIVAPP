package com.example.hivapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LabTestDetailsActivity extends AppCompatActivity {

    private TextView tvPackageName;
    private TextView tvTotalCost;
    private EditText edDetails;
    private Button btnCart;

    // Firebase variables
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Initialize Firebase Realtime Database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Initialize views
        tvPackageName = findViewById(R.id.textViewLTName);
        tvTotalCost = findViewById(R.id.textViewTotalCost);
        edDetails = findViewById(R.id.listViewLT);
        btnCart = findViewById(R.id.buttonLDAddToCart);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost : " + intent.getStringExtra("text3") + "/-");

        // Set onClickListener for the cart button
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser == null) {
                    // User not logged in, redirect to login activity
                    startActivity(new Intent(LabTestDetailsActivity.this, LoginActivity.class));
                    return;
                }

                String username = currentUser.getUid();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3"));

                // Add to Firebase Realtime Database
                DatabaseReference cartRef = mDatabase.child("users").child(username).child("cart").push();
                cartRef.child("product").setValue(product);
                cartRef.child("price").setValue(price);
                cartRef.child("type").setValue("lab");

                Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });
    }
}
