package com.example.muebleria2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class verNota extends AppCompatActivity {

    Button btnBusca;
    EditText etId;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_nota);

        btnBusca = findViewById(R.id.btnBusca);
        etId = findViewById(R.id.etnId);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        SQL sql1 = new SQL(getApplicationContext());

        btnBusca.setOnClickListener(view -> {
            ArrayList<nota> l = sql1.buscarNotaCompleta(Integer.parseInt(etId.getText().toString()));
            if(!l.isEmpty()){
                AdapterData adapter = new AdapterData(l);
                rv.setAdapter(adapter);
            }
            else{
                Toast.makeText(this, "No existe una nota con ID " + etId.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}