package com.example.pafitness;

        import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Home intent
        ImageButton home = (ImageButton) findViewById(R.id.homeButton);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ProfileActivity.this,HomeActivity.class);
                ProfileActivity.this.startActivity(intent2);

            }
        });

        //Arroundyou intent
        ImageButton arroundYou = (ImageButton) findViewById(R.id.arroundYouButton);

        arroundYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ProfileActivity.this,HomeActivity.class);
                ProfileActivity.this.startActivity(intent2);

            }
        });

        //Profile intent
        ImageButton profile = (ImageButton) findViewById(R.id.profileButton);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ProfileActivity.this,ProfileActivity.class);
                ProfileActivity.this.startActivity(intent2);

            }
        });
        //EditProfile intent

        Button editProfile = (Button) findViewById(R.id.button4);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ProfileActivity.this,EditprofileActivity.class);
                ProfileActivity.this.startActivity(intent2);

            }
        });
        //LogOut
        TextView LogOut = (TextView) findViewById(R.id.logout);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ProfileActivity.this, LoginActivity.class);
                ProfileActivity.this.startActivity(intent2);

            }
        });
    }
}