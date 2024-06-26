package com.example.hivapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Full Body Checkup", "", "", "", "199"},
            {"Blood Sugar", "", "", "", "100"},
            {"Tuberculosis", "", "", "", "100"},
            {"Viral Load", "", "", "", "100"},
            {"Immunity Check", "", "", "", "500"}
    };

    private String[] packageDetails = {
            "Blood Glucose Testing\n" +
                    "Full Haemogram\n" +
                    "Urinalysis\n" +
                    "Pregnancy Test\n" +
                    "Kidney Test\n" +
                    "Lipid Profile\n" +
                    "Liver Test",
            "Blood Glucose Testing",
            "Tuberculosis full test\n" +
                    "Cough test",
            "High viral load check\n" +
                    "Low viral load check\n" +
                    "0 LDL",
            "Full Haemogram\n" +
                    "Kidney Test\n" +
                    "Liver Test\n" +
                    "Lipid Profile"
    };

    private ArrayList<HashMap<String, String>> list;
    private SimpleAdapter sa;
    Button btnGoToCart;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);


        listView = findViewById(R.id.listViewLT);



        list = new ArrayList<>();
        for (int i = 0; i < packages.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Cost: " + packages[i][4] + " Ksh");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packageDetails[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}