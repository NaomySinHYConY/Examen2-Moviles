package com.example.muebleria2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class crearActivity extends AppCompatActivity {

    Button btnAgregar, btnRecargar, btnGuardar;
    EditText etNumArticulo, etCantidad;

    String nom, foto, nota;

    RecyclerView rev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnRecargar = findViewById(R.id.btnRecargar);
        //btnRegresar = findViewById(R.id.btnRegresar);
        btnGuardar = findViewById(R.id.btnGuardar);

        etNumArticulo = findViewById(R.id.etNumArticulo);
        etCantidad = findViewById(R.id.etCantidad);

        ArrayList<nota> lista;
        lista = new ArrayList<nota>();

        rev = findViewById(R.id.rev);
        rev.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        SQL sql1 = new SQL(getApplicationContext());
        int total = sql1.notaTotal();

        nom = getIntent().getStringExtra("nom");
        foto = getIntent().getStringExtra("foto");
        nota = getIntent().getStringExtra("nota");

        btnRecargar.setOnClickListener(view -> {
            AdapterData adapter = new AdapterData(lista);
            rev.setAdapter(adapter);
        });

        btnAgregar.setOnClickListener(view -> {
            int idA, cant;
            idA = Integer.parseInt(etNumArticulo.getText().toString());
            cant = Integer.parseInt(etCantidad.getText().toString());

            nota n = sql1.buscarArticulo(idA, cant);
            if(!n.nom.equals("")){
                lista.add(n);
                AdapterData adapter = new AdapterData(lista);
                rev.setAdapter(adapter);
                etNumArticulo.setText("");
                etCantidad.setText("");
            }
            else {
                Toast.makeText(crearActivity.this, "No existe el artículo "+ etNumArticulo.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnGuardar.setOnClickListener(view -> {
            for(int i = 0; i<lista.size(); i++){
                nota n = lista.get(i);
                //System.out.println("nombre: "+ n.nom);
                sql1.insertNota(Integer.parseInt(n.sku), n.marca, n.nom, n.costo, n.foto, n.cantidad, n.total, total);
            }
            Toast.makeText(this, "La nota "+total+" se ha guardado", Toast.LENGTH_SHORT).show();
        });
    }
}