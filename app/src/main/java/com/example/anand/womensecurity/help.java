package com.example.anand.womensecurity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class help extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2,et3,et4,et5;
    Button b;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        et1 = (EditText)findViewById(R.id.et1);

        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        et4 = (EditText)findViewById(R.id.et4);
        et5 = (EditText)findViewById(R.id.et5);
        Bundle b1 = getIntent().getExtras();
        email = b1.getString("email");
        b = (Button)findViewById(R.id.save);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = Mydata.savecontact(et1.getText().toString(),et2.getText().toString(),et3.getText().toString(),et4.getText().toString(),et5.getText().toString(),email);
        Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();
        Intent in = new Intent(getApplicationContext(),MapsActivity.class);
        in.putExtra("email",email);
        startActivity(in);
    }
}

