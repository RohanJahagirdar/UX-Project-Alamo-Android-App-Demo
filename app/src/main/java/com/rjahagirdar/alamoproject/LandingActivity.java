package com.rjahagirdar.alamoproject;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;

public class LandingActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    SharedPreferences prefs;
    CustomPagerAdapter mCustomPagerAdapter;
    Button createOrHistoryButton;
    DatePickerDialog datePickerDialogFrom;
    DatePickerDialog datePickerDialogTo;
    Button searchButton;
    Spinner locationSpinner;
    Spinner categorySpinner;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        locationSpinner = findViewById(R.id.location_spinner);
        categorySpinner = findViewById(R.id.category_spinner);

        datePickerDialogFrom = new DatePickerDialog(
                this, LandingActivity.this, 2017, 12, 11);

        datePickerDialogTo = new DatePickerDialog(
                this, LandingActivity.this, 2017, 12, 11);

        mCustomPagerAdapter = new CustomPagerAdapter(this);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        createOrHistoryButton = (Button)findViewById(R.id.createOrHistoryButton);
        searchButton = (Button)findViewById(R.id.reserveButton);

        ((ImageButton) findViewById(R.id.datepickerButtonFrom))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        datePickerDialogFrom.show();
                    }
                });

        ((ImageButton) findViewById(R.id.datepickerButtonTo))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        datePickerDialogTo.show();
                    }
                });



        if(prefs.getBoolean("guest", true)) {
            createOrHistoryButton.setText("Create Account");
        } else {
            createOrHistoryButton.setText("Ride History");
        }


        createOrHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(prefs.getBoolean("guest", true)) {
                    Intent i = new Intent(LandingActivity.this, LoginActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(LandingActivity.this, HistoryActivity.class);
                    startActivity(i);
                }
            }
        });

        mViewPager.setAdapter(mCustomPagerAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeShared(categorySpinner.getSelectedItem().toString(), "", "", locationSpinner.getSelectedItem().toString()) ;
                Intent i = new Intent(LandingActivity.this, CarListActivity.class);
                startActivity(i);
            }
        });



    }



    private void storeShared(String category, String from, String to, String location) {
        prefs.edit().putString("category", category).putString("from", from).putString("to", to).putString("location", location).apply();
    }



    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        System.out.println(datePicker.getId()+ "   -  " + i +  "   -   " + i1 + "   -   " + i2);
    }
}
