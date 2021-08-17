package com.example.muazarresources;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ViewStudent extends AppCompatActivity {

    ListView StudentList;
    List<Users> usersList;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);



        StudentList = findViewById(R.id.StudentList);
        usersList = new ArrayList<>();

        //irwan mazlin
        Intent intent = getIntent();
        String parentid = intent.getStringExtra("parentid");

        databaseReference = FirebaseDatabase.getInstance("https://something-8bbc0-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Students");

        databaseReference.orderByChild("pId").equalTo(parentid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.e("Information parent id", String.valueOf(dataSnapshot.getValue()));
                usersList.clear();

                for (DataSnapshot studentDatasnap : dataSnapshot.getChildren()){
                    Users users = studentDatasnap.getValue(Users.class);
                    usersList.add(users);
                }

                ListAdapter adapter = new ListAdapter(ViewStudent.this,usersList);
                StudentList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        StudentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


//                Toast.makeText(getApplicationContext(), "Titles: "+parentid, Toast.LENGTH_SHORT).show();
                Users user = usersList.get(position);
                //Irwan Mazlin
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewStudent.this);
                builder.setTitle("Update and Delete")
                .setMessage("Please choose the button update od delete to do the action")
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(ViewStudent.this, UpdateStudent.class);
                        intent.putExtra("studentid", user.getsId());
                        finish();
                        startActivity(intent);

                    }

                })

                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String studentid = String.valueOf(user.getsId());
                        delete(studentid);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();



//                Toast.makeText(getApplicationContext(), "student name : "+user.getsId(), Toast.LENGTH_SHORT).show();


            }
        });//Irwan Mazlin

    }
//Irwan Mazlin
//Delete action
    private void delete(String studentid) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ViewStudent.this);
                builder.setTitle("Delete Item")
                .setMessage("Are you sure want to delete this item?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        DatabaseReference mref = FirebaseDatabase.getInstance("https://something-8bbc0-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Students");
                        mref.orderByChild("sId").equalTo(studentid).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                              for (DataSnapshot postsnapshot : snapshot.getChildren())
                              {
                                  postsnapshot.getRef().removeValue();

                                  Intent i = new Intent(ViewStudent.this, HomeParents.class);
                                  startActivity(i);
                                  finish();
                                  Toast.makeText(getApplicationContext(), "Item Deleted " + studentid, Toast.LENGTH_SHORT).show();
                              }



                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Item is not deleted", Toast.LENGTH_SHORT).show();

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
//Irwan Mazlin





//
//    private void showUpdateDialog(final String id, String sName){
//
//        final AlertDialog.Builder mDialog = new AlertDialog.Builder(this);
//        LayoutInflater inflater = getLayoutInflater();
//        View mDialogView = inflater.inflate(R.layout.activity_update_student, null);
//
//        mDialog.setView(mDialogView);
//
//        final EditText updatesName = mDialogView.findViewById(R.id.updatesName);
//        final EditText updateage = mDialogView.findViewById(R.id.updateage);
//        final EditText updatepName = mDialogView.findViewById(R.id.updatepName);
//        final EditText updateschool = mDialogView.findViewById(R.id.updateschool);
//        final Spinner updatesession = mDialogView.findViewById(R.id.updatesession);
//        Button btnUpdate = mDialogView.findViewById(R.id.update);
//
//        mDialog.setTitle("Updating " + sName + " record");
//        mDialog.show();
//
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String newsName = updatesName.getText().toString();
//                String newage = updateage.getText().toString();
//                String newpName = updatepName.getText().toString();
//                String newschool = updateschool.getText().toString();
//                String newsession = updatesession.getSelectedItem().toString();
//
//                updateData(id, newsName, newage, newpName, newschool, newsession);
//
//                Toast.makeText(ViewStudent.this,"Record updated",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }
//
//    private void updateData (String id, String sName, String age, String pName, String school, String session){
//
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://something-8bbc0-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Students").child(id);
//        Users users = new Users(sName, age, pName, school, session, id);
//        databaseReference.setValue(users);
//    }
}
