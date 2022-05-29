package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private Button add_button,delete_button,update_button,view_button;
    EditText firstname,lastname,age,email,panel;

    //setting up sqlite database
    DataBaseHelper dataBaseHelper=new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        Context context=getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_button=findViewById(R.id.add_button);
        view_button=findViewById(R.id.view_button);
        delete_button=findViewById(R.id.delete_button);
        update_button=findViewById(R.id.update_button);




        //adding functionality to our submit button
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("debugging", "working1 ");
                firstname=findViewById(R.id.firstname_textbox);
                lastname=findViewById(R.id.lastname_textbox);
                age=findViewById(R.id.age_textbox);
                email=findViewById(R.id.Email_textbox);
                panel=findViewById(R.id.panel_textbox);


                try{
                    //calling method in our databaseHelper class for insertion process

                    boolean status=dataBaseHelper.insert_values(firstname.getText().toString(),lastname.getText().toString(),age.getText().toString(),email.getText().toString(),panel.getText().toString());
                    Log.d("debugging", "Status ->"+status);

                    //toast is the black text box generally used in our apps
                    Toast.makeText(context, "New Record Added", Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    System.out.println("The Error is ->"+e.toString());
                }

            }
        });

        //Listener for View button
        view_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView database_contents=findViewById(R.id.database_info);

                try{
                   String result = dataBaseHelper.show_result();
                    Log.i("Operations  ->", "Show result Status->"+result);
                    database_contents.setText(result);

                }catch(Exception e){
                    System.out.println("The Error is ->"+e.toString());
                }

            }
        });

        //listener for Delete button
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=findViewById(R.id.Email_textbox);
                try{
                    boolean status = dataBaseHelper.delete_records(email.getText().toString());
                    if(status==false){
                        Toast.makeText(context, "Record Not Found", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context, "Record Deleted", Toast.LENGTH_SHORT).show();
                    }
                    Log.i("Operations", "Delete operation ->"+status);

                }catch(Exception e){
                    System.out.println("The Error is ->"+e.toString());
                }

            }
        });


        //listener for update button
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname=findViewById(R.id.firstname_textbox);
                lastname=findViewById(R.id.lastname_textbox);
                age=findViewById(R.id.age_textbox);
                email=findViewById(R.id.Email_textbox);
                panel=findViewById(R.id.panel_textbox);


                try{
                    boolean status = dataBaseHelper.update_records(firstname.getText().toString(),lastname.getText().toString(),age.getText().toString(),email.getText().toString(),panel.getText().toString());
                    if(status==false){
                        Toast.makeText(context, "Record Not Found or Something went wrong", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context, "Record Updated", Toast.LENGTH_SHORT).show();
                    }
                    Log.i("Operations", "Update operation ->"+status);

                }catch(Exception e){
                    System.out.println("The Error is ->"+e.toString());
                }

            }
        });


    }


}









