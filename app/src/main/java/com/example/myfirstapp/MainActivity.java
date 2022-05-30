package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;


import android.app.ActionBar;
import android.content.Context;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Iterator;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button button;
    EditText firstname,lastname,age,email,panel;

    //setting up sqlite database
    DataBaseHelper dataBaseHelper=new DataBaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        Context context=getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //adding functionality to our submit button

                LinearLayout linearLayout =  (LinearLayout) findViewById(R.id.parentLayout);
                linearLayout.removeAllViews();
                Log.d("working","Hello There!");

                try{
                    //calling method in our databaseHelper class for insertion process
                    List<selectData> ourList;
                    ourList=dataBaseHelper.show_result("CSE");
                    Iterator<selectData> it=ourList.iterator();
                    int i=0;
                    while(it.hasNext()){
                        i++;
                        selectData row;
                        row=it.next();
                        LinearLayout container=new LinearLayout(MainActivity.this);

                        LinearLayout.LayoutParams dimentions=new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.MATCH_PARENT);
                        dimentions.setMargins(20,20,20,20);
                        container.setOrientation(LinearLayout.VERTICAL);

                        container.setLayoutParams(dimentions);
                        linearLayout.addView(container);

                        TextView textName=new TextView(MainActivity.this);
                        textName.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.RIGHT));

                        container.addView(textName);
                        textName.setText("Name :");
                        textName.setTextColor(Color.parseColor("#000000"));

                        TextView text=new TextView(MainActivity.this);
                        ConstraintSet set = new ConstraintSet();
                        container.addView(text);
                        text.setText(row.Name);
                        text.setTextColor(Color.parseColor("#000000"));


                        Button btn=new Button(MainActivity.this);
                        LinearLayout.LayoutParams btn_dimentions=new LinearLayout.LayoutParams(500, LinearLayout.LayoutParams.WRAP_CONTENT);
                        btn.setLayoutParams(btn_dimentions);
                        btn.setText("Click to View");
                        container.addView(btn);

                        btn.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                    Log.d("error_debug","\nworking\n");

                                Intent intent=new Intent(v.getContext(),DIsplayData.class);
                                intent.putExtra("OurObject",row);


                                startActivity(intent);


                            }

                        });

                    }
                    Log.d("debugging", "Status ->");

                    //toast is the black text box generally used in our apps
                    Toast.makeText(context, "Selected!", Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    System.out.println("The Error is ->"+e.toString());
                }

            }



    }










