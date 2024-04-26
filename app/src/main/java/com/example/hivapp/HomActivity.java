package com.example.hivapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hom);

        Button btnViewAllPatients = findViewById(R.id.btnViewAllPatients);
        Button btnGenerateReport = findViewById(R.id.btnGenerateReport);
        Button btnViewGraphs = findViewById(R.id.btnViewGraphs);
        Button btnTrackEmergencies = findViewById(R.id.btnTrackEmergencies);
        Button btnManageLabTests = findViewById(R.id.btnManageLabTests);

        btnViewAllPatients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(HomActivity.this, ViewAllPatientsActivity.class));
            }
        });

        btnGenerateReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivity(new Intent(HomActivity.this, GenerateReportActivity.class));
            }
        });

        btnViewGraphs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(HomActivity.this, ViewGraphsActivity.class));
            }
        });

        btnTrackEmergencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivity(new Intent(HomActivity.this, TrackEmergenciesActivity.class));
            }
        });

        btnManageLabTests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(HomActivity.this, ManageLabTestsActivity.class));
            }
        });

        // Button to generate patient report
        Button btnGeneratePatientReport = findViewById(R.id.btnGeneratePatientReport);
        btnGeneratePatientReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomActivity.this, GenerateReportActivity.class);
                intent.putExtra("reportType", "Patient");
                startActivity(intent);
            }
        });

        // Button to generate disease report
        Button btnGenerateDiseaseReport = findViewById(R.id.btnGenerateDiseaseReport);
        btnGenerateDiseaseReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomActivity.this, GenerateReportActivity.class);
                intent.putExtra("reportType", "Disease");
                startActivity(intent);
            }
        });

        // Button to generate lab test report
        Button btnGenerateLabTestReport = findViewById(R.id.btnGenerateLabTestReport);
        btnGenerateLabTestReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomActivity.this, GenerateReportActivity.class);
                intent.putExtra("reportType", "LabTest");
                startActivity(intent);
            }
        });
    }
}
