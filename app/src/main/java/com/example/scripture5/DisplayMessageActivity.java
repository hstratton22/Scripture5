package com.example.scripture5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String LOG_TAG = "received data";
    public static final String MyPREFERENCES = "MyPrefs" ;
    TextView textView;
    TextView text2;
    TextView tVerse;

    Button b2;
    public static final String Book = "bookKey";
    public static final String Chapter = "chapterKey";
    public static final String Verse = "verseKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String something = intent.getStringExtra(MainActivity.SOMETHING);
        String verse = intent.getStringExtra(MainActivity.VERSE);
        Log.i(LOG_TAG, "received " + message + " " + something + ":" + verse);


        textView = findViewById(R.id.message);
        text2 = findViewById(R.id.something);
        tVerse = findViewById(R.id.verse);
        textView.setText(message);
        text2.setText(something);
        tVerse.setText(verse);

    }

        public void saveScripture(View view) {
            b2=(Button)findViewById(R.id.button2);
            sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

            String m  = textView.getText().toString();
                String ch  = text2.getText().toString();
                String ver  = tVerse.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Book, m);
                editor.putString(Chapter, ch);
                editor.putString(Verse, ver);
            Log.i(LOG_TAG, "sharedPrefs: " + editor);
                editor.commit();//editor.apply();?*/
               Toast.makeText(DisplayMessageActivity.this,"Saved",Toast.LENGTH_LONG).show();

          //  }*/
        }

//practice to make Toast work
//ignore

        public void makeToast(View view) {
            // public void saveScripture(View view) {

            Toast.makeText(DisplayMessageActivity.this, "Scripture saved", Toast.LENGTH_LONG).show();
        }
            //Toast.makeText(getApplicationContext(),"Saved scripture",Toast.LENGTH_SHORT).show();
        /*
        Context context = getApplicationContext();
        CharSequence text = "Scripture saved!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

         */


   // }
    }


