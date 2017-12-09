package mia.abhishek.tennisscorer;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    int x;//Counter for player1
    int y;//Counter for player2
    Chronometer chrono;//assigning a name for the chronometer
    long time=0;//assigning time as 0 to start chronometer from 0
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tm1,tm2; //all the textviews used for saving the instance


    Button bp1,bp2,bstart,bpause;

    //private int _Tennis_Id=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String player1= getIntent().getStringExtra("player1");//Calling the variable assigned as player 1 in main activity
        String player2= getIntent().getStringExtra("player2");//Calling the variable assigned as player 2 in main activity
        final TextView talky1=(TextView)findViewById(R.id.talky1);//Assigning the user-defined player1 name to be displayed on SecondActivity
        final TextView talky2=(TextView)findViewById(R.id.talky2);//Assigning the user-defined player2 name to be displayed on SecondActivity
        talky1.setText(player1);
        talky2.setText(player2);
        Button bdb=(Button)findViewById(R.id.bdb);
        Button bdelete=(Button)findViewById(R.id.bdelete);
         bstart =(Button)findViewById(R.id.bstart);
         bpause =(Button)findViewById(R.id.bpause);
        chrono = (Chronometer)findViewById(R.id.chronom);
        bstart.setOnClickListener(this);
        bpause.setOnClickListener(this);
        bp1 = (Button) findViewById(R.id.bp1);  // The Player 1 Button
        bp2 = (Button) findViewById(R.id.bp2);  // The Player 2 Button
        Button bres = (Button) findViewById(R.id.bres);// The Reset Button
        Button bresult = (Button)findViewById(R.id.bresult);//The Result Button
        tm1 = (TextView) findViewById(R.id.tm1); //Score for Player 1
        tm2 = (TextView) findViewById(R.id.tm2); //Score for Player 2
        tv1 = (TextView) findViewById(R.id.tv1); //Set for Player 1
        tv2 = (TextView) findViewById(R.id.tv2); //Set for Player 1
        tv3 = (TextView) findViewById(R.id.tv3); //Set for Player 1
        tv4 = (TextView) findViewById(R.id.tv4); //Set for Player 2
        tv5 = (TextView) findViewById(R.id.tv5); //Set for Player 2
        tv6 = (TextView) findViewById(R.id.tv6); //Set for Player 2


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);


      /* _Tennis_Id =0;
        Intent intent = getIntent();
        _Tennis_Id =intent.getIntExtra("tennis_Id", 0);
       TennisRepo repo = new TennisRepo(this);
        Tennis tennis = new Tennis();
        tennis = repo.getTennisById(_Tennis_Id);
        tv1.setText(toString().valueOf(tennis.sets));
        tv2.setText(toString().valueOf(tennis.sets));
        tv3.setText(toString().valueOf(tennis.sets));
        tv4.setText(toString().valueOf(tennis.sets));
        tv5.setText(toString().valueOf(tennis.sets));
        tv6.setText(toString().valueOf(tennis.sets));
        tm1.setText(toString().valueOf(tennis.score));
        tm1.setText(toString().valueOf(tennis.score));
        talky1.setText(toString().valueOf(tennis.name));
        talky2.setText(toString().valueOf(tennis.name));*/


        final Button.OnClickListener listener = new Button.OnClickListener() {
            public void onClick(View v) {

            /*    if (v == findViewById(R.id.bdb)){
                  TennisRepo repo = new TennisRepo(SecondActivity.this);
                    Tennis tennis = new Tennis();
                    tennis.sets = (tv1);
                    tennis.sets = (tv2);
                    tennis.sets = (tv3);
                    tennis.sets = (tv4);
                    tennis.sets = (tv5);
                    tennis.sets = (tv6);
                    tennis.score = (tm1);
                    tennis.score = (tm2);
                    tennis.name = (talky1);
                    tennis.name = (talky2);
                    tennis.tennis_ID=_Tennis_Id;

                    if (_Tennis_Id==0){
                        _Tennis_Id = repo.insert(tennis);

                        Toast.makeText(SecondActivity.this,"Inserted",Toast.LENGTH_SHORT).show();
                    }else{

                        repo.update(tennis);
                        Toast.makeText(SecondActivity.this,"updated",Toast.LENGTH_SHORT).show();
                    }
                }else if (v== findViewById(R.id.bdelete)) {
                    TennisRepo repo = new TennisRepo(SecondActivity.this);
                    repo.delete(_Tennis_Id);
                    Toast.makeText(SecondActivity.this, "Deleted", Toast.LENGTH_SHORT);
                    finish();
                }*/

                int s1 = Integer.parseInt(tv1.getText().toString());  /* Assigning the variables for the set incrementation*/
            int s2 = Integer.parseInt(tv2.getText().toString());
            int s3 = Integer.parseInt(tv3.getText().toString());
            int s4 = Integer.parseInt(tv4.getText().toString());
            int s5 = Integer.parseInt(tv5.getText().toString());
            int s6 = Integer.parseInt(tv6.getText().toString());
                s1++;
                s2++;
                s3++;
                s4++;
                s5++;
                s6++;
                switch (v.getId()) {
                    case R.id.bp1:    //The functions assigned for the Player 1 button
                        x++;
                        if (x == 1) {
                            tm1.setText("15"); // If Player 1 button clicked once the score will be displayed as 15
                        } else if (x == 2) {
                            tm1.setText("30");// If Player 1 button clicked once the score will be displayed as 30
                        } else if (x == 3) {
                            tm1.setText("40"); // If Player 1 button clicked once the score will be displayed as 15

                        } else if (x == 4) {
                            if (tm1.getText() == "40" && tm2.getText() == "AD") {
                                tm2.setText("40");
                                tm1.setText("40");  //If Player 2 is AD and Player 1 40 and in next set if Player1 wins then Player 2 backs to 40
                                x--;
                                y--;
                            }else if(tm1.getText()=="40"&& tm2.getText()=="0")//If Player 1 is 40 and Player 2 is 0 and in next set if Player1 wins then Player 1 and Player 2 backs to 0
                            {
                                tm1.setText("0");
                                tm2.setText("0");
                                x--;
                               if (s1 != 7)
                                    tv1.setText("" + s1);
                                if (s1 == 7 && s2 < 7)
                                    tv2.setText("" + s2);
                                if (s2 == 7 && s3 < 7)
                                    tv3.setText("" + s3);

                            }
                        } else if (y == 3 && tm2.getText() != "AD") {
                            tm1.setText("AD"); //If Player 2 is not AD and Player 1 is 40 and in next set if Player1 wins then Player 1 moves to AD
                            x--;
                            y--;
                        }
                        else{
                            tm1.setText("0"); //setting the default to 0 if anyone wins
                            tm2.setText("0");
                            x = 0;
                            y = 0;
                            if (s1 != 7)
                                tv1.setText("" + s1);
                            if (s1 == 7 && s2 < s1)
                                tv2.setText("" + s2);
                            if (s2 == 7 && s3 < s2)
                                tv3.setText("" + s3);
                        }
                        /* Assigning alert messages if player 1 wins the particular set with the below possibilities*/
                        if(s1==8 && s4 == 6||s1 == 7 && s4 == 5 || s1 == 6 && s4 == 1 || s1 == 6 && s4 == 2 ||s1 == 6 && s4 ==3 || s1 == 6 && s4 == 4 || s1 > 6 && s4 == s1 - 2 )
                        {
                            s2++;
                            builder.setMessage(talky1+" won the 1st set by"+tv1.getText()+"-"+tv4.getText())
                                    .setPositiveButton("Cool!!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {}
                                    });
                            AlertDialog  theAlertDialog = builder.create();
                            theAlertDialog.setIcon(R.mipmap.ic_launcher);
                            theAlertDialog.setTitle("1st set over");
                            theAlertDialog.show();

                        }
                        if(s2==8 && s5 == 6||s2 == 7 && s5 == 5 || s2 == 6 && s5 == 1 || s2 == 6 && s5 == 2 ||s2 == 6 && s5 ==3 || s2 == 6 && s5 == 4 || s2 > 6 && s5 == s2 - 2 )
                        {
                                    s3++;
                                    builder.setMessage(talky1+" won the 2nd set by"+tv2.getText()+"-"+tv5.getText())
                                    .setPositiveButton("Cool!!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {}
                                    });
                            AlertDialog theAlertDialog = builder.create();
                            theAlertDialog.setIcon(R.mipmap.ic_launcher);
                            theAlertDialog.setTitle("2nd set over");
                            theAlertDialog.show();
                        }
                        if(s3==8 && s6 == 6||s3 == 7 && s6 == 5 || s3 == 6 && s6 == 1 || s3 == 6 && s6 == 2 ||s3 == 6 && s6 ==3 || s3 == 6 && s6 == 4 || s3 > 6 && s6 == s3 - 2 )
                        {

                            builder.setMessage(talky1+" won the 3rd set by"+tv3.getText()+"-"+tv6.getText())
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {}
                                    });
                            AlertDialog theAlertDialog = builder.create();
                            theAlertDialog.setIcon(R.mipmap.ic_launcher);
                            theAlertDialog.setTitle("3rd set over");
                            theAlertDialog.show();

                        }
                        /*If the player1 wins all the sets then assigning the alert box for game over and announcing player1 as winner*/
                        if(s1 > s4 && s2 > s5 && s3 > s6)
                        {
                            builder.setMessage(talky1+" won the game by"+tv1.getText()+"-"+tv4.getText()+","+tv2.getText()+"-"+tv5.getText()+","+tv3.getText()+"-"+tv6.getText())
                                    .setPositiveButton("Congrats!!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {}
                                    });
                            AlertDialog theAlertDialog = builder.create();
                            theAlertDialog.setIcon(R.mipmap.ic_launcher);
                            theAlertDialog.setTitle("GAME OVER!!!");
                            theAlertDialog.show();

                        }

                        break;
                    case R.id.bp2:        //The functions assigned for the Player 2 Button
                        y++;
                        if (y == 1) {
                            tm2.setText("15");// If Player 2 button clicked once the score will be displayed as 15
                        } else if (y == 2) {
                            tm2.setText("30");// If Player 2 button clicked once the score will be displayed as 30
                        } else if (y == 3) {
                            tm2.setText("40");// If Player 2 button clicked once the score will be displayed as 40
                        } else if (y == 4) {
                            if ( tm2.getText() == "40" && tm1.getText() == "AD") {
                                tm1.setText("40");
                                tm2.setText("40");//If Player 1 is AD and Player 2 is 40 and in next set if Player1 wins then Player 1 backs to 40
                                y--;
                                x--;
                            }
                            else if(tm2.getText()=="40"&& tm1.getText()=="0")//If Player 1 is 0 and Player 2 is 40 and in next set if Player2 wins then Player 1 and Player 2 backs to 0
                            {
                                tm1.setText("0");
                                tm2.setText("0");
                                y--;
                                if (s4 != 7)
                                    tv4.setText("" + s4);
                                if (s4 == 7 && s5 < s1)
                                    tv5.setText("" + s5);
                                if (s5 == 7 && s6 < s2)
                                    tv6.setText("" + s6);
                            }

                        } else if (x == 3 && tm1.getText() != "AD") {
                            tm2.setText("AD");
                            y--;
                            x--;//If Player 1 is not AD and Player 2 is 40 and in next set if Player2 wins then Player 2 moves to AD
                        }
                        else {
                            tm2.setText("0");
                            tm1.setText("0");
                            y = 0;
                            x = 0;
                            if (s4 != 7)
                                tv4.setText("" + s4);
                            if (s4 == 7 && s5 < 7)
                                tv5.setText("" + s5);
                            if (s5 == 7 && s6 < 7)
                                tv6.setText("" + s6);

                        }
                       /* Assigning alert messages if player 2 wins the particular set with the below possibilities*/
                        if(s4==8 && s1 == 6||s4 == 7 && s1 == 5 || s4 == 6 && s1 == 1 || s4 == 6 && s1 == 2 ||s4 == 6 && s1 ==3 || s4 == 6 && s1 == 4 || s4 > 6 && s1 == s4 - 2 )
                        {
                            s5++;
                        builder.setMessage(talky2+" won the 1st set by"+tv4.getText()+"-"+tv1.getText())
                                    .setPositiveButton("Cool!!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {}
                                    });
                            AlertDialog theAlertDialog = builder.create();
                            theAlertDialog.setIcon(R.mipmap.ic_launcher);
                            theAlertDialog.setTitle("1st set over");
                            theAlertDialog.show();


                        }
                        if(s5==8 && s2 == 6||s5 == 7 && s2 == 5 || s5 == 6 && s2 == 1 || s5 == 6 && s2 == 2 ||s5 == 6 && s2 ==3 || s5 == 6 && s2 == 4 || s5 > 6 && s2 == s5 - 2 )
                        {
                            s6++;
                            builder.setMessage(talky2+" won the 2nd set by"+tv5.getText()+"-"+tv2.getText())
                                    .setPositiveButton("Cool!!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {}
                                    });
                            AlertDialog theAlertDialog = builder.create();
                            theAlertDialog.setIcon(R.mipmap.ic_launcher);
                            theAlertDialog.setTitle("2nd set over");
                            theAlertDialog.show();


                        }
                        if(s6==8 && s3 == 6|| s6 == 7 && s3 == 5 || s6 == 6 && s3 == 1 || s6 == 6 && s3 == 2 ||s6 == 6 && s3 ==3 || s6 == 6 && s3 == 4 || s6 > 6 && s3 == s6 - 2 )
                        {


                           builder.setMessage(talky2+" won the 3rd set by"+tv6.getText()+"-"+tv3.getText())
                                    .setPositiveButton("Cool!!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {}
                                    });
                            AlertDialog theAlertDialog = builder.create();
                            theAlertDialog.setIcon(R.mipmap.ic_launcher);
                            theAlertDialog.setTitle("3rd set over");
                            theAlertDialog.show();

                        }
                         /*If the player2 wins all the sets then assigning the alert box for game over and announcing player2 as winner*/
                        if(s4 > s1 && s5 > s2 && s6 > s3)
                        {
                            builder.setMessage(talky2+" won the game by"+tv4.getText()+"-"+tv1.getText()+","+tv5.getText()+"-"+tv2.getText()+","+tv6.getText()+"-"+tv3.getText())
                                    .setPositiveButton("Congrats!!!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {}
                                    });
                            AlertDialog theAlertDialog = builder.create();
                            theAlertDialog.setIcon(R.mipmap.ic_launcher);
                            theAlertDialog.setTitle("GAME OVER!!!");
                            theAlertDialog.show();

                        }
                        break;
                    case R.id.bres:   //The function assigned for the Reset Button
                        x = 0;  /* It resets all the button including the counter to start the game from first by assigning all the text boxes as 0 */
                        y = 0;
                        tm1.setText("0");
                        tm2.setText("0");
                        tv1.setText("0");
                        tv2.setText("0");
                        tv3.setText("0");
                        tv4.setText("0");
                        tv5.setText("0");
                        tv6.setText("0");
                        chrono.start();
                        break;
                    case R.id.bresult://It opens the new activity where all the statistics of the match were being recorded
                        Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                        i.putExtra("p1",getIntent().getStringExtra("player1"));
                        i.putExtra("p2",getIntent().getStringExtra("player2"));
                        startActivity(i);
                        break;
                }
            }
        };
        bp1.setOnClickListener(listener);
        bp2.setOnClickListener(listener);
        bres.setOnClickListener(listener);
        bresult.setOnClickListener(listener);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bstart://starting the chronometer using the start button
                chrono.setBase(SystemClock.elapsedRealtime()+time);
                chrono.start();
                break;
            case R.id.bpause://Pausing the chronometer by pausing button
                time = chrono.getBase()-SystemClock.elapsedRealtime();
                chrono.stop();
                break;
        }

    }

    public void onSaveInstanceState(Bundle outState) { // called when the activity is in use after being created by the system

        super.onSaveInstanceState(outState);            //called after onDestroy
        outState.putString("s1", tv1.getText().toString());
        outState.putString("s2", tv2.getText().toString());
        outState.putString("s3", tv3.getText().toString());
        outState.putString("s4", tv4.getText().toString());
        outState.putString("s5", tv5.getText().toString());
        outState.putString("s6", tv6.getText().toString());
        outState.putString("x",bp1.getText().toString());
        outState.putString("y",bp2.getText().toString());
    }

    public void onRestoreInstanceState(Bundle savedInstancestate) { // called when the activity is recreated after being destroyed by the system
        super.onRestoreInstanceState(savedInstancestate);          // called after onStart


        tv1.setText(savedInstancestate.getString("s1"));
        tv2.setText(savedInstancestate.getString("s2"));
        tv3.setText(savedInstancestate.getString("s3"));
        tv4.setText(savedInstancestate.getString("s4"));
        tv5.setText(savedInstancestate.getString("s5"));
        tv6.setText(savedInstancestate.getString("s6"));
        bp1.setText(savedInstancestate.getString("x"));
        bp2.setText(savedInstancestate.getString("y"));

}


}