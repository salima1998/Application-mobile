package com.example.cm.quizapp_m4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class Score extends AppCompatActivity {
TextView tvscore;
CircleProgress c1;
Button bretry, bexit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tvscore= findViewById(R.id.tvScore);
        c1= findViewById(R.id.circle_progress);
        bretry =findViewById(R.id.button);
        bexit=findViewById(R.id.button3);

        Intent i = getIntent();
        int int1= i.getIntExtra("score",0);
        tvscore.setText("Your Score  Is :"+ Integer.toString(int1));
        c1.setMax(3);
        c1.setProgress(int1);



        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Score.this,MainActivity.class));
            }
        });
        bretry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Score.this,Quiz1.class));
            }
        });
    }
}
