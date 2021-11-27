package com.example.pafitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResetpasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        Button ResetPassword= (Button) findViewById(R.id.buttonResetpassword);

        ResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ResetpasswordActivity.this,NewpasswordActivity.class);
                ResetpasswordActivity.this.startActivity(intent2);

            }
        });
    }
}