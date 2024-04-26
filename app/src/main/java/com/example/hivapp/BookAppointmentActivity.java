package com.example.hivapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private TextView dateButton, timeButton;
    Button btnBook;
    String title, fullname, address, contact, fees;
    DatabaseReference appointmentsRef;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv = findViewById(R.id.textViewAppTitle);
        ed1 = findViewById(R.id.editTextAppFullName);
        ed2 = findViewById(R.id.editTextAppAddress);
        ed3 = findViewById(R.id.editTextAppPhoneNumber);
        ed4 = findViewById(R.id.editTextAPPFees);
        dateButton = findViewById(R.id.buttonAppDate);
        timeButton = findViewById(R.id.buttonAppTime);
        btnBook = findViewById(R.id.buttonAPPBook);

        mAuth = FirebaseAuth.getInstance();
        appointmentsRef = FirebaseDatabase.getInstance().getReference("appointments");

        // Fetch data from the previous page using Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString("text1");
            fullname = extras.getString("text2");
            address = extras.getString("text3");
            contact = extras.getString("text4");
            fees = extras.getString("text5");

            // Display fetched data
            tv.setText(title);
            ed1.setText(fullname);
            ed2.setText(address);
            ed3.setText(contact);
            ed4.setText("Consultation Fee: " + fees + " Ksh");
        }

        // Datepicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                datePickerDialog.show();
            }
        });

        // Timepicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                timePickerDialog.show();
            }
        });

        // when book now is clicked we need to store some data in the database
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String selectedDate = dateButton.getText().toString();
                final String selectedTime = timeButton.getText().toString();
                final String selectedFullname = ed1.getText().toString();
                final String selectedAddress = ed2.getText().toString();
                final String selectedContact = ed3.getText().toString();
                final String userId = mAuth.getCurrentUser().getUid();

                Appointment appointment = new Appointment(title, selectedFullname, selectedAddress, selectedContact, selectedDate, selectedTime, Float.parseFloat(fees));
                String appointmentId = appointmentsRef.child(userId).push().getKey();
                appointmentsRef.child(userId).child(appointmentId).setValue(appointment);

                Toast.makeText(getApplicationContext(),"Your appointment is done successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(BookAppointmentActivity.this, homeActivity.class));
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton.setText(i2 +"/"+i1 +"/" + i);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        // Use a different AlertDialog theme
        int style = AlertDialog.THEME_DEVICE_DEFAULT_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i + ":" + i1);
            }
        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        // Use a different AlertDialog theme
        int style = AlertDialog.THEME_DEVICE_DEFAULT_LIGHT;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins, true);
    }
}
