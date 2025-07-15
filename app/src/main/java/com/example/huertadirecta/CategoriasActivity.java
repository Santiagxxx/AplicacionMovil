package com.example.huertadirecta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CategoriasActivity extends AppCompatActivity {

    Spinner spinner;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        spinner = findViewById(R.id.spinner);
        btnVolver = findViewById(R.id.button);


        String[] categorias = {"Selecciona una categoría", "Frutas", "Verduras", "Tubérculos", "Aromáticas"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = parent.getItemAtPosition(position).toString();
                if (position != 0) { // Para evitar el primer ítem "Selecciona una categoría"
                    Toast.makeText(CategoriasActivity.this, "Seleccionaste: " + seleccion, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nada seleccionado
            }
        });

        // Listener del botón VOLVER
        btnVolver.setOnClickListener(v -> {
            // Finaliza esta actividad y regresa a la anterior
            finish();
        });
    }
}
