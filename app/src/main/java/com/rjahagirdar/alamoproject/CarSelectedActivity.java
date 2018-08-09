package com.rjahagirdar.alamoproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class CarSelectedActivity extends AppCompatActivity {

    SharedPreferences prefs;
    TextView txtowner, txtrate, mileage, passengers, txtfeatures;
    ImageView imageCar;
    ExpandableTextView expandableTextView;

    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_selected);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        txtowner = findViewById(R.id.owner);
        txtrate = findViewById(R.id.rate);
        mileage = findViewById(R.id.mileage);
        passengers = findViewById(R.id.passengers);
        imageCar = findViewById(R.id.imageCar);
        txtfeatures = findViewById(R.id.txtfeatures);
        expandableTextView = (ExpandableTextView) findViewById(R.id.expandleTextView);

        go = findViewById(R.id.reserveButton);

        int selection = prefs.getInt("position", 0);
        String category = prefs.getString("category", "sedan");

        try {
            JSONObject obj = new JSONObject(getJsonFromAssets());
            JSONArray car_array = obj.getJSONArray(category.toLowerCase());
           JSONObject car_details = car_array.getJSONObject(selection);
            txtowner.setText(car_details.getString("owner"));
            txtrate.setText("$" + car_details.getString("rate") + "/day");
            mileage.setText(car_details.getString("mileage") + "mmiles per gallon");
            passengers.setText(car_details.getString("passengers"));
            expandableTextView.setText(car_details.getString("features"));
            txtfeatures.setText("Features: " + car_details.getString("name"));

            imageCar.setBackground(getResources().getDrawable(getResources().getIdentifier(car_details.getString("image"),"drawable",getPackageName())));

        //    Drawable d = CarSelectedActivity.this.getResources().getDrawable(resId);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CarSelectedActivity.this, ReviewActivity.class);
                startActivity(i);
            }
        });




    }


    public String getJsonFromAssets() {
        String json = null;
        try {
            InputStream is = getAssets().open("document.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
