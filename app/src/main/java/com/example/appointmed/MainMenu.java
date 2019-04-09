package com.example.appointmed;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    String strCedula;
    SharedPreferences preferences;

    public static final String extramassage = "com.example.appointmed.MESSAGE";
    View.OnClickListener expedienteHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), Expediente.class);
            intent.putExtra(extramassage,strCedula);

            startActivity(intent);
        }
    };

    View.OnClickListener citaHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), citasHospital.class);
            intent.putExtra(extramassage,strCedula);
            startActivity(intent);

        }
    };

    View.OnClickListener historialHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), HistorialMed.class);
            intent.putExtra(extramassage,strCedula);
            startActivity(intent);

        }
    };

    View.OnClickListener ayudaHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(getBaseContext(), Ayuda.class);
//            startActivity(intent);

        }
    };
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.putString("Cedula",strCedula);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        preferences = getPreferences(Context.MODE_PRIVATE);
        String cedula = preferences.getString("Cedula","");
        if(!cedula.equals("")){
            strCedula=cedula;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent intent = getIntent();
        strCedula = intent.getStringExtra(Login.extramassage);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);


        // Display icon in the toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Button btnExpediente = findViewById(R.id.btnExpediente);
        Button btnCita = findViewById(R.id.btnCita);
        Button btnHistorial = findViewById(R.id.btnHistorial);
        Button btnAyuda = findViewById(R.id.btnAyuda);

        btnExpediente.setOnClickListener(expedienteHandler);
        btnCita.setOnClickListener(citaHandler);
        btnHistorial.setOnClickListener(historialHandler);
        btnAyuda.setOnClickListener(ayudaHandler);

    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
