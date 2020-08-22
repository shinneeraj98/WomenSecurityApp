package com.example.anand.womensecurity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class policestation extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    Button baddpolstation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policestation);
        et1 = findViewById(R.id.policestationname);
        et2 = findViewById(R.id.lat);
        et3 = findViewById(R.id.lon);
        et4 = findViewById(R.id.policepno);
        baddpolstation = findViewById(R.id.baddpolice);
        baddpolstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = Mydata.savepolicestation(et1.getText().toString(),et2.getText().toString(),et3.getText().toString(),et4.getText().toString());
                Toast.makeText(policestation.this, ""+str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
