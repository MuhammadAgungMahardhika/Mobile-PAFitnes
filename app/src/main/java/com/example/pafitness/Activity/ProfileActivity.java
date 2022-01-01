package com.example.pafitness.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
        import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pafitness.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class ProfileActivity extends AppCompatActivity {

    TextView email ,fname ,mobilephone;
    String userID;
    FirebaseFirestore db;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mobilephone = findViewById(R.id.Edit_mobile);
        email = findViewById(R.id.editemail3);
        fname = findViewById(R.id.Edit_fullname);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        userID = mAuth.getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                mobilephone.setText(documentSnapshot.getString("phone"));
                email.setText(documentSnapshot.getString("email"));
                fname.setText(documentSnapshot.getString("fName"));

            }
        });

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
                Intent intent2 = new Intent(ProfileActivity.this,MapsActivity.class);
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
               //logout
                // FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    // MENU HOME
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.buttonNotification:
                Intent intent2 = new Intent(ProfileActivity.this,NotificationActivity.class);
                ProfileActivity.this.startActivity(intent2);
                return true;
            case R.id.search:

                return true;
            case R.id.button_class:
                Intent intent3 = new Intent(ProfileActivity.this,NotificationActivity.class);
                ProfileActivity.this.startActivity(intent3);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}