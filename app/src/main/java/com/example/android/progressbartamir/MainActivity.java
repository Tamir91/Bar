package com.example.android.progressbartamir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView tvReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvReg = (TextView) findViewById(R.id.tvMain);
        initListeners();
    }

    public void initListeners() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.tvMain) {
                    nextActivity();
                }
            }
        };
        tvReg.setOnClickListener(onClickListener);
    }

    public void nextActivity() {
        Intent intent = new Intent(this, NameActivity.class);
        startActivity(intent);
    }
}