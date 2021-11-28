package com.example.pafitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        //Login intent
        Button Home = (Button) findViewById(R.id.Login);
        EditText username = (EditText) findViewById(R.id.editUsername);
        EditText password = (EditText) findViewById(R.id.editPassword);

        
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin")
                        && password.getText().toString().equals("admin")){

                    Toast.makeText(getApplicationContext(),"LOGIN BERHASIL", Toast.LENGTH_LONG).show();
                    Intent intent2 = new Intent(LoginActivity.this, HomeActivity.class);
                    LoginActivity.this.startActivity(intent2); 
                }else{
                    Toast.makeText(getApplicationContext(),"USERNAME ATAU PASSWORD SALAH",
                            Toast.LENGTH_LONG).show();
                }


            }

        });

    }
}