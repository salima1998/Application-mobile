package com.example.cm.quizapp_m4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class Quiz3 extends AppCompatActivity {

    int score = 1;
    Button blnext ;
    RadioGroup gr1;
    RadioButton b1,b2;
    TextView tvscore;
    CircleProgress c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        gr1= findViewById(R.id.gr1);
        b1= findViewById(R.id.etOption1);
        b2= findViewById(R.id.etOption2);
        blnext= findViewById(R.id.blNext);

        Intent i = getIntent();
        int int1= i.getIntExtra("score",0);


        blnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1.isChecked()) {
                    Intent intent = new Intent(Quiz3.this,Score.class);
                    score = score + 1;
                    getIntent().putExtra("score", score);
                    startActivity(intent);

                }else if (b2.isChecked()){
                    Toast.makeText(getApplicationContext(),"Reponse incorrect", Toast.LENGTH_SHORT).show();
                    b1.setChecked(false);
                    b2.setChecked(false);

                }
            }
        });
    }
}
