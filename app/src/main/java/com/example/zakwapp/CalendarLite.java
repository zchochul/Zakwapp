package com.example.zakwapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.zakwapp.Feeding.DBHelper;
public class CalendarLite extends AppCompatActivity {

    DBHelper mydb;
    TextView dataTV;
    ArrayList<String> dataArray;
    Button backB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_lite);

        backB = findViewById(R.id.backBCL);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intentBack
                );
            }
        });
        mydb = new DBHelper(this);

        dataArray = mydb.getAllLogs();

        dataTV = findViewById(R.id.dataTV);
        for(int i = 0; i < dataArray.size(); i++){
            if(i==0)
                dataTV.setText(dataArray.get(i));
            else
                dataTV.append("\n "+dataArray.get(i));
        }
    }
}