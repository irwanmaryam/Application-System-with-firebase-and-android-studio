package com.example.muazarresources;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class CheckPaymentStatus extends AppCompatActivity {

}
/*
    ListView PaymentList;
    List<Payment> paymentList;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_payment_status);

        PaymentList = findViewById(R.id.PaymentList);
        paymentList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance("https://muazarresources-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Students");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                paymentList.clear();

                for (DataSnapshot studentDatasnap : dataSnapshot.getChildren()){
                    Payment payment = studentDatasnap.getValue(Payment.class);
                    paymentList.add(payment);
                }

                ListAdapter adapter = new ListAdapter(CheckPaymentStatus.this,paymentList);
                PaymentList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        PaymentList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Payment payment = paymentList.get(position);
                showUpdateDialog(payment.getspinnerName(), payment.getspinnerMonth(), payment.getspinnerStatus(),payment.getamount(),payment.getdate());


                return false;
            }

            private void showUpdateDialog(String getspinnerName, String getspinnerMonth, String getspinnerStatus, String getamount, String getdate) {
            }
        });
    }
*/


