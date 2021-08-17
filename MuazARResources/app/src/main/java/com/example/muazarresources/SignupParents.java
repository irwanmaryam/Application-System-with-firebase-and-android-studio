package com.example.muazarresources;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupParents extends AppCompatActivity {
    EditText emailId, password, parentname;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_parents);

        mFirebaseAuth = FirebaseAuth.getInstance();
        parentname = findViewById(R.id.parentname);
        emailId = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignUp = findViewById(R.id.psignup);
        tvSignIn = findViewById(R.id.textView);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();

                if(email.isEmpty()){
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(SignupParents.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignupParents.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(SignupParents.this, "Sign up unsuccessful. Try again", Toast.LENGTH_SHORT).show();
                            }
                            else {

                                addParent();






                            }
                        }

                    });
                }
                else{
                    Toast.makeText(SignupParents.this, "Error Occured!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupParents.this,LoginParentsActivity.class);
                startActivity(i);
            }
        });

    }



    private void addParent() {

        FirebaseDatabase dref = FirebaseDatabase.getInstance("https://something-8bbc0-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference database = dref.getReference("Parents");

        String name = parentname.getText().toString();
        if(!TextUtils.isEmpty(name))
        {
            String id = database.push().getKey();
            String email = emailId.getText().toString();
            Parent parents = new Parent(id, name, email);

            database.child(id).setValue(parents);
            Intent i = new Intent(SignupParents.this,LoginParentsActivity.class);

            i.putExtra("parentid", email);

            startActivity(i);


        }
    }
}
