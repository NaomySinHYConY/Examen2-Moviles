package com.example.muebleria2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class eliminarNota extends AppCompatActivity {

    Button btnFind, btnEliminar;
    EditText etIdEliminar;
    RecyclerView rvE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_nota);
        btnFind = findViewById(R.id.btnFind);
        btnEliminar = findViewById(R.id.btnEliminar);
        etIdEliminar = findViewById(R.id.etIdEliminar);
        rvE = findViewById(R.id.rvE);
        rvE.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        SQL sql1 = new SQL(getApplicationContext());

        btnFind.setOnClickListener(view -> {

            ArrayList<nota> l = sql1.buscarNotaCompleta(Integer.parseInt(etIdEliminar.getText().toString()));
            if(!l.isEmpty()){
                AdapterData adapter = new AdapterData(l);
                rvE.setAdapter(adapter);
            }
            else{
                Toast.makeText(this, "No existe una nota con ID " + etIdEliminar.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnEliminar.setOnClickListener(view -> {
            boolean delete = sql1.eliminarNotaCompleta(Integer.parseInt(etIdEliminar.getText().toString()));
            if(delete){
                Toast.makeText(this, "La nota con ID " + etIdEliminar.getText().toString() + " ha sido eliminada", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "La nota con ID " + etIdEliminar.getText().toString() + " no pudo ser eliminada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}