package com.example.muazarresources;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.muazarresources.R;
import com.example.muazarresources.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentDetails extends AppCompatActivity {

    // creating variables for
    // EditText and buttons.
    private EditText sName, age, pName, school;
    private Button save, back;
    Spinner session;



    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    Users users;





        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);


        // below line is used to get the
        // instance of our FIrebase database.

        // below line is used to get reference for our database.
        databaseReference = FirebaseDatabase.getInstance("https://something-8bbc0-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Students");

        // initializing our edittext and button
        sName = findViewById(R.id.sName);
        age = findViewById(R.id.age);
        pName = findViewById(R.id.pName);
        school = findViewById(R.id.school);
        session = findViewById(R.id.session);
        save = findViewById(R.id.save);
        back = findViewById(R.id.back);


            // initializing our object
        // class variable.





            // adding on click listener for our button.
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sName = ((EditText) findViewById(R.id.sName)).getText().toString();
                String age = ((EditText) findViewById(R.id.age)).getText().toString();
                String pName = ((EditText) findViewById(R.id.pName)).getText().toString();
                String school = ((EditText) findViewById(R.id.school)).getText().toString();
                String session = ((Spinner) findViewById(R.id.session)).getSelectedItem().toString();



                // below line is for checking weather the
                // edittext fields are empty or not.
                if (sName.isEmpty() || age.isEmpty() || pName.isEmpty()|| school.isEmpty()|| session.isEmpty()) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(StudentDetails.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase();

                }
            }
        });

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent int1 = new Intent(StudentDetails.this, HomeParents.class);
                    finish();
                    startActivity(int1);
                }
            });


    }

    private void addDatatoFirebase(){

        String sName = ((EditText) findViewById(R.id.sName)).getText().toString();
        String age = ((EditText) findViewById(R.id.age)).getText().toString();
        String pName = ((EditText) findViewById(R.id.pName)).getText().toString();
        String school = ((EditText) findViewById(R.id.school)).getText().toString();
        String session = ((Spinner) findViewById(R.id.session)).getSelectedItem().toString();
        //Irwan Mazlin
        Intent intent = getIntent();

        String parentid = intent.getStringExtra("parentid");
//        Toast.makeText(getApplicationContext(), "Titles: "+parentid, Toast.LENGTH_SHORT).show();
        String sId = databaseReference.push().getKey();





        Users users = new Users (sName,age,pName,school,session, parentid, sId);
        databaseReference.child(sId).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(StudentDetails.this, "Successful add student", Toast.LENGTH_SHORT).show();
                    //openListCourse();
                } else {

                    Toast.makeText(StudentDetails.this, "Add student failed", Toast.LENGTH_SHORT).show();
                }
            }


        });

    }

}


