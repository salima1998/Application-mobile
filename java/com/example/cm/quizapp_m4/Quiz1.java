package com.example.cm.quizapp_m4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz1 extends AppCompatActivity {
    int score = 1;
 Button blnext ;
 RadioGroup gr1;
 RadioButton b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        gr1= findViewById(R.id.gr1);
        b1= findViewById(R.id.etOption1);
        b2= findViewById(R.id.etOption2);
        b3= findViewById(R.id.etOption3);
       blnext= findViewById(R.id.blNext);
        final int newScore = score;
      blnext.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              if (b1.isChecked()) {

                  Intent intent = new Intent(Quiz1.this,Quiz2.class);
                  score = score + 1;
                  getIntent().putExtra("score", newScore);
                  startActivity(intent);

              }else if (b2.isChecked() | b3.isChecked()){
                  Toast.makeText(getApplicationContext(),"Reponse incorrect", Toast.LENGTH_SHORT).show();
                  b1.setChecked(false);
                  b2.setChecked(false);
                  b3.setChecked(false);
              }



          }
      });

    }




}
