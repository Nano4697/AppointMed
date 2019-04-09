package com.example.appointmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appointmed.Modelo.*;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {
    EditText nombre,contrasena,correo,cedula;
    Usuario usuario;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Usuarios");
    DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference("Expedientes");
    public static final String extramassage = "com.example.appointmed.MESSAGE";
    View.OnClickListener singupHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), MainMenu.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        View btnBack = findViewById(R.id.btnBackSignup);
        Button btnSignup = findViewById(R.id.btnSingup);
        usuario = new Usuario();
        nombre = (EditText) findViewById(R.id.edtNombre);
        contrasena = (EditText) findViewById(R.id.edtPassword);
        correo = (EditText) findViewById(R.id.edtCorreo);
        cedula = (EditText) findViewById(R.id.edtCedula);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setCedula(Integer.parseInt(cedula.getText().toString()));
                usuario.setContrasena(contrasena.getText().toString());
                usuario.setCorreo(correo.getText().toString());
                usuario.setNombre(nombre.getText().toString());
                Query q = ref2.orderByChild("cedula").equalTo(Integer.parseInt(cedula.getText().toString()));
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.exists()){
                            ref.push().setValue(usuario);
                            Toast.makeText(Signup.this, "Se ha insertado con exito", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getBaseContext(), MainMenu.class);
                            intent.putExtra(extramassage,cedula.getText().toString());
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Signup.this, "No hay expediente registrado esa cedula", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });
    }
}
