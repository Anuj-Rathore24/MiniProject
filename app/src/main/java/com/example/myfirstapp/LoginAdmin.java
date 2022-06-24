package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAdmin extends AppCompatActivity {
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin_login2);

        Button btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=(EditText)findViewById(R.id.editTextTextPersonName);
                password=(EditText)findViewById(R.id.editTextTextPersonName3);
                if(username.getText().toString().equals("Admin") && password.getText().toString().equals("123")){
                    Intent intent=new Intent(LoginAdmin.this,adminHomePage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginAdmin.this,"Incorrect Username or Password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}