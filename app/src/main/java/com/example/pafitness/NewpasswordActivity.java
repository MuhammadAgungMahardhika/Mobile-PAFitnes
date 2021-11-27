package com.example.pafitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewpasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);

        Button NewPassword= (Button) findViewById(R.id.buttonNewPassword);

        NewPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(NewpasswordActivity.this,LoginActivity.class);
                NewpasswordActivity.this.startActivity(intent2);

            }
        });
    }
}