package com.example.android.progressbartamir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class SalaryActivity extends AppCompatActivity {

    Button buttonNext, buttonBack;
    ProgressBar progressBar;
    ProgressBar salaryProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);
        initViews();
        initListeners();
    }

    public void initListeners() {
        final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonBack:
                        buttonBackClick(v);
                        break;
                    case R.id.buttonNext:
                        buttonNextClick(v);
                        break;
                }
            }
        };
        buttonNext.setOnClickListener(onClickListener);
        buttonBack.setOnClickListener(onClickListener);
    }

    public void buttonNextClick(View view) {
        Intent intent = new Intent(this, SalaryActivity.class);

        startActivity(intent);
    }

    public void buttonBackClick(View view) {
        Intent intent = new Intent(this, PhotoActivity.class);
        startActivity(intent);
    }

    public void initViews() {
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        progressBar = (ProgressBar) findViewById(R.id.progressBarActivities);
        progressBar.setProgress(2);
    }
}

