package com.example.pafitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetpasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        Button forgetPassword= (Button)findViewById(R.id.Login);

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ForgetpasswordActivity.this,ResetpassActivity.class);
                ForgetpasswordActivity.this.startActivity(intent2);
            }
        });
    }
}