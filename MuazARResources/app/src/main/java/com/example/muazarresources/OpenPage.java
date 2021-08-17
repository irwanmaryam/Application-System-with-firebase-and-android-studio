package com.example.muazarresources;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class OpenPage extends AppCompatActivity {
    private Button bParents, bOwner;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_page);

        bParents = findViewById(R.id.bParents);
        bOwner = findViewById(R.id.bOwner);

        bParents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpenPage.this, LoginParentsActivity.class);
                startActivity(intent);            }
        });

        bOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpenPage.this, LoginOwnerActivity.class);
                startActivity(intent);            }
        });
        
    }
    
}