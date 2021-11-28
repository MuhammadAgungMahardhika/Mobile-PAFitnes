package com.example.pafitness;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class NewpassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpass);

        Button newPassword= (Button)findViewById(R.id.buttonNewPassword);
        newPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"PASSWORD CHANGED", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(NewpassActivity.this,LoginActivity.class);
                NewpassActivity.this.startActivity(intent2);
            }
        });

    }
}