package com.example.muebleria2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etUsuario);
        pass = findViewById(R.id.etPass);
        btnAceptar = findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQL sql = new SQL(getApplicationContext());
                usuario u = sql.validar(user.getText().toString(), pass.getText().toString());
                if(u.user.equals("")){
                    user.setText("");
                    pass.setText("");
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(getApplicationContext(), inicioActivity.class);
                    i.putExtra("id", u.id + "");
                    i.putExtra("nom", u.user);
                    i.putExtra("foto", u.foto + "");

                    startActivity(i);
                }
            }
        });
    }
}