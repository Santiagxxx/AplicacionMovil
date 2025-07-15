package com.example.huertadirecta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InicioActivity extends AppCompatActivity {

    TextView textViewSaludo;
    Button btnProductos, btnCategorias, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String usuario = getIntent().getStringExtra("usuario");

        textViewSaludo = findViewById(R.id.textViewSaludo);
        btnProductos = findViewById(R.id.btnProductos);
        btnCategorias = findViewById(R.id.btnCategorias);
        btnVolver = findViewById(R.id.btnVolvere);

        if (usuario != null && !usuario.isEmpty()) {
            textViewSaludo.setText("Hola, " + usuario);
        }

        btnProductos.setOnClickListener(v -> {
            Intent intent = new Intent(InicioActivity.this, ProductosActivity.class);
            startActivity(intent);
        });

        btnCategorias.setOnClickListener(v -> {
            Intent intent = new Intent(InicioActivity.this, CategoriasActivity.class);
            startActivity(intent);
        });

        btnVolver.setOnClickListener(v -> {

            finish();
        });
    }
}
