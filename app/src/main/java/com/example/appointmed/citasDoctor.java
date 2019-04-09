package com.example.appointmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appointmed.Controlador.DoctorAdapter;
import com.example.appointmed.Modelo.Cita;
import com.example.appointmed.Modelo.Doctor;

import java.util.ArrayList;

public class citasDoctor extends AppCompatActivity {

    String strCedula;
    String strHospital;

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
        Intent intent = getIntent();
        strCedula = intent.getStringExtra(citasHospital.msgCedula);
        strHospital = intent.getStringExtra(citasHospital.msgHospital);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAlt);
        TextView title = findViewById(R.id.toolbar_title);
        title.setText(R.string.citas);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ArrayList doctores = new ArrayList();
        doctores.add(new Doctor("Carlos Mendoza", "Fisiatria"));
        doctores.add(new Doctor("Juan Leon", "Inmunologia"));
        doctores.add(new Doctor("Patricia Guzman", "Neurologia"));
        doctores.add(new Doctor("Melany Alvarado", "Medicina General"));
        DoctorAdapter adapter = new DoctorAdapter(this, doctores);

        Spinner spnHora = findViewById(R.id.spnHora);
        ArrayList horas = new ArrayList();
        horas.add("-----");
        for (int i = 0; i < 25; i++) {
            String time;
            if (i<10)
                time = "0" + i + ":00";
            else
                time = i + ":00";

            horas.add(time);
        }

        ArrayAdapter<String> timeAdapter = new ArrayAdapter(getBaseContext(),android.R.layout.simple_spinner_item, horas);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnHora.setAdapter(timeAdapter);


        final ListView listView = findViewById(R.id.doctorCitaList);
        listView.setAdapter(adapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Doctor doctor = (Doctor)o;

                String doc = doctor.getNomnbre();
                Spinner spnHora = findViewById(R.id.spnHora);
                if (!spnHora.getSelectedItem().toString().equals("-----"))
                {
                    String hora = (String) spnHora.getSelectedItem();
                    EditText txtFecha = findViewById(R.id.edtFecha);
                    String fecha = txtFecha.getText().toString();
                    Cita cita = new Cita(hora, fecha, doc, Integer.parseInt(strCedula));

                    Button Listo = findViewById(R.id.btnSelectDoctor);
                    Listo.setVisibility(View.VISIBLE);

                    Listo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getBaseContext(), MainMenu.class);
                            intent.putExtra(Login.extramassage,strCedula);

                            Toast.makeText(getBaseContext(), "Cita creada con exito", Toast.LENGTH_LONG).show();

                            startActivity(intent);
                        }
                    });

                }
            }
        });

    }

}
