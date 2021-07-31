package com.example.digiq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity4 extends AppCompatActivity {
    TextView signup;
    ImageView back;
    EditText mail;
    EditText pass;
    MaterialButton login;
    CheckBox checkBox;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        signup = findViewById(R.id.textView4);
        back = findViewById(R.id.imageView3);
        login  = findViewById(R.id.button3);
        mail = findViewById(R.id.editTextTextPersonName6);
        pass = findViewById(R.id.editTextTextPersonName5);
        checkBox = findViewById(R.id.checkBox2);
        mAuth = FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mail.getText().toString();
                String password = pass.getText().toString();
                if(email.equals("") || password.equals("")){
                    Toast.makeText(MainActivity4.this,"Please enter the required fields",Toast.LENGTH_SHORT).show();
                }
                else{
                if (checkBox.isChecked()){
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("logg", "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        startActivity(new Intent(MainActivity4.this, MainActivity5.class));
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("logg", "signInWithEmail:failure", task.getException());
                                        Toast.makeText(MainActivity4.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
            }
                else{
                    Toast.makeText(MainActivity4.this,"Please agree to the terms of services",Toast.LENGTH_SHORT).show();
                }}
            }
        });
    }
}