package com.example.anand.womensecurity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText et1, et2, et3, et4, et5;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.fname);
        et2 = (EditText) findViewById(R.id.lname);
        et3 = (EditText) findViewById(R.id.email);
        et4 = (EditText) findViewById(R.id.pass);
        et5 = (EditText) findViewById(R.id.pno);
        b = (Button) findViewById(R.id.bsignup);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String MobilePattern = "[0-9]{10}";
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (et1.getText().toString().isEmpty()) {
            et1.setError("First Name Can't be blank");
        } else if (et2.getText().toString().isEmpty()) {
            et2.setError("Last Name Can't be blank");
        } else if (et3.getText().toString().isEmpty()) {
            et3.setError("E-mail can't be blank");
        } else if (!et3.getText().toString().matches(emailPattern)) {
            et3.setError("Please insert a valid E-mail");
        } else if (et5.getText().toString().length() != 10) {
            et5.setError("Only 10 digit is allowed");
        } else if (!et5.getText().toString().matches(MobilePattern)) {
            et5.setError("Please Insert a Correct Contact Number");


        } else {
            String str = Mydata.signup(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString(), et5.getText().toString());
            if (str.equals("Data Saved")) {
                Toast.makeText(this, "" + str, Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getApplicationContext(), help.class);
                in.putExtra("email", et3.getText().toString());
                startActivity(in);
            }
        }
    }

}
