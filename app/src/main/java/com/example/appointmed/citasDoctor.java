package com.example.appointmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class citasDoctor extends AppCompatActivity {

    View.OnClickListener SelectHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), MainMenu.class);
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_doctor);

        Button btnSelect = findViewById(R.id.btnSelectDoctor);

        btnSelect.setOnClickListener(SelectHandler);
    }
}