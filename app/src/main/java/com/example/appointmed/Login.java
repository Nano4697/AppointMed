package com.example.appointmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class Login extends AppCompatActivity {

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Usuarios");
    EditText emailText,passwordText;
    public static final String extramassage = "com.example.appointmed.MESSAGE";

    View.OnClickListener loginHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), MainMenu.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btnLogin);
        emailText = (EditText) findViewById(R.id.emailText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        View btnBack = findViewById(R.id.btnBackLogin);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void verificar(View view){

        Query q = ref.orderByChild("correo").equalTo(emailText.getText().toString());
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean valido=false;
                String strCedula="";
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    if((passwordText.getText().toString()).equals(dataSnapshot1.child("contrasena").getValue().toString())){
                        valido=true;
                        strCedula=dataSnapshot1.child("cedula").getValue().toString();
                        break;
                    }

                }
                if(valido){
                    Intent intent = new Intent(getBaseContext(), MainMenu.class);
                    intent.putExtra(extramassage,strCedula);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Login.this,"Datos invalidos",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
