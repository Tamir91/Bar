package com.example.android.progressbartamir;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.example.android.progressbartamir.R.id.editTextAge;
import static com.example.android.progressbartamir.R.id.editTextName;

public class PhotoActivity extends AppCompatActivity {
    ImageButton ibAvatar;
    Button buttonNext, buttonBack;
    ProgressBar progressBar;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
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
                    case R.id.imageViewPhoto:
                        dispatchTakePictureIntent(v);
                }
            }
        };
        buttonNext.setOnClickListener(onClickListener);
        buttonBack.setOnClickListener(onClickListener);
    }

    private void dispatchTakePictureIntent(View v) {
        Intent takeIntentPicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takeIntentPicture.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeIntentPicture, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ibAvatar.setImageBitmap(imageBitmap);
        }
    }

    public void buttonNextClick(View view) {
        Intent intent = new Intent(this, SalaryActivity.class);

        startActivity(intent);
    }

    public void buttonBackClick(View view) {
        Intent intent = new Intent(this, NameActivity.class);
        startActivity(intent);
    }

    public void initViews() {
        ibAvatar = (ImageButton) findViewById(R.id.imageButtonPhoto);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        progressBar = (ProgressBar) findViewById(R.id.progressBarActivities);
        progressBar.setProgress(1);
    }
}
