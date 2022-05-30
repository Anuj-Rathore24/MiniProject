package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class DIsplayData extends AppCompatActivity {
    TextView name,email,contact,preferred,admission,mother,father,percentile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        Log.d("g","working");
        Intent intent=getIntent();

        selectData Object=(selectData) intent.getSerializableExtra("OurObject");
//        Log.d("OurObject",Object.Email);
        name=findViewById(R.id.textView8);
        name.setText(Object.Name);
//
        email=findViewById(R.id.textView9);
        email.setText(Object.Email);
//
        contact=findViewById(R.id.textView10);
        contact.setText(Integer.toString(Object.Contact));
//
        mother=findViewById(R.id.textView11);
        mother.setText(Object.MotherName);

        father=findViewById(R.id.textView12);
        father.setText(Object.FatherName);

        preferred=findViewById(R.id.textView13);
        preferred.setText(Object.PreferredBranch);
//
        admission=findViewById(R.id.textView14);
        admission.setText(Object.AdmissionMode);

        percentile=findViewById(R.id.textView15);
        percentile.setText(Integer.toString(Object.Percentile));



    }
}