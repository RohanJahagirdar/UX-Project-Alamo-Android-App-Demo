package com.rjahagirdar.alamoproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MessageListActivity extends AppCompatActivity {

    Button button_chatbox_se;
    EditText newIn;

    int press = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button_chatbox_se = findViewById(R.id.button_chatbox_send);
        newIn = findViewById(R.id.edittext_chatbox);




        button_chatbox_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(press <=0) {
                    Calendar c = Calendar.getInstance();

                    int hr = c.get(Calendar.HOUR_OF_DAY);
                    int min = c.get(Calendar.MINUTE);


                    View test1View = findViewById(R.id.newmessagelayout);
                    TextView test1TextView = (TextView) test1View.findViewById(R.id.text_message_body);
                    TextView time = (TextView) test1View.findViewById(R.id.text_message_time);
                    time.setText(hr + ":" + min);
                    test1TextView.setText(newIn.getText());

                    test1View.setVisibility(View.VISIBLE);

                    press++;
                } else {
                    Intent i = new Intent(MessageListActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });




    }
}
