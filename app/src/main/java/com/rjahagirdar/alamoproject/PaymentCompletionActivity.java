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

public class PaymentCompletionActivity extends AppCompatActivity {

    ImageView imageCar, imageCarpooler;
    TextView reservationComplete, carpoolRequest;
    Button cancel, accept;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_completion);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        imageCar = findViewById(R.id.imageCar);
        imageCarpooler = findViewById(R.id.imageCarpooler);

        reservationComplete = findViewById(R.id.reservationComplete);
        carpoolRequest = findViewById(R.id.carpoolRequest);
        cancel = findViewById(R.id.cancel);
        accept = findViewById(R.id.accept);

        carpoolRequest.setText("The following Alamo User is travelling from: " + prefs.getString("location", "Boston, MA"));


        try {
            int selection = prefs.getInt("position", 0);
            String category = prefs.getString("category", "sedan");
            JSONObject obj = new JSONObject(getJsonFromAssets());
            JSONArray car_array = obj.getJSONArray(category.toLowerCase());
            JSONObject car_details = car_array.getJSONObject(selection);
            imageCar.setBackground(getResources().getDrawable(getResources().getIdentifier(car_details.getString("image"), "drawable", getPackageName())));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.edit().putBoolean("acceptedCarpooler", true).apply();
                Intent i = new Intent(PaymentCompletionActivity.this, MessageListActivity.class);
                startActivity(i);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.edit().putBoolean("acceptedCarpooler", false).apply();

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
