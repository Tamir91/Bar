package com.example.android.progressbartamir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import android.widget.Toast;

public class NameActivity extends AppCompatActivity {
    EditText editTextName, editTextAge;
    Button buttonNext, buttonBack;
    ProgressBar progressBar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    public void initViews() {
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        progressBar = (ProgressBar) findViewById(R.id.progressBarActivites);
    }

    public void initListeners() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonNext:
                        buttonNextClick(view);
                        break;
                    case R.id.buttonBack:
                        buttonBackClick(view);
                        break;
                }

            }
        };
        buttonNext.setOnClickListener(onClickListener);
        buttonBack.setOnClickListener(onClickListener);

    }

    public void buttonNextClick(View view) {
        if (!editTextName.equals("") && !editTextName.equals("")) {
            intent = new Intent(this, PhotoActivity.class);
            intent.putExtra("name", editTextName.getText().toString());
            intent.putExtra("age", editTextAge.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonBackClick(View view) {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
