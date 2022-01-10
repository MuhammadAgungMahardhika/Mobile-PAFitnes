package com.example.pafitness.Activity;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pafitness.R;

public class EditprofileActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText editEmail,editNama,editPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        Intent data = getIntent();
        String email = data.getStringExtra("email");
        String fullname = data.getStringExtra("fname");
        String phone = data.getStringExtra("phone");

        editEmail = findViewById(R.id.editemail3);
        editNama = findViewById(R.id.Edit_fullname);
        editPhone = findViewById(R.id.Edit_mobile);

        editEmail.setText(email);
        editNama.setText(fullname);
        editPhone.setText(phone);

        Log.d("em",email);
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