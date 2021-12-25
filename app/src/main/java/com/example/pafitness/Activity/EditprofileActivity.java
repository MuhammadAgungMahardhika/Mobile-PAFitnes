package com.example.pafitness.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pafitness.R;

public class EditprofileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);


        //EditProfile intent
        Button editProfile = (Button) findViewById(R.id.button4);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"SUCCESS", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(EditprofileActivity.this,ProfileActivity.class);
                EditprofileActivity.this.startActivity(intent2);

            }
        });
    }
}