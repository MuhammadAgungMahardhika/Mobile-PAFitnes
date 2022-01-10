package com.example.pafitness.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pafitness.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditprofileActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText editEmail,editNama,editPhone;
    ImageView profileimage;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        User = fAuth.getCurrentUser();

        Intent data = getIntent();
        String email = data.getStringExtra("email");
        String fullname = data.getStringExtra("fname");
        String phone = data.getStringExtra("phone");

        profileimage = findViewById(R.id.imageView);
        editEmail = findViewById(R.id.editemail3);
        editNama = findViewById(R.id.Edit_fullname);
        editPhone = findViewById(R.id.Edit_mobile);


        editEmail.setText(email);
        editNama.setText(fullname);
        editPhone.setText(phone);

        Log.d("em",email);
        //EditProfile intent
        Button editProfile = (Button) findViewById(R.id.button4);



        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openGalerryIntent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalerryIntent,1000);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editEmail.getText().toString().isEmpty()||
                        editNama.getText().toString().isEmpty()||
                editPhone.getText().toString().isEmpty()){

                Toast.makeText(getApplicationContext(),"data empty", Toast.LENGTH_LONG).show();
               return;
                }
                final String email = editEmail.getText().toString();
                User.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(@NonNull Void unused) {
                        DocumentReference docRef = fStore.collection("users").
                                document(User.getUid());

                        Map<String,Object> edited = new HashMap<>();
                        edited.put("email",email);
                        edited.put("fName",editNama.getText().toString());
                        edited.put("phone",editPhone.getText().toString());
                        docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(@NonNull Void unused) {
                                Toast.makeText(getApplicationContext(),
                                        "Profile Updated", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                                finish();
                            }
                        });
                        Toast.makeText(getApplicationContext(),"Email is changed", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EditprofileActivity.this,e.getMessage(),
                                Toast.LENGTH_LONG).show();

                    }
                });



//                Toast.makeText(getApplicationContext(),"SUCCESS", Toast.LENGTH_LONG).show();
//                Intent intent2 = new Intent(EditprofileActivity.this,ProfileActivity.class);
//                EditprofileActivity.this.startActivity(intent2);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1000){
            if (resultCode == Activity.RESULT_OK){
                Uri ImageUri = data.getData();
                profileimage.setImageURI(ImageUri);

            }

        }
    }
}