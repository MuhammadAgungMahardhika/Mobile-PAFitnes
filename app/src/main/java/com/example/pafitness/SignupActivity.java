package com.example.pafitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    Button SignUp;
    EditText username,password, password2;
    String email, pass,pass2;
    String cekEmail,cekPass1,cekPass2;
    Boolean samePass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.editemail);
        password =  findViewById(R.id.editPassword2);
        password2 = findViewById(R.id.editPassword3);
        SignUp = findViewById(R.id.buttonUp2);
        mAuth = FirebaseAuth.getInstance();


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekEmail = username.getText().toString();
                cekPass1 = password.getText().toString();
                cekPass2 = password2.getText().toString();
                samePass = cekPass1.equals(cekPass2);
                if(cekEmail.isEmpty() || cekPass1.isEmpty() || cekPass2.isEmpty()){
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
        email = username.getText().toString();
        pass = password.getText().toString();
        pass2 = password2.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, pass2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this, "Registry Success",
                                    Toast.LENGTH_SHORT).show();
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