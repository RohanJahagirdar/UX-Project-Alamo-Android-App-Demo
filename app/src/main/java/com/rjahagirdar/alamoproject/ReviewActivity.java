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

public class ReviewActivity extends AppCompatActivity {

    SharedPreferences prefs;
    TextView txttotal, txtrate, mileage, txtcategory, txtstatetaxes, txtcharge, txtfinaltotal;
    ImageView imageCar;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        txttotal = findViewById(R.id.txttotal);
        txtcategory = findViewById(R.id.txtcategory);
        txtrate = findViewById(R.id.txtrate);
        mileage = findViewById(R.id.txtmiles);
        imageCar = findViewById(R.id.imageCar);

        go = findViewById(R.id.reserveButton);
        txtstatetaxes = findViewById(R.id.txtstatetaxes);
        txtcharge = findViewById(R.id.txtcharge);
        txtfinaltotal = findViewById(R.id.txtfinaltotal);



        txtstatetaxes.setText("$10");

        txtcharge.setText("$100");


        int selection = prefs.getInt("position", 0);
        String category = prefs.getString("category", "sedan");
        txtcategory.setText(category);

        try {
            JSONObject obj = new JSONObject(getJsonFromAssets());
            JSONArray car_array = obj.getJSONArray(category.toLowerCase());
            JSONObject car_details = car_array.getJSONObject(selection);
            txttotal.setText(car_details.getString("total"));
            txtrate.setText("$" + car_details.getString("rate") + "/day");
            mileage.setText(car_details.getString("mileage") + "miles");
            int test = Integer.valueOf(car_details.getString("total"));

            test = test + 140;
            txtfinaltotal.setText("$" + String.valueOf(test));
            imageCar.setBackground(getResources().getDrawable(getResources().getIdentifier(car_details.getString("image"),"drawable",getPackageName())));

            //    Drawable d = CarSelectedActivity.this.getResources().getDrawable(resId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ReviewActivity.this, PaymentActivity.class);
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
