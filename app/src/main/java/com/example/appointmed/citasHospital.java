package com.example.appointmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appointmed.Modelo.Hospital;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class citasHospital extends AppCompatActivity {
    Spinner spHopitales;
    String strCedula;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Hopitales");
    View.OnClickListener SelectHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), citasDoctor.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_hospital);
        Intent intent = getIntent();
        strCedula = intent.getStringExtra(Login.extramassage);

        Button btnSelect = findViewById(R.id.btnSelectHospital);

        btnSelect.setOnClickListener(SelectHandler);
        spHopitales= (Spinner) findViewById(R.id.spnHospital);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAlt);
        TextView title = findViewById(R.id.toolbar_title);
        title.setText(R.string.citas);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Query q = ref;
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> hospitales= new ArrayList<>();
                String hospital;
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    hospital=dataSnapshot1.child("nombre").getValue().toString();
                    hospitales.add(hospital);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter(getBaseContext(),android.R.layout.simple_spinner_item,hospitales);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spHopitales.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
