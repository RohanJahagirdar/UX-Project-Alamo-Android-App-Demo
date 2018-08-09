package com.rjahagirdar.alamoproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {


    RadioGroup paymentGroup;
    EditText fullName, address1, address2, zipcode;
    Button proceed;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        paymentGroup = findViewById(R.id.paymentGroup);
        fullName = findViewById(R.id.fullname);
        address1 = findViewById(R.id.addressLine1);
        address2 = findViewById(R.id.addressLine2);
        zipcode = findViewById(R.id.zipcode);
        proceed = findViewById(R.id.proceed);


        fullName.setText(prefs.getString("name", ""));


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fullName.getText().toString().trim().equals("")) {
                    Toast.makeText(PaymentActivity.this, "Please enter a valid name.", Toast.LENGTH_SHORT).show();
                } else if(address1.getText().toString().trim().equals("")) {
                    Toast.makeText(PaymentActivity.this, "Please enter a valid Address.", Toast.LENGTH_SHORT).show();
                } else if(address2.getText().toString().trim().equals("")) {
                    Toast.makeText(PaymentActivity.this, "Please enter a valid Address.", Toast.LENGTH_SHORT).show();
                } else if(zipcode.getText().toString().trim().equals("")) {
                    Toast.makeText(PaymentActivity.this, "Please enter a valid ZipCode.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(PaymentActivity.this, PaymentCompletionActivity.class);
                    startActivity(i);
                }

            }
        });



    }
}
