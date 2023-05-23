package com.example.zakwapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Video extends AppCompatActivity {

        Button goBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        goBack = findViewById(R.id.buttonGoBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentMain = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intentMain);
            }
        });
    }
}