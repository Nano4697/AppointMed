package com.example.appointmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Expediente extends AppCompatActivity {
    String strCedula;
    TextView txtNombre,txtDireccion,txtTelefono,txtCelular,txtTipoSangre,txtAlergias,txtNombreContacto,txtTelefonoContacto;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Expedientes");
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expediente);
        Intent intent = getIntent();
        strCedula = intent.getStringExtra(Login.extramassage);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAlt);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        txtNombre = (TextView)  findViewById(R.id.textNameExp);
        txtDireccion = (TextView)  findViewById(R.id.textAddrExp);
        txtAlergias = (TextView)  findViewById(R.id.textAlergiasExp);
        txtCelular = (TextView)  findViewById(R.id.textCelExp);
        txtTelefono= (TextView)  findViewById(R.id.textTelExp);
        txtNombreContacto = (TextView)  findViewById(R.id.textNameContactExp);
        txtTelefonoContacto = (TextView)  findViewById(R.id.textTelContactExp);
        txtTipoSangre = (TextView)  findViewById(R.id.textBloodExp);

        TextView title = findViewById(R.id.toolbar_title);
        title.setText(R.string.expediente);
        Query q = ref.orderByChild("cedula").equalTo(Integer.parseInt(strCedula));
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String strNombre="";
                String strDireccion="";
                String strTelefono="";
                String strCelular="";
                String strTipoSangre="";
                String strAlergias="";
                String strNombreContacto="";
                String strTelefonoContacto="";

                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    strNombre=dataSnapshot1.child("nombre").getValue().toString();
                    strDireccion=dataSnapshot1.child("direccion").getValue().toString();
                    strTelefono=dataSnapshot1.child("telefono").getValue().toString();
                    strCelular=dataSnapshot1.child("celular").getValue().toString();
                    strTipoSangre=dataSnapshot1.child("tipoSangre").getValue().toString();
                    strAlergias=dataSnapshot1.child("alergias").getValue().toString();
                    strNombreContacto=dataSnapshot1.child("nombreContacto").getValue().toString();
                    strTelefonoContacto=dataSnapshot1.child("telefonoContacto").getValue().toString();
                }

                txtNombre.setText(strNombre);
                txtDireccion.setText(strDireccion);
                txtTelefono.setText(strTelefono);
                txtCelular.setText(strCelular);
                txtTipoSangre.setText(strTipoSangre);
                txtAlergias.setText(strAlergias);
                txtNombreContacto.setText(strNombreContacto);
                txtTelefonoContacto.setText(strTelefonoContacto);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
