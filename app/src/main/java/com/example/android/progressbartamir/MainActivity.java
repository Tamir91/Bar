package com.example.android.progressbartamir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public void nextActivity() {
        Intent intent = new Intent(this, NameActivity.class);
        startActivity(intent);
    }
}