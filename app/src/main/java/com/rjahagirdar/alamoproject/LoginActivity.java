package com.rjahagirdar.alamoproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText email, password, nickname;
    ImageView user_dp, m_1, m_2, m_3, m_4, m_5, w_1, w_2, w_3, w_4, w_5;
    GridLayout gridLayout;
    Window window;

    TextView retain_theme;

    private Button done;
    private Pattern pattern;
    //    private Toast toast;
    int profile_character = 0;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String profile_image = "m_1";

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        window = getWindow();

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        pattern = Pattern.compile(EMAIL_PATTERN);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        nickname = (EditText)findViewById(R.id.nickname);
        retain_theme = (TextView)findViewById(R.id.retain_theme);



        done = (Button)findViewById(R.id.done);
        gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        user_dp  = (ImageView)findViewById(R.id.profile_image);

        m_1 = (ImageView)findViewById(R.id.m_1);
        m_2 = (ImageView)findViewById(R.id.m_2);
        m_3 = (ImageView)findViewById(R.id.m_3);
        m_4 = (ImageView)findViewById(R.id.m_4);
        m_5 = (ImageView)findViewById(R.id.m_5);

        w_1 = (ImageView)findViewById(R.id.w_1);
        w_2 = (ImageView)findViewById(R.id.w_2);
        w_3 = (ImageView)findViewById(R.id.w_3);


        w_4 = (ImageView)findViewById(R.id.w_4);
        w_5 = (ImageView)findViewById(R.id.w_5);

        retain_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
                    //    gridLayout.setBackgroundColor(getResources().getColor(R.color.m1ColorPrimary));
                }
            }
        });

        m_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                user_dp.setBackgroundResource(R.drawable.m_1);
                profile_character = 0;
                setTheme(R.style.m1Theme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.m1ColorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.m1ColorPrimary)));
                    //    gridLayout.setBackgroundColor(getResources().getColor(R.color.m1ColorPrimary));
                    profile_image = "m_1";
                }
            }
        });

        m_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_dp.setBackgroundResource(R.drawable.m_2);
                profile_character = 1;
                setTheme(R.style.m2Theme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.m2ColorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.m2ColorPrimary)));
                    //    gridLayout.setBackgroundColor(getResources().getColor(R.color.m2ColorPrimary));
                    profile_image = "m_2";
                }
            }
        });

        m_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_dp.setBackgroundResource(R.drawable.m_3);
                profile_character = 2;
                setTheme(R.style.m3Theme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.m3ColorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.m3ColorPrimary)));
                    //   gridLayout.setBackgroundColor(getResources().getColor(R.color.m3ColorPrimary));
                    profile_image = "m_3";
                }
            }
        });

        m_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_dp.setBackgroundResource(R.drawable.m_4);
                profile_character = 3;
                setTheme(R.style.m4Theme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.m4ColorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.m4ColorPrimary)));
                    //   gridLayout.setBackgroundColor(getResources().getColor(R.color.m4ColorPrimary));
                    profile_image = "m_4";
                }
            }
        });

        m_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_dp.setBackgroundResource(R.drawable.m_5);
                profile_character = 4;
                setTheme(R.style.m5Theme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.m5ColorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.m5ColorPrimary)));
                    //    gridLayout.setBackgroundColor(getResources().getColor(R.color.m5ColorPrimary));
                    profile_image = "m_5";
                }
            }
        });



        w_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_dp.setBackgroundResource(R.drawable.w_1);
                profile_character = 5;
                setTheme(R.style.w1Theme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.w1ColorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.w1ColorPrimary)));
                    //   gridLayout.setBackgroundColor(getResources().getColor(R.color.w1ColorPrimary));
                    profile_image = "w_1";
                }
            }
        });

        w_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_dp.setBackgroundResource(R.drawable.w_2);
                profile_character = 6;
                setTheme(R.style.w2Theme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.w2ColorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.w2ColorPrimary)));
                    //    gridLayout.setBackgroundColor(getResources().getColor(R.color.w2ColorPrimary));
                    profile_image = "w_2";
                }
            }
        });

        w_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_dp.setBackgroundResource(R.drawable.w_3);
                profile_character = 7;
                setTheme(R.style.w3Theme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.w3ColorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(
                            new ColorDrawable(getResources().getColor(R.color.w3ColorPrimary)));
                    //   gridLayout.setBackgroundColor(getResources().getColor(R.color.w3ColorPrimary));
                    profile_image = "w_3";
                }
            }
        });

        w_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_dp.setBackgroundResource(R.drawable.w_4);
                profile_character = 8;
                setTheme(R.style.w4Theme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.w4ColorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.w4ColorPrimary)));
                    //    gridLayout.setBackgroundColor(getResources().getColor(R.color.w4ColorPrimary));
                    profile_image = "w_4";
                }
            }
        });

        w_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_dp.setBackgroundResource(R.drawable.w_5);
                profile_character = 9;
                setTheme(R.style.w5Theme);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    window.setStatusBarColor(getResources().getColor(R.color.w5ColorPrimaryDark));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.w5ColorPrimary)));
                    //    gridLayout.setBackgroundColor(getResources().getColor(R.color.w5ColorPrimary));
                    profile_image = "w_5";
                }
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = email.getText().toString();
                String user_password = password.getText().toString();
                String user_nickname = nickname.getText().toString();

                if(user_email.trim().length() <=0 || user_password.trim().length() <=0) {
                    Toast.makeText(LoginActivity.this, "Please enter a valid email id and password.", Toast.LENGTH_LONG).show();
                } else {
                    if (validate(user_email, user_password)) {
                        prefs.edit().putString("email", user_email).
                                putString("password", user_password).
                                putString("name", user_nickname).
                                putString("profile_image", profile_image).
                                putBoolean("guest", false).apply();

                        Intent i = new Intent(LoginActivity.this, LandingActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                }
            }
        });
    }


    private boolean validate(String email, String password) {
        if (!pattern.matcher(email).matches()) {
            Toast.makeText(LoginActivity.this, "Please enter a valid email id.", Toast.LENGTH_LONG).show();
            return false;
        } else if (password.length() == 0 || password.length() < 4) {
            Toast.makeText(LoginActivity.this, "Please enter a valid password.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    public boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isAvailable())
            return true;
        else
            return false;
    }

}
