package com.example.hivapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    // Setting objects
    EditText edEmail, edPassword;
    Button btn;
    TextView tv, Help;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.editTextviewNewuser);
        Help = findViewById(R.id.Help);
        fAuth = FirebaseAuth.getInstance();


        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we require an intend for user define activity
                Intent intent = new Intent(LoginActivity.this,HelpActivity.class);
                startActivity(intent);
            }
        });

        // When login button clicked
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    edEmail.setError("Email is Required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(),
                            "Password is required.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(),
                            "Password must be at least 6 characters long, contain an uppercase letter, a lowercase letter, and a special character.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login successful.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), homeActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        // Clicking the text view to go to register page
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we require an intend for user define activity
                Intent intent = new Intent(LoginActivity.this,registeActivity.class);
                startActivity(intent);
            }
        });


    }
}











