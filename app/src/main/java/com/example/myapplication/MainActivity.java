package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    private FirebaseDatabase db;
    Button login;
    EditText username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();

        login = findViewById(R.id.login);
        username = findViewById(R.id.username);

        login.setOnClickListener(
                (v)->{
                    String usern = username.getText().toString().trim().toLowerCase();
                    if (usern.isEmpty()){

                        Toast.makeText(this, "Esta vacío rellenar", Toast.LENGTH_LONG).show();

                    } else {

                        Intent i = new Intent(this, Home01.class);
                        i.putExtra("id", usern);
                        startActivity(i);
                        //finish();

                    }


                }
        );

    }






}