package com.example.muebleria2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class inicioActivity extends AppCompatActivity {

    ImageView img;
    TextView tvUsuario;
    Button btnCrearN, btnConsultarN, btnEliminarN;

    String nom, foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        img = findViewById(R.id.ivUsuario);
        tvUsuario = findViewById(R.id.tvUsuario);
        btnCrearN = findViewById(R.id.btnCrearN);
        btnConsultarN = findViewById(R.id.btnConsultarN);
        btnEliminarN = findViewById(R.id.btnEliminarN);


        //int id = Integer.parseInt(getIntent().getStringExtra("id"));
        nom = getIntent().getStringExtra("nom");
        tvUsuario.setText(nom);
        foto = getIntent().getStringExtra("foto");
        img.setImageResource(Integer.parseInt(foto));

        SQL sql1 = new SQL(getApplicationContext());

        btnCrearN.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), crearActivity.class);
            i.putExtra("nom", nom);
            i.putExtra("foto", foto);

            startActivity(i);
        });

        btnConsultarN.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), verNota.class);
            startActivity(i);
        });

        btnEliminarN.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), eliminarNota.class);
            startActivity(i);
        });
    }
}