package com.example.huertadirecta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity1 extends AppCompatActivity {
        Button btnIniciar, btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnIniciar = findViewById(R.id.Iniciar);
        btnSalir = findViewById(R.id.btnSalir);



        btnIniciar.setOnClickListener(v  -> {
            Toast.makeText(MainActivity1.this, "Redirigiendo a inicio de sesión...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity1.this, IniciarSesionActivity.class);
            startActivity(i);
        });

        btnSalir.setOnClickListener(v -> {

            finish();
        });


    }
}