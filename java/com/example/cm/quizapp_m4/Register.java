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

public class Register extends AppCompatActivity {
 TextView tvlog;
     EditText name,email,log,password;
     Button bregister;
     FirebaseAuth fauth;
     ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tvlog = findViewById(R.id.tvlog);
        name = findViewById(R.id.etName);
        email = findViewById(R.id.Mail);
        log = findViewById(R.id.Login);
        password = findViewById(R.id.etPassword);
        bregister= findViewById(R.id.bRegister);
        fauth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

if (fauth.getCurrentUser()!=null){
    startActivity(new Intent(getApplicationContext(), MainActivity.class));
    finish();
}
        bregister.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             String email1 = email.getText().toString().trim();
                                             String Pass1 = password.getText().toString().trim();
                                             if (TextUtils.isEmpty(email1)) {
                                                 email.setError("login is Required .");
                                                 return;
                                             }
                                             if (TextUtils.isEmpty(Pass1)) {
                                                 password.setError("Password is Required");
                                                 return;
                                             }
                                             if (Pass1.length() < 6) {
                                                 password.setError("Password  must be >=6 characters ");
                                                 return;
                                             }
                                             progressBar.setVisibility(View.VISIBLE);
                                             //register the user in firebase
                                             fauth.createUserWithEmailAndPassword(email1,Pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                 @Override
                                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                                     if (task.isSuccessful()) {
                                                         Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                                                         startActivity(new Intent(Register.this, MainActivity.class));
                                                     } else {
                                                         Toast.makeText(getApplicationContext(), "Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                     }

                                                 }
                                             });

                                         }
                                     });
        tvlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //traitement
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });

    }
}




