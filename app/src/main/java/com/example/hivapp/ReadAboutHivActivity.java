package com.example.hivapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReadAboutHivActivity extends AppCompatActivity {
TextView bookTitle1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_about_hiv);

        bookTitle1 = findViewById(R.id.book1);

        bookTitle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/search?q=Hiv+aids+reading+articles&oq=h&gs_lcrp=EgZjaHJvbWUqBggBEEUYOzIGCAAQRRg8MgYIARBFGDsyBggCEEUYOzIGCAMQRRg7MgYIBBBFGDkyBggFEEUYPDIGCAYQRRg8MgYIBxBFGDzSAQgyMzI4ajBqN6gCALACAA&sourceid=chrome&ie=UTF-8";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
