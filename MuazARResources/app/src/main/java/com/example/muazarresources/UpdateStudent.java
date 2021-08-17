package com.example.muazarresources;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateStudent extends AppCompatActivity {

    FirebaseDatabase database;

    private EditText sName, pName, sSchool, sAge;
    Spinner session;

    private Button update, back;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Irwan Mazlin
        setContentView(R.layout.activity_update_student);
        databaseReference = FirebaseDatabase.getInstance("https://something-8bbc0-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Students");

        Intent intent = getIntent();
        String sid = intent.getStringExtra("studentid");


        sName = (EditText) findViewById(R.id.updatesName);
        sSchool = (EditText) findViewById(R.id.updateschool);
        sAge = (EditText) findViewById(R.id.updateage);
        pName = (EditText) findViewById(R.id.updatepName);
        session = (Spinner) findViewById(R.id.updatesession);
        update = (Button) findViewById(R.id.update);
        back = (Button) findViewById(R.id.back);

        Users student = new Users();

        databaseReference.orderByChild("sId").equalTo(sid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot postsnapshot : snapshot.getChildren())
                {
                    Users student = postsnapshot.getValue(Users.class);
                    //Log.e("Information student id", String.valueOf(student.getpName()));
                    sName.setText(String.valueOf(student.getsName()));
                    sSchool.setText(String.valueOf(student.getschool()));
                    sAge.setText(String.valueOf(student.getage()));
                    pName.setText(String.valueOf(student.getpName()));

                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FirebaseDatabase dref = FirebaseDatabase.getInstance("https://something-8bbc0-default-rtdb.asia-southeast1.firebasedatabase.app/");
                            DatabaseReference database = dref.getReference("Students");



                            String Sname = ((EditText) findViewById(R.id.updatesName)).getText().toString();
                            if(!TextUtils.isEmpty(Sname))
                            {
//                    String sName = String.valueOf(student.getsName());
                                String Sage = ((EditText) findViewById(R.id.updateage)).getText().toString();
                                String pName = ((EditText) findViewById(R.id.updatepName)).getText().toString();
                                String School = ((EditText) findViewById(R.id.updateschool)).getText().toString();
                                String session = ((Spinner) findViewById(R.id.updatesession)).getSelectedItem().toString();
                                String pId = String.valueOf(student.getpId());

                                Users student1 = new Users(Sname, Sage, pName, School, session, pId, sid);

                                database.child(sid).setValue(student1);


                            }

                            Intent i = new Intent(UpdateStudent.this, HomeParents.class);
                            Toast.makeText(getApplicationContext(), "Update Succesful", Toast.LENGTH_SHORT).show();

                            startActivity(i);
                            finish();


                        }
                    });


                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UpdateStudent.this, HomeParents.class);
                startActivity(i);
            }
        });
//Irwan Mazlin
    }
}