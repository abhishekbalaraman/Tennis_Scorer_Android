package mia.abhishek.tennisscorer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String str;
    private String str1;
    String prefsName = "myPrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Onclick(View v) {
        if (v.getId() == R.id.bplay)//To start the game with the player 1 name and player 2 name fixed by the user
        {
            final EditText a = (EditText) findViewById(R.id.tp1);
            final EditText b = (EditText) findViewById(R.id.tp2);
            str = a.getText().toString();
            str1 = b.getText().toString();
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("player1", str);
            i.putExtra("player2", str1);
            startActivity(i);
        }
        if (v.getId() == R.id.babout) //To view the software license and version
        {
            Intent p = new Intent(MainActivity.this, FourthActivity.class);
            startActivity(p);
        }
        if (v.getId() == R.id.bexit) //To close the application
        {
            finish();
        }


    }
    @Override
    public void onPause(){
        super.onPause();

        SharedPreferences prefs=getSharedPreferences(prefsName, MODE_PRIVATE);//used when the activity is stopped and to resume where it stops
        SharedPreferences.Editor editor = prefs.edit();
        EditText a = (EditText) findViewById(R.id.tp1);
        EditText b = (EditText) findViewById(R.id.tp2);
        editor.putString("a_text", a.getText().toString());
        editor.putString("b_text", b.getText().toString());
        editor.commit();
    }

    }
