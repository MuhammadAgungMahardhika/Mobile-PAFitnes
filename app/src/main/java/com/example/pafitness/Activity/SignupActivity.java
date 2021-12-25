package com.example.pafitness.Activity;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pafitness.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    Button SignUp;
    EditText username,mobilephone,email,password, password2;
    String  name,phone,mail,pass,pass2;
    String cekUsername,cekMobilephone,cekEmail,cekPass1,cekPass2;
    String userID;
    Boolean samePass;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.editusername);
        mobilephone = findViewById(R.id.editMobile);
        email = findViewById(R.id.editemail);
        password =  findViewById(R.id.editPassword2);
        password2 = findViewById(R.id.editPassword3);
        SignUp = findViewById(R.id.buttonUp2);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekUsername = username.getText().toString();
                cekMobilephone = mobilephone.getText().toString();
                cekEmail = email.getText().toString();
                cekPass1 = password.getText().toString();
                cekPass2 = password2.getText().toString();
                samePass = cekPass1.equals(cekPass2);
                if(cekUsername.isEmpty()){
                    Toast.makeText(SignupActivity.this, "Registry failed, please fill username",
                            Toast.LENGTH_SHORT).show();
                }else if(cekMobilephone.isEmpty()){
                    Toast.makeText(SignupActivity.this, "Registry failed, please fill mobile phone",
                            Toast.LENGTH_SHORT).show();
                }else if(cekEmail.isEmpty() || cekPass1.isEmpty() || cekPass2.isEmpty()){
                    Toast.makeText(SignupActivity.this, "Registry failed, please fill email and password",
                            Toast.LENGTH_SHORT).show();
                }else if(cekPass1.length() <=6){
                    Toast.makeText(SignupActivity.this, "Registry failed , Password's characters less than 6 characters",
                            Toast.LENGTH_SHORT).show();
                }
                else if (samePass){
                    Register();

                }else{
                    Toast.makeText(SignupActivity.this, "Registry failed, please check your password again",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private void Register() {
        name = username.getText().toString();
        phone = mobilephone.getText().toString();
        mail = email.getText().toString();
        pass = password.getText().toString();
        pass2 = password2.getText().toString();
        mAuth.createUserWithEmailAndPassword(mail, pass2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this, "Registry Success",
                                    Toast.LENGTH_SHORT).show();
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = db.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName",name);
                            user.put("phone",phone);
                            user.put("email",mail);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"onSuccess: user Profile is created for "+userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "onFailure: " + e.toString());
                                }
                            });

                            Intent intent2 = new Intent(SignupActivity.this, GenderActivity.class);
                            SignupActivity.this.startActivity(intent2);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignupActivity.this, "Registry Failed",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
}