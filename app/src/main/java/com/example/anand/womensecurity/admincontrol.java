package com.example.anand.womensecurity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admincontrol extends AppCompatActivity {

    Button btnaddpolice,btnaddangerlocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admincontrol);
        btnaddpolice = findViewById(R.id.baddpolice);
        btnaddangerlocation = findViewById(R.id.baddangerlocation);
        btnaddangerlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(admincontrol.this,details.class);
                startActivity(in);
            }
        });
        btnaddpolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(admincontrol.this,policestation.class);
                startActivity(in);
            }
        });
    }
}
