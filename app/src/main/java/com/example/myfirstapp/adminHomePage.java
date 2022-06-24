package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.myfirstapp.ui.main.SectionsPagerAdapterAdmin;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.myfirstapp.ui.main.SectionsPagerAdapter;
import com.example.myfirstapp.databinding.ActivityAdminHomePageBinding;

public class adminHomePage extends AppCompatActivity {

    private ActivityAdminHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdminHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapterAdmin sectionsPagerAdapterAdmin = new SectionsPagerAdapterAdmin(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapterAdmin);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(adminHomePage.this,HomePage.class);
                startActivity(intent);
            }
        });
    }
}