package com.example.appointmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    View.OnClickListener loginHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), Login.class);
            startActivity(intent);
        }
    };

    View.OnClickListener signupHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), Signup.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btnLoginMain);
        Button btnSignUp = findViewById(R.id.btnSingupMain);

        btnLogin.setOnClickListener(loginHandler);
        btnSignUp.setOnClickListener(signupHandler);
    }
}
