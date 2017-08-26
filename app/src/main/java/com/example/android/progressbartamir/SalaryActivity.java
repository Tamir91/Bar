package com.example.android.progressbartamir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class SalaryActivity extends AppCompatActivity {

    Button buttonNext, buttonBack;
    TextView textViewSalary;
    ProgressBar progressBar;
    SeekBar salarySeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);
        initViews();
        initListeners();
        setSeekBar();
    }

    public void initListeners() {
        final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonBack:
                        buttonBackClick();
                        break;
                    case R.id.buttonNext:
                        buttonNextClick();
                        break;
                }
            }
        };
        buttonNext.setOnClickListener(onClickListener);
        buttonBack.setOnClickListener(onClickListener);
    }

    public void buttonNextClick() {
        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra("salary", textViewSalary.getText().toString());
        startActivity(intent);
    }

    public void buttonBackClick() {
        Intent intent = new Intent(this, PhotoActivity.class);
        startActivity(intent);
    }

    public void initViews() {
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        textViewSalary = (TextView) findViewById(R.id.tvSalary);
        progressBar = (ProgressBar) findViewById(R.id.progressBarActivities);
        progressBar.setProgress(2);
        salarySeekBar = (SeekBar) findViewById(R.id.seekBar);
    }

    public void  setSeekBar(){
        salarySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int salary = seekBar.getProgress();
                textViewSalary.setText(salary);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


}

