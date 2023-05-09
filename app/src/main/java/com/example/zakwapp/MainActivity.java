package com.example.zakwapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button_feeding;
    Button button_is_dead;
    Button button_movies;
    Button button_calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("d");
        button_feeding = findViewById(R.id.Feed_button);
        button_is_dead = findViewById(R.id.Is_Dead_Button);
        button_movies = findViewById(R.id.Movies_Button);
        button_calendar = findViewById(R.id.Calendar_Button);

        button_feeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFeed = new Intent(getBaseContext(),Feeding.class);
                startActivity(intentFeed);
            }
        });
    }
}