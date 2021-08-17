package com.example.muazarresources;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeParents extends AppCompatActivity {
    Button addbutton, viewbutton, updatebutton, paymentbutton, logout;
    TextView emaildisplay;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_parents);
//        Intent intent = getIntent();

        //irwan
        mAuth = FirebaseAuth.getInstance();









        Button btnadd = (Button) findViewById(R.id.addbutton);
        Button btnview = (Button) findViewById(R.id.viewbutton);
        Button btnupdate = (Button) findViewById(R.id.updatebutton);
        Button btnpayment = (Button) findViewById(R.id.paymentbutton);
        Button logout = (Button) findViewById(R.id.logout);

        btnadd = findViewById(R.id.addbutton);
        btnview = findViewById(R.id.viewbutton);
        btnupdate = findViewById(R.id.updatebutton);
        btnpayment = findViewById(R.id.paymentbutton);
        logout = findViewById(R.id.logout);

        String email = mAuth.getCurrentUser().getEmail();

        emaildisplay = (TextView) findViewById(R.id.display);

        emaildisplay.setText("welcome " + email);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                retrieveParent();

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent int2 = new Intent(HomeParents.this, OpenPage.class);
                startActivity(int2);
                finishAffinity();
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view();
            }
        });

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

    }

    private void view() {

        mAuth = FirebaseAuth.getInstance();
        String email = mAuth.getCurrentUser().getEmail();
        DatabaseReference mref = FirebaseDatabase.getInstance("https://something-8bbc0-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Parents");
        mref.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists())
                {
                    for(DataSnapshot postsnapshot : snapshot.getChildren())
                    {
                        Parent parents = postsnapshot.getValue(Parent.class);
                        String idparent = parents.getId();
//                        String emailparent = parents.getEmail();

                        Intent int3 = new Intent(HomeParents.this, ViewStudent.class);

                        int3.putExtra("parentid", idparent);

                        startActivity(int3);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    //Irwan Mazlin
    private void retrieveParent() {
        mAuth = FirebaseAuth.getInstance();
        String email = mAuth.getCurrentUser().getEmail();

        DatabaseReference mref = FirebaseDatabase.getInstance("https://something-8bbc0-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Parents");
        mref.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    for(DataSnapshot postSnapshop : snapshot.getChildren())
                    {
                        Parent parents = postSnapshop.getValue(Parent.class);
                        String idparent = parents.getId();
                        String emailparent = parents.getEmail();

//                        Toast.makeText(getApplicationContext(), "Titles: "+emailparent, Toast.LENGTH_SHORT).show();

                        Intent int1 = new Intent(HomeParents.this, StudentDetails.class);
                        int1.putExtra("parentemail", emailparent);
                        int1.putExtra("parentid", idparent);
                        startActivity(int1);
                    }
                }

                Log.e("Information" , String.valueOf(snapshot.getValue()));




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}