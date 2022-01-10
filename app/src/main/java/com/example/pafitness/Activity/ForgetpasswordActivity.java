package com.example.pafitness.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pafitness.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetpasswordActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        mAuth = FirebaseAuth.getInstance();
        userEmail = findViewById(R.id.editUseMail);
        Button resetPassword= (Button)findViewById(R.id.recovery_btn);
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail = userEmail.getText().toString();
                mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(@NonNull Void unused) {
                        Toast.makeText(ForgetpasswordActivity.this, "Reset Link Was Sent To Your Email", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(ForgetpasswordActivity.this, ResetpassActivity.class);
                        ForgetpasswordActivity.this.startActivity(intent2);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgetpasswordActivity.this, "Error! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

    }
}