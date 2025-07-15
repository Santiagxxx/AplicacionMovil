package com.example.huertadirecta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IniciarSesionActivity extends AppCompatActivity {

    EditText edtUsuario, edtContrasena;
    Button btnIniciarSesion, btnVolverInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_iniciar_sesion);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtUsuario = findViewById(R.id.editTextName);
        edtContrasena = findViewById(R.id.editTextPassword);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnVolverInicio = findViewById(R.id.btnVolverInicio);

        btnIniciarSesion.setOnClickListener(v -> {
            String usuario = edtUsuario.getText().toString().trim();
            String contrasena = edtContrasena.getText().toString().trim();

            if (usuario.isEmpty()) {
                Toast.makeText(IniciarSesionActivity.this, "Por favor ingresa el nombre de usuario", Toast.LENGTH_SHORT).show();
            } else if (contrasena.isEmpty()) {
                Toast.makeText(IniciarSesionActivity.this, "Por favor ingresa la contraseña", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(IniciarSesionActivity.this, "Bienvenido " + usuario, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(IniciarSesionActivity.this, InicioActivity.class);
                i.putExtra("usuario", usuario);
                startActivity(i);
            }
        });

        btnVolverInicio.setOnClickListener(v -> {

            finish();
        });


    }
}