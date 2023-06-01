package com.example.konfiguratorpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText edEmail, edPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    public void init(){
        mAuth = FirebaseAuth.getInstance();
        edEmail = findViewById(R.id.email);
        edPassword = findViewById(R.id.Password);
    }
    public void goRegPage(View view){
        startActivity(new Intent(LoginActivity.this, RegActivity.class));
    }
    public void signIn(View view){
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }
}