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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    Toolbar toolbar;
    SharedPreferences prefs;
    private Button done, cancel;
    EditText password, nickname;
    TextView email;
    ImageView user_dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        email = (TextView)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        nickname = (EditText)findViewById(R.id.nickname);
        user_dp  = (ImageView)findViewById(R.id.profile_image);

        done = (Button) findViewById(R.id.done);
        cancel = (Button) findViewById(R.id.cancel);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String profile_image = prefs.getString("profile_image", "m_1");
                user_dp.setBackground(getResources().getDrawable(getResources().getIdentifier(profile_image, "drawable", getPackageName())));
                email.setText(prefs.getString("email", ""));
                password.setText(prefs.getString("password", "password123"));
                nickname.setText(prefs.getString("name", "Kevin Keagen"));
                String user_password = password.getText().toString();
                String user_nickname = nickname.getText().toString();
                if (user_password.trim().length() <= 0) {
                    Toast.makeText(ProfileActivity.this, "Please enter a valid email id and password.", Toast.LENGTH_LONG).show();
                } else {

                    prefs.edit().putString("password", user_password).
                            putString("name", user_nickname).
                            putString("profile_image", profile_image).
                            putBoolean("guest", false).apply();

                    Intent i = new Intent(ProfileActivity.this, LandingActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ProfileActivity.this, LandingActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
