package com.example.pafitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GenderActivity extends AppCompatActivity {
ok
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        Button Gender = (Button) findViewById(R.id.buttonGender);

        Gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(GenderActivity.this,LoginActivity.class);
                GenderActivity.this.startActivity(intent2);
            }
        });
    }
}