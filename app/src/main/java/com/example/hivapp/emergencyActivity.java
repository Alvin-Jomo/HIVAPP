package com.example.hivapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class emergencyActivity extends AppCompatActivity {
CardView cardCalls, cardMessages, cardAmbulance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        // Find views
        cardCalls = findViewById(R.id.card_calls);
        cardMessages = findViewById(R.id.card_messages);
        cardAmbulance = findViewById(R.id.card_ambulance);

        // Set onClick listeners
        cardCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call default number
                String defaultNumber = "0711111111";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + defaultNumber));
                startActivity(intent);
            }
        });

        cardMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send message to default number
                String defaultNumber = "0700000000";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", defaultNumber, null));
                startActivity(intent);
            }
        });

        cardAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call ambulance
                String ambulanceNumber = "1111";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + ambulanceNumber));
                startActivity(intent);
            }
        });
    }
}
