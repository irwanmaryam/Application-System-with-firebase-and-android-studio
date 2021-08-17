package com.example.muazarresources;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOUsers {

    private DatabaseReference databaseReference;

    public DAOUsers(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Users.class.getSimpleName());
    }

    public Task<Void> add(Users users){

        return databaseReference.push().setValue(users);
    }
}
