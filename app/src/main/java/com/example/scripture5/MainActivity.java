package com.example.scripture5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.prove5.MESSAGE";
    public static final String SOMETHING = "com.example.prove5.SOMETHING";
    public static final String VERSE = "com.example.prove5.VERSE";
    //public static final String LOG_MESSAGE = "scripture is " + EXTRA_MESSAGE + " " + SOMETHING + ":" + VERSE;
    public static final String LOG_TAG = "Before intent";
    public static final String LOG_TAG2 = "shared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView loadedB= findViewById(R.id.loadB);
        //TextView loadedC= findViewById(R.id.loadC);
        //TextView loadedV= findViewById(R.id.loadV);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.book);
        EditText edChapter = findViewById(R.id.chapter);
        EditText edVerse = findViewById((R.id.verse));
        String message = editText.getText().toString();
        String chapter = edChapter.getText().toString();
        String verse= edVerse.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(SOMETHING, chapter);
        intent.putExtra(VERSE, verse);
        Log.i(LOG_TAG, "scripture is "+message + " " + chapter + ":" + verse);
        startActivity(intent);
    }
    public void onLoad(View view){
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String sB = sh.getString("bookKey", "");
        String sC = sh.getString("chapterKey", "");
        String sV = sh.getString("verseKey", "");

        TextView loadedB= findViewById(R.id.loadB);
        TextView loadedC= findViewById(R.id.loadC);
        TextView loadedV= findViewById(R.id.loadV);

        loadedB.setText(sB);
        loadedC.setText(sC);
        loadedV.setText(sV);
        Log.i(LOG_TAG2, "in onLoad for b: " + loadedB );
        Log.i(LOG_TAG2, "in onLoad for c: "+ loadedC);


    }
}