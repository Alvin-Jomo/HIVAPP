package com.example.hivapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import android.widget.AdapterView;

import com.example.hivapp.BookAppointmentActivity;

public class DoctorDetailsActivity extends AppCompatActivity {
    // Arrays holding details of different doctors
    private String[][] doctor_details1 = {
            {"Doctor: Hanningtone Otieno", "Hospital: Kakamega General", "Exp: 5yrs", "Mobile No: 0707265023", "600"},
            {"Doctor: Belinda Belyn", "Hospital: Mukumu", "Exp: 15yrs", "Mobile No: 0707265024", "7500"},
            {"Doctor: Hamun Hermoon", "Hospital: Kisumu general", "Exp: 20yrs", "Mobile No: 0709269023", "10500"},
            {"Doctor: Chebet Mercy", "Hospital: Mmust Clinic", "Exp: 8yrs", "Mobile No: 0707265828", "790"},
            {"Doctor: Allan Siva", "Hospital: Mukumu", "Exp: 2yrs", "Mobile No: 0707265023", "400"},
            {"Doctor: Rentina Inzilia", "Hospital: Nairobi Hospital", "Exp: 57yrs", "Mobile No: 075565023", "70000"},
            {"Doctor: Betty Baetrice", "Hospital: Medheal", "Exp: 5yrs", "Mobile No: 070065023", "3200"}
    };
    private String[][] doctor_details2 = {
            {"Doctor: Brain Jomo", "Hospital: Kakamega General", "Exp: 5yrs", "Mobile No: 0707265023", "9000"},
            {"Doctor: Belinda Belyn", "Hospital: Mukumu", "Exp: 15yrs", "Mobile No: 0707265024", "7500"},
            {"Doctor: Haron Hern", "Hospital: Kisumu general", "Exp: 20yrs", "Mobile No: 0709269023", "1050"},
            {"Doctor: bii Mecy", "Hospital: Mmust Clinic", "Exp: 8yrs", "Mobile No: 0707265828", "790"},
            {"Doctor: Allan Simiyu", "Hospital: Mukumu", "Exp: 2yrs", "Mobile No: 0707265023", "4000"},
            {"Doctor: Brenda Wafula", "Hospital: Nairobi Hospital", "Exp: 57yrs", "Mobile No: 075565023", "700"}
    };
    private String[][] doctor_details3 = {
            {"Doctor: Anan Anyango", "Hospital:Bondo  General", "Exp: 10yrs", "Mobile No: 0765437654", "9850"},
            {"Doctor: Helen Nekesa", "Hospital: Siaya", "Exp: 12yrs", "Mobile No: 0777876546", "8800"},
            {"Doctor: Eugene Isigi", "Hospital: Nairobi general", "Exp: 10yrs", "Mobile No: 0798098789", "1500"},
            {"Doctor: Caleb Mukonyi", "Hospital: Lugari Clinic", "Exp: 22yrs", "Mobile No: 0722134343", "5400"},
            {"Doctor: Elvis Harun", "Hospital:Webuye", "Exp: 14yrs", "Mobile No: 0776576889", "4000"},
            {"Doctor:Timothy Wekesa", "Hospital: Kisumu Hospital", "Exp: 24yrs", "Mobile No: 0776098908", "3400"}
    };
    private String[][] doctor_details4 = {
            {"Doctor: Enock Makori", "Hospital: Kisumu General", "Exp: 10yrs", "Mobile No: 0787656787", "4500"},
            {"Doctor: Benjamin Karani", "Hospital: Lugari", "Exp: 12yrs", "Mobile No: 0700989098", "6000"},
            {"Doctor: Patrick Madak", "Hospital: Nairobi general", "Exp: 26yrs", "Mobile No: 0734326756", "9000"},
            {"Doctor: Charles Masanda", "Hospital: Lugari Clinic", "Exp: 19yrs", "Mobile No: 0787690987", "5600"},
            {"Doctor: Tobet Chimwani", "Hospital: Lugari", "Exp: 10yrs", "Mobile No: 0721234541", "4500"},
            {"Doctor: Ramadhan Mwaniki", "Hospital: Siaya Hospital", "Exp: 22yrs", "Mobile No: 0765467654", "8200"}
    };
    private String[][] doctor_details5 = {
            {"Doctor: Seth Oriama", "Hospital : Nairobi General", "Exp: 12yrs", "Mobile No: 0776890987", "4000"},
            {"Doctor: Alvin Wanjala", "Hospital: Lubao", "Exp: 18yrs", "Mobile No: 0767598098", "6500"},
            {"Doctor: Rphael Muroyi", "Hospital:  general", "Exp: 15yrs", "Mobile No: 0798765432", "5800"},
            {"Doctor: Wasike Daniel", "Hospital: Lurambi Clinic", "Exp: 22yrs", "Mobile No: 0756786571", "9000"},
            {"Doctor: Diana Ashley ", "Hospital: Mukumu", "Exp: 12yrs", "Mobile No: 0709098790", "4300"},
            {"Doctor: Wanjiru Teresiah", "Hospital: Muranga Hospital", "Exp: 17yrs", "Mobile No: 0745678231", "6000"}
    };
    private String[][] doctor_details6 = {
            {"Doctor: David Lutomia", "Hospital: Siaya General", "Exp: 15yrs", "Mobile No: 0743536373", "5600"},
            {"Doctor: Marial Harun", "Hospital: Kabianga", "Exp: 25yrs", "Mobile No: 0737383930", "9500"},
            {"Doctor: Phidelis Ometi", "Hospital: Nairobi general", "Exp: 22yrs", "Mobile No: 0713141712", "9000"},
            {"Doctor: Peter Meshack", "Hospital:Lurambi Clinic", "Exp: 10yrs", "Mobile No: 07565755455", "4000"},
            {"Doctor: Fredinarnd Baraka", "Hospital: Kabianga", "Exp: 17yrs", "Mobile No: 07676754343", "7500"},
            {"Doctor: Florence Muthoni", "Hospital: Kisumu Hospital", "Exp: 33yrs", "Mobile No: 0734345643", "22000"}
    };

    TextView tv;

    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);


        Intent it = getIntent();
        String title = it.getStringExtra("title");

        if (title != null && !title.isEmpty()) {
            tv.setText(title);

            switch (title) {
                case "FAMILY DOCTOR":
                    doctor_details = doctor_details1;
                    break;
                case "DIETICIAN":
                    doctor_details = doctor_details2;
                    break;
                case "CANCER DOCTORS":
                    doctor_details = doctor_details3;
                    break;
                case "SURGEON":
                    doctor_details = doctor_details4;
                    break;
                case "TUBERCLOSIS":
                    doctor_details = doctor_details5;
                    break;
                default:
                    doctor_details = doctor_details6;
                    break;
            }
        } else {
            tv.setText("Title not provided");
        }


        list = new ArrayList<>();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Total Cost :" + doctor_details[i][4] + "Ksh");
            list.add(item);
        }


        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);

                // Fetching data from doctor_details array
                String doctorName = doctor_details[i][0];
                String hospitalAddress = doctor_details[i][1];
                String phoneNumber = doctor_details[i][3];
                String fees = doctor_details[i][4];

                // Putting data into intent
                intent.putExtra("text1", title);
                intent.putExtra("text2", doctorName);
                intent.putExtra("text3", hospitalAddress);
                intent.putExtra("text4", phoneNumber);
                intent.putExtra("text5", fees);

                startActivity(intent);
            }
        });


    }
}