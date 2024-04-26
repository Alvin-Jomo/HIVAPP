package com.example.hivapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {

    EditText editTextName, editTextEmail, editTextMessage;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from EditText fields
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String message = editTextMessage.getText().toString().trim();

                // Validate the input fields
                if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
                    Toast.makeText(HelpActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Send the details to your desired destination (e.g., send an email, save to database)
                    // For demonstration purposes, let's just display the captured details in a toast message
                    Toast.makeText(getApplicationContext(),
                            "Your details have been captured.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
