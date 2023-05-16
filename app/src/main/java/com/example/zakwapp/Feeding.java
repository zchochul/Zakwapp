package com.example.zakwapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Feeding extends AppCompatActivity {

    EditText flourEdit;
    EditText waterEdit;
    Button doneButton;
    TextView test;


    DBHelper mydb;
    ArrayList<String> logs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding);

        flourEdit = findViewById(R.id.flourEdit);
        waterEdit = findViewById(R.id.waterEdit);
        doneButton = findViewById(R.id.doneFeedingButton);
       // test = findViewById(R.id.TestoweTextView);

        mydb = new DBHelper(this);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Date currentTime = Calendar.getInstance().getTime();
                mydb.insertLog("data",waterEdit.getText().toString(),flourEdit.getText().toString());

                //logs = mydb.getAllLogs();

                /*String tmp = "";
                for(String g : logs ){
                    tmp = tmp.concat(g + "\n");

                }

                test.setText(tmp);*/

                Intent intentMain = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intentMain);
            }
        });
    }

    public class DBHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "MyDBName.db";
        public static final String LOGS_TABLE_NAME = "logs";
        public static final String LOGS_COLUMN_ID = "id";
        public static final String LOGS_COLUMN_DATE = "date";
        public static final String LOGS_COLUMN_WATER = "water";
        public static final String LOGS_COLUMN_FLOUR = "flour";
        private HashMap hp;

        public DBHelper(Context context) {
            super(context, DATABASE_NAME , null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL("create table logs " +"(id integer primary key, date,water,flour)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            db.execSQL("DROP TABLE IF EXISTS logs");
            onCreate(db);
        }

        public boolean insertLog (String date, String water, String flour) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("date", date);
            contentValues.put("water", water);
            contentValues.put("flour", flour);
            db.insert("logs", null, contentValues);
            return true;
        }

        public Cursor getData(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res =  db.rawQuery( "select * from logs where id="+id+"", null );
            return res;
        }

        public int numberOfRows(){
            SQLiteDatabase db = this.getReadableDatabase();
            int numRows = (int) DatabaseUtils.queryNumEntries(db, LOGS_TABLE_NAME);
            return numRows;
        }

        /*public boolean updateContact (Integer id, String name, String phone, String email, String street,String place) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", name);
            contentValues.put("phone", phone);
            contentValues.put("email", email);
            contentValues.put("street", street);
            contentValues.put("place", place);
            db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
            return true;
        }

        public Integer deleteContact (Integer id) {
            SQLiteDatabase db = this.getWritableDatabase();
            return db.delete("contacts",
                    "id = ? ",
                    new String[] { Integer.toString(id) });
        }*/

        @SuppressLint("Range")
        public ArrayList<String> getAllLogs() {
            ArrayList<String> array_list = new ArrayList<String>();

            hp = new HashMap();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res =  db.rawQuery( "select * from logs", null );
            res.moveToFirst();

            while(res.isAfterLast() == false){
                array_list.add(res.getString(res.getColumnIndex(LOGS_COLUMN_DATE)));

                array_list.add(res.getString(res.getColumnIndex(LOGS_COLUMN_WATER)));

                array_list.add(res.getString(res.getColumnIndex(LOGS_COLUMN_FLOUR)));
                res.moveToNext();
            }
            return array_list;
        }
    }
}