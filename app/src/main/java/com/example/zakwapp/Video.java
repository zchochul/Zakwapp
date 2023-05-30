package com.example.zakwapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

        Button goBack;
        VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        goBack = findViewById(R.id.buttonGoBack);
        video = findViewById(R.id.videoView);
        String path = "android.resource://"+getPackageName()+"/"+R.raw.howtochleb;
        video.setVideoPath(path);
        video.start();
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video.stopPlayback();
                Intent intentMain = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intentMain);
            }
        });
    }
}