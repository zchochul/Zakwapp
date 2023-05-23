package com.example.zakwapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton button_feeding;
    ImageButton button_is_dead;
    ImageButton button_movies;
    ImageButton button_calendar;
    boolean isAlive = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        button_is_dead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = onCreateDialogDead();
                dialog.show();

            }
        });




    }


   //public class DialogDead extends DialogFragment {
        //@Override
        public Dialog onCreateDialogDead() {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("How to check, if your starter is dead? \n" +
                            "- it smells weirdly\n" +
                            "- it has a mold on it\n" +
                            "- you haven't feed it in a while\n" +
                            "Is your starter dead then??")
                    .setPositiveButton("Alive", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id){
                            Toast.makeText(getBaseContext(), "Great to hear!", Toast.LENGTH_LONG).show();

                        }
                    })
                    .setNegativeButton("Dead", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getBaseContext(), "Oh no!", Toast.LENGTH_LONG).show();
                            isAlive = false;
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    //}
}