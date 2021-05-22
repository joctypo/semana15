package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Home01 extends AppCompatActivity {
    FirebaseDatabase db;
    private ListView tareaslist;
    private TareasAdapter adaptadas;
    Button agregar;
    EditText titular,description;
    Tareas tareita;
    private long date;
    private boolean completed;
    private String usern;
    private DatabaseReference datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home01);

        tareaslist = findViewById(R.id.tareaslista);
        agregar = findViewById(R.id.agregar);
        titular = findViewById(R.id.titular);
        description = findViewById(R.id.description);

        usern = getIntent().getExtras().getString("id");

        adaptadas = new TareasAdapter();
        tareaslist.setAdapter(adaptadas);


        db = FirebaseDatabase.getInstance();
        datas = db.getInstance().getReference();

        cargarinfo();


        agregar.setOnClickListener(
                v -> {

                    date = new Date().getTime();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
                    Date dates = new Date();
                    dates.setTime(date);
                    String id = usern;
                    String fechaota = sdf.format(dates);
                    String titulazo = titular.getText().toString();
                    String decriptivo = description.getText().toString();
                    String pendt = "pendiente";
                   // String date = tareita.getDateStr();
                    //String pendt = "pendiente";
                    // Tareas tareitas = new Tareas (a, b,date,pendt);


                    Tareas usuario = new Tareas (fechaota, id, titulazo, decriptivo);
                    datas.child("trabajo").child(titulazo).setValue(usuario);




                    //  db.getReference().child("user").setValue(tareitas).push();

                    titular.setText("");
                    description.setText("");







                }

        );







    }

    private void cargarinfo() {


        DatabaseReference ref = datas.child("trabajo");
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        adaptadas.clear();
                        for (DataSnapshot child: snapshot.getChildren()){

                            Tareas tarea = child.getValue(Tareas.class);
                            adaptadas.addTareas(tarea);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                }


        );


    /*
        datas.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot snapshot) {

                        adaptadas.clear();
                        for(DataSnapshot child : snapshot.getChildren()){
                            //child.child("id").getValue();
                            Tareas tarea = child.getValue(Tareas.class);
                            adaptadas.addTareas(tarea);

                        }

                    }

                    @Override
                    public void onCancelled( DatabaseError error) {

                    }
                }


        );*/


    }
}