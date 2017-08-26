package com.example.android.progressbartamir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
    TextView tvName, tvAge, tvSalary;
    ProgressBar progressBarViews;
    Button bBack, bNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        initViews();
        initListener();
    }

    public void initViews() {
        bBack = (Button) findViewById(R.id.buttonBack);
        bNext = (Button) findViewById(R.id.buttonNext);
        tvName = (TextView) findViewById(R.id.tvName);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvSalary = (TextView) findViewById(R.id.tvSalary);
        progressBarViews = (ProgressBar) findViewById(R.id.progressBarActivities);
        progressBarViews.setProgress(3);
    }

    public void initListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonBack:
                        onClickListenerBack();
                        break;
                    case R.id.buttonNext:
                        onClickListenerFinish();
                        break;
                }
            }
        };
        bBack.setOnClickListener(onClickListener);
        bNext.setOnClickListener(onClickListener);

    }

    private void onClickListenerFinish() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);


    }

    private void onClickListenerBack() {
        Intent intent = new Intent(this, SalaryActivity.class);
        startActivity(intent);
    }
}
