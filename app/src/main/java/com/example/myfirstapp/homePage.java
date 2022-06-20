package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.myfirstapp.ui.main.SectionsPagerAdapter;
import com.example.myfirstapp.databinding.ActivityHomePageBinding;

public class homePage extends AppCompatActivity{

    private ActivityHomePageBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        TabLayout.Tab tab = tabLayout.getTabAt(0);
//        tab.select();
//        int i=0;
//        tab.setText("Slide->"+i);
//        while(i<3){
//            tab = tabLayout.getTabAt(1);
//            tab.select();
//            tab.setText("slide ->"+i);
//            i++;
//        }

        ViewPager view=(ViewPager)findViewById(R.id.view_pager);
        view.removeAllViews();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}