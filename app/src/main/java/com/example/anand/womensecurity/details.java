package com.example.anand.womensecurity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class details extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        et1 = findViewById(R.id.lat);
        et2 = findViewById(R.id.lon);
        b = findViewById(R.id.btn);
        b.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
//        String abc = extras.getString("currentlatitude");
//        String def = extras.getString("currentlongtitude");
//        Toast.makeText(this, def+","+abc, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String str = Mydata.savelatlon(et1.getText().toString(),et2.getText().toString());
        Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();

    }
}
