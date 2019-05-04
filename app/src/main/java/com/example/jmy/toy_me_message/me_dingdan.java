package com.example.jmy.toy_me_message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;



public class me_dingdan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_dingdan);
        getSupportActionBar().hide();


        TextView zulin=(TextView) findViewById(R.id.textView11);
        zulin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(me_dingdan.this,me_dingdan_zulin.class);
                startActivity(intent);
            }
        });

        TextView goumai=(TextView) findViewById(R.id.textView12);
        goumai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(me_dingdan.this,me_dingdan_goumai.class);
                startActivity(intent);

            }
        });
    }
}
