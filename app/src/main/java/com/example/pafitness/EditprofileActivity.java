package com.example.pafitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
                Intent intent2 = new Intent(EditprofileActivity.this,ProfileActivity.class);
                EditprofileActivity.this.startActivity(intent2);

            }
        });
    }
}