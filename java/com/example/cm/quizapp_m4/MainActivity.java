package com.example.cm.quizapp_m4;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
       //declaration
 EditText etmail,etPassword;
        Button bLogin;
        TextView tvRegister;
        ProgressBar  progressBar;
        FirebaseAuth fauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //recuperation
        etmail= (EditText)findViewById(R.id.etLogin);
        etPassword=(EditText)findViewById(R.id.etPassword);
        bLogin=(Button)findViewById(R.id.blogin);
        tvRegister=(TextView)findViewById(R.id.tvRegister);
        fauth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar2);

        //Association de listeners
        bLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String Email = etmail.getText().toString().trim();
                String Pass = etPassword.getText().toString().trim();
                if (TextUtils.isEmpty(Email)) {
                    etmail.setError("login is Required .");
                    return;
                }
                if (TextUtils.isEmpty(Pass)) {
                    etPassword.setError("Password is Required");
                    return;
                }
                if (Pass.length() < 6) {
                    etPassword.setError("Password  must be >=6 characters ");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                //register the user in firebase
                fauth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Logging in Successfuly", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, Quiz1.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
    });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //traitement
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });
   }

 }
