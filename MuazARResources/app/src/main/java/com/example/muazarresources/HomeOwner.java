package com.example.muazarresources;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.tasks.OnCompleteListener;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeOwner extends AppCompatActivity {
    private Button vStudent, rPayment, btnlogout, remind, check;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_owner);


        Button vStudent = (Button) findViewById(R.id.vStudent);
        Button rPayment = (Button) findViewById(R.id.rPayment);
        Button btnlogout = (Button) findViewById(R.id.btnlogout);
        Button remind = (Button) findViewById(R.id.remind);
        Button check = (Button) findViewById(R.id.check);


        vStudent = findViewById(R.id.vStudent);
        rPayment = findViewById(R.id.rPayment);
        btnlogout = findViewById(R.id.btnlogout);
        remind = findViewById(R.id.remind);
        check = findViewById(R.id.check);


        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent int1 = new Intent(HomeOwner.this, OpenPage.class);
                startActivity(int1);
                finishAffinity();
            }

        });

        vStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(HomeOwner.this, ViewStudent.class);
                startActivity(int3);
            }
        });

        rPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent(HomeOwner.this, RecordPayment.class);
                startActivity(int4);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5 = new Intent(HomeOwner.this, CheckPaymentStatus.class);
                startActivity(int5);
            }
        });

        if(VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        remind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(HomeOwner.this,"My Notification");
                builder.setContentTitle("Muaz AR Resources");
                builder.setContentText("Do not forget to pay the school bus fees :)");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(HomeOwner.this);
                managerCompat.notify(1, builder.build());
            }
        });

    }
    public void openStudentDetails() {
                Intent intent= new Intent(this, HomeOwner.class);
                startActivity(intent);
    }




}




