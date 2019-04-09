package com.example.appointmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appointmed.Modelo.Historial;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistorialMed extends AppCompatActivity {
    TableLayout tabla;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Citas");
    String strCedula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_med);
        Intent intent = getIntent();
        strCedula = intent.getStringExtra(Login.extramassage);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAlt);
        TextView title = findViewById(R.id.toolbar_title);
        title.setText(R.string.historial);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        tabla = (TableLayout) findViewById(R.id.tabla);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Query q = ref.orderByChild("cedula").equalTo(Integer.parseInt(strCedula));
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<ArrayList<String>> listaValores = new ArrayList<>();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    ArrayList<String> valores = new ArrayList<>();
                    valores.add(dataSnapshot1.child("fecha").getValue().toString());
                    valores.add(dataSnapshot1.child("tipoRegistro").getValue().toString());
                    valores.add(dataSnapshot1.child("descripcion").getValue().toString());
                    valores.add(dataSnapshot1.child("medico").getValue().toString());
                    listaValores.add(valores);
                }
                int rows=listaValores.size();


                  for(int i=0;i<rows;i++) {
                    TableRow tr = new TableRow(HistorialMed.this);
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    TextView fecha = new TextView(HistorialMed.this);
                    fecha.setText(listaValores.get(i).get(0)+"\t\t\t");
                    fecha.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    tr.addView(fecha);
                    TextView tipo = new TextView(HistorialMed.this);
                    tipo.setText(listaValores.get(i).get(1)+"\t\t\t\t\t\t");
                    tipo.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    tr.addView(tipo);
                    TextView descripcion = new TextView(HistorialMed.this);
                    descripcion.setText(listaValores.get(i).get(2)+"\t\t\t\t");
                    descripcion.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    tr.addView(descripcion);
                    TextView medico = new TextView(HistorialMed.this);
                    medico.setText(listaValores.get(i).get(3));
                    medico.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    tr.addView(medico);
                    tabla.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /* Find Tablelayout defined in main.xml */

        /* Create a new row to be added. */



    }
}
