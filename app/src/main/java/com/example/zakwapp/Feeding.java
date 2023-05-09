package com.example.zakwapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feeding extends AppCompatActivity {

    EditText flourEdit;
    EditText waterEdit;
    Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding);

        flourEdit = findViewById(R.id.flourEdit);
        waterEdit = findViewById(R.id.waterEdit);
        doneButton = findViewById(R.id.doneFeedingButton);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentMain = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intentMain);
            }
        });
    }
}