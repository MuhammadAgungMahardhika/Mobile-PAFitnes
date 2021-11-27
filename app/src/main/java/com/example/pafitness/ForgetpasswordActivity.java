package com.example.pafitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ForgetpasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        TextView forgetPassword= (TextView) findViewById(R.id.textView9);

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ForgetpasswordActivity.this, LoginActivity.class);
                ForgetpasswordActivity.this.startActivity(intent2);

            }
        });
    }
}