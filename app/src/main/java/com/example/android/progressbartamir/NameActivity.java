package com.example.android.progressbartamir;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import android.widget.Toast;

import com.example.android.progressbartamir.Entities.User;
import com.example.android.progressbartamir.dataAccess.UserPreferences;

public class NameActivity extends AppCompatActivity {
    EditText editTextName, editTextAge;
    Button buttonNext, buttonBack;
    ProgressBar progressBar;
    UserPreferences userPreferences;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        userPreferences = new UserPreferences(this);
        initViews();
        initListeners();
        loadUserData();


    }

    private void initViews() {
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        progressBar = (ProgressBar) findViewById(R.id.progressBarActivities);
        progressBar.setProgress(0);
    }

    private void initListeners() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonNext:
                        buttonNextClick();
                        break;
                    case R.id.buttonBack:
                        buttonBackClick();
                        break;
                }

            }
        };
        buttonNext.setOnClickListener(onClickListener);
        buttonBack.setOnClickListener(onClickListener);

    }

    private void buttonNextClick() {
        if (isEmpty(editTextName) || isEmpty(editTextAge)) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            String name = editTextName.getText().toString();
            String age = editTextAge.getText().toString();

            Intent intent = new Intent(this, PhotoActivity.class);

            user = new User();
            user.set_name(name);
            user.set_age(age);

            userPreferences.saveUserInDB(user);
            startActivity(intent);
        }
    }

    private void buttonBackClick() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private boolean isEmpty(EditText view) {
        if (view.getText().toString().isEmpty()) {
            return true;
        } else {
            return false;
        }

    }


    public void loadUserData() {
        user = new User();
        int ind = userPreferences.getIndex();
        user = userPreferences.getUser(ind - 1);
        if (user != null)
        {
            editTextName.setText(user.get_name());
            editTextAge.setText(user.get_age());
        }
    }

}
