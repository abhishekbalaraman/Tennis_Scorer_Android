package mia.abhishek.tennisscorer;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        final TextView tpl1 = (TextView)findViewById(R.id.tpl1);
        final TextView tpl2 = (TextView)findViewById(R.id.tpl2);

        tpl1.setText(getIntent().getStringExtra("p1"));
        tpl2.setText(getIntent().getStringExtra("p2"));
    }
    public void Onclick(View v) {
        if (v.getId() == R.id.bmenu)  //To move to mainActivity
        {
            Intent n = new Intent(ThirdActivity.this, MainActivity.class);
            startActivity(n);
        }
        if(v.getId()==R.id.bback) //To move back to the SecondActivity
        {
            Intent r = new Intent(ThirdActivity.this,SecondActivity.class);
            startActivity(r);
        }
    }
}
