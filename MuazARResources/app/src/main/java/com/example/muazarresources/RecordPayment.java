package com.example.muazarresources;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;
import java.util.List;

public class RecordPayment extends AppCompatActivity {
/*
    // creating variables for
    // EditText and buttons.
    private EditText amount, date;
    private Button submit, back;
    Spinner spinnerName, spinnerMonth, spinnerStatus;

    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    Payment payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_payment);

        // below line is used to get the
        // instance of our FIrebase database.

        // below line is used to get reference for our database.
        databaseReference = FirebaseDatabase.getInstance("https://muazarresources-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Payment");

        // initializing our edittext and button
        amount = findViewById(R.id.amount);
        date = findViewById(R.id.date);
        spinnerName = findViewById(R.id.spinnerName);
        spinnerMonth = findViewById(R.id.spinnerMonth);
        spinnerStatus = findViewById(R.id.spinnerStatus);
        submit = findViewById(R.id.submit);
        back = findViewById(R.id.back);


        // initializing our object
        // class variable.





        // adding on click listener for our button.
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount = ((EditText) findViewById(R.id.amount)).getText().toString();
                String date = ((EditText) findViewById(R.id.date)).getText().toString();
                String spinnerName = ((Spinner) findViewById(R.id.spinnerName)).getSelectedItem().toString();
                String spinnerMonth = ((Spinner) findViewById(R.id.spinnerMonth)).getSelectedItem().toString();
                String spinnerStatus = ((Spinner) findViewById(R.id.spinnerStatus)).getSelectedItem().toString();

                // below line is for checking weather the
                // edittext fields are empty or not.
                if (amount.isEmpty() || date.isEmpty() || spinnerName.isEmpty()|| spinnerMonth.isEmpty()|| spinnerStatus.isEmpty()) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(RecordPayment.this, "Please add some data.", Toast.LENGTH_SHORT).show();
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
                Intent int1 = new Intent(RecordPayment.this, HomeOwner.class);
                startActivity(int1);
            }
        });


    }

    private void addDatatoFirebase(){

        String amount = ((EditText) findViewById(R.id.amount)).getText().toString();
        String date = ((EditText) findViewById(R.id.date)).getText().toString();
        String spinnerName = ((Spinner) findViewById(R.id.spinnerName)).getSelectedItem().toString();
        String spinnerMonth = ((Spinner) findViewById(R.id.spinnerMonth)).getSelectedItem().toString();
        String spinnerStatus = ((Spinner) findViewById(R.id.spinnerStatus)).getSelectedItem().toString();



        Payment payment = new Payment (spinnerName,spinnerMonth,spinnerStatus,amount,date);
        databaseReference.push().setValue(payment).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(RecordPayment.this, "Successful record payment", Toast.LENGTH_SHORT).show();
                    //openListCourse();
                } else {

                    Toast.makeText(RecordPayment.this, "Record payment failed", Toast.LENGTH_SHORT).show();
                }
            }


        });

    }
    */

    // creating variables for
    // EditText and buttons.
    private EditText amount, date, Name;
    private Button submit, back;
    Spinner spinnerMonth, spinnerStatus;

    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;
    DatabaseReference spinnerRef;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;
    ArrayList<String>spinnerList;
    ArrayAdapter<String> adapter;

    // creating a variable for
    // our object class
    Payment payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_payment);

        // below line is used to get the
        // instance of our FIrebase database.

        // below line is used to get reference for our database.
        databaseReference = FirebaseDatabase.getInstance("https://muazarresources-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Payment");

        // initializing our edittext and button
        amount = findViewById(R.id.amount);
        date = findViewById(R.id.date);
        Name = findViewById(R.id.Name);
        spinnerMonth = findViewById(R.id.spinnerMonth);
        spinnerStatus = findViewById(R.id.spinnerStatus);
        submit = findViewById(R.id.submit);
        back = findViewById(R.id.back);
        spinnerRef = FirebaseDatabase.getInstance("https://muazarresources-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Students").child("sName");

        spinnerList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(RecordPayment.this, android.R.layout.simple_spinner_dropdown_item,spinnerList);

        // initializing our object
        // class variable.





        // adding on click listener for our button.
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount = ((EditText) findViewById(R.id.amount)).getText().toString();
                String date = ((EditText) findViewById(R.id.date)).getText().toString();
                String Name = ((EditText) findViewById(R.id.Name)).getText().toString();
                String spinnerMonth = ((Spinner) findViewById(R.id.spinnerMonth)).getSelectedItem().toString();
                String spinnerStatus = ((Spinner) findViewById(R.id.spinnerStatus)).getSelectedItem().toString();

                // below line is for checking weather the
                // edittext fields are empty or not.
                if (amount.isEmpty() || date.isEmpty() || Name.isEmpty()|| spinnerMonth.isEmpty()|| spinnerStatus.isEmpty()) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(RecordPayment.this, "Please add some data.", Toast.LENGTH_SHORT).show();
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
                Intent int1 = new Intent(RecordPayment.this, HomeOwner.class);
                startActivity(int1);
            }
        });


    }



    private void addDatatoFirebase(){

        String amount = ((EditText) findViewById(R.id.amount)).getText().toString();
        String date = ((EditText) findViewById(R.id.date)).getText().toString();
        String Name = ((EditText) findViewById(R.id.Name)).getText().toString();
        String spinnerMonth = ((Spinner) findViewById(R.id.spinnerMonth)).getSelectedItem().toString();
        String spinnerStatus = ((Spinner) findViewById(R.id.spinnerStatus)).getSelectedItem().toString();



        Payment payment = new Payment (Name,spinnerMonth,spinnerStatus,amount,date);
        databaseReference.push().setValue(payment).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(RecordPayment.this, "Successful record payment", Toast.LENGTH_SHORT).show();
                    //openListCourse();
                } else {

                    Toast.makeText(RecordPayment.this, "Record payment failed", Toast.LENGTH_SHORT).show();
                }
            }


        });

    }
}


