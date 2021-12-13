package com.example.pafitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button Home;
    EditText username,password;
    String email,pass;
    String cekEmail,cekPass1;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Login intent
        username = findViewById(R.id.editUsername);
        password =  findViewById(R.id.editPassword);
        Home = findViewById(R.id.Login);
        mAuth = FirebaseAuth.getInstance();
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cekEmail = username.getText().toString();
                cekPass1 = password.getText().toString();

                if(cekEmail.isEmpty() || cekPass1.isEmpty() ){
                    Toast.makeText(LoginActivity.this, "Login failed, please fill email and password",
                            Toast.LENGTH_SHORT).show();
                }else if(cekPass1.length() <=6){
                    Toast.makeText(LoginActivity.this, "Login failed , Password's characters less than 6 characters",
                            Toast.LENGTH_SHORT).show();
                }else{
                    cekLogin();
                }
            }
        });


        //sing up  intent
        TextView Signup2 = (TextView) findViewById(R.id.textView8);
        Signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(LoginActivity.this, SignupActivity.class);
                LoginActivity.this.startActivity(intent2);

            }
        });

        //forget password intent
        TextView forgetpassword = (TextView) findViewById(R.id.textView9);

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(LoginActivity.this, ForgetpasswordActivity.class);
                LoginActivity.this.startActivity(intent2);

            }
        });


    }

    //Cek kondisi login dengan Firebase
    private void cekLogin() {
        email = username.getText().toString();
        pass = password.getText().toString();

        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login success",
                            Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(LoginActivity.this, HomeActivity.class);
                    LoginActivity.this.startActivity(intent2);
                    finish();
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(LoginActivity.this, "Login failed, please check your email and password again!",
                            Toast.LENGTH_SHORT).show();

                }

                // ...
            }
        });
    }
}