package com.example.hivapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GenerateReportActivity extends AppCompatActivity {

    private TableLayout reportTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);

        reportTable = findViewById(R.id.reportTable);

        // Initialize total counts with dummy data for demonstration
        int totalPatients = 50;
        int totalBookings = 25;
        int totalOrders = 10;
        int totalEmergencies = 5;

        // Update the total counts in the table
        updateTableRow("Total Patients", String.valueOf(totalPatients));
        updateTableRow("Total Bookings", String.valueOf(totalBookings));
        updateTableRow("Total Orders", String.valueOf(totalOrders));
        updateTableRow("Total Emergencies", String.valueOf(totalEmergencies));
    }

    private void updateTableRow(String reportType, String total) {
        // Find the TableRow corresponding to the reportType
        TableRow row = findTableRow(reportType);
        if (row != null) {
            // Find the TextView for total count in the TableRow and update its text
            TextView totalTextView = row.findViewById(R.id.totalCount);
            if (totalTextView != null) {
                totalTextView.setText(total);
            }
        }
    }

    private TableRow findTableRow(String reportType) {
        // Iterate through all TableRows in the TableLayout and find the one with the matching reportType
        for (int i = 1; i < reportTable.getChildCount(); i++) { // Start from index 1 to skip the header row
            View child = reportTable.getChildAt(i);
            if (child instanceof TableRow) {
                TableRow row = (TableRow) child;
                TextView reportTypeTextView = row.findViewById(R.id.reportType);
                if (reportTypeTextView != null && reportTypeTextView.getText().toString().equals(reportType)) {
                    return row;
                }
            }
        }
        return null;
    }
}
