package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class DIsplayData extends AppCompatActivity {
    TextView name,email,contact,input1,input2,input3,detailed,date,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        Intent intent=getIntent();

        selectData Object=(selectData) intent.getSerializableExtra("OurObject");
        name=findViewById(R.id.textView8);
        name.setText(Object.Name);

        email=findViewById(R.id.textView9);
        email.setText(Object.Email);

        contact=findViewById(R.id.textView10);
        contact.setText(Integer.toString(Object.prn));


        if(Objects.equals(Object.type, "CSE")){

            input1=findViewById(R.id.textView15);
            input1.setText(Object.input1);

            input2=findViewById(R.id.textView16);
            input2.setText(Object.input2);

            input3=findViewById(R.id.textView17);
            input3.setText(Object.input3);

            detailed=findViewById(R.id.textView18);
            detailed.setText(Object.additional);

        }
        else if(Objects.equals(Object.type, "Mech")){

            time=findViewById(R.id.textView20);
            time.setText(Object.time);

            date=findViewById(R.id.textView21);
            date.setText(Object.date);
        }

        else if(Objects.equals(Object.type, "ENTC")){
            detailed=findViewById(R.id.textView18);
            detailed.setText(Object.additional);
        }
    }
}