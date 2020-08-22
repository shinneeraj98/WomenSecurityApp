package com.example.anand.womensecurity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText et1, et2;
    Button blgn, btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1 = (EditText) findViewById(R.id.email);
        et2 = (EditText) findViewById(R.id.pass);
        blgn = (Button) findViewById(R.id.btnlgn);
        btn = (Button) findViewById(R.id.btn);
        blgn.setOnClickListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });
    }

    @Override
    public void onClick(View v) {
        String MobilePattern = "[0-9]{10}";
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (et1.getText().toString().isEmpty()) {
            et1.setError("Email Can't be blank");
        } else if (!et1.getText().toString().matches(emailPattern)) {
            et1.setError("Please insert a valid E-mail");
        } else if (et2.getText().toString().isEmpty()) {
            et2.setError("Password Can't be blank");
        } else {
            String str = Mydata.login(et1.getText().toString(), et2.getText().toString());
            // Toast.makeText(this, "Hello"+str, Toast.LENGTH_SHORT).show();
            if (str.equals("admin")) {

                Intent in = new Intent(this, admincontrol.class);
                startActivity(in);
            } else if (str.equals("invalid"))
                Toast.makeText(this, "Email and Password is not match. Please try again!!!", Toast.LENGTH_SHORT).show();
            else {
                Intent in = new Intent(this, MapsActivity.class);
                in.putExtra("email",et1.getText().toString());
                startActivity(in);
            }
        }
    }
}
