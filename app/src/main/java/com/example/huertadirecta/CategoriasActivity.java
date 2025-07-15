package com.example.huertadirecta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CategoriasActivity extends AppCompatActivity {

    Spinner spinner;
    Button btnVolver;
    ImageView imagenCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        spinner = findViewById(R.id.spinner);
        btnVolver = findViewById(R.id.button);
        imagenCategoria = findViewById(R.id.imagenCategoria);


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

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = parent.getItemAtPosition(position).toString();

                switch (seleccion) {
                    case "Frutas":
                        imagenCategoria.setImageResource(R.drawable.frutas);
                        imagenCategoria.setVisibility(View.VISIBLE);
                        break;
                    case "Verduras":
                        imagenCategoria.setImageResource(R.drawable.verduras);
                        imagenCategoria.setVisibility(View.VISIBLE);
                        break;
                    case "Tubérculos":
                        imagenCategoria.setImageResource(R.drawable.tuberculos);
                        imagenCategoria.setVisibility(View.VISIBLE);
                        break;
                    case "Aromáticas":
                        imagenCategoria.setImageResource(R.drawable.aromaticas);
                        imagenCategoria.setVisibility(View.VISIBLE);
                        break;
                    default:
                        imagenCategoria.setVisibility(View.INVISIBLE);
                        break;
                }

                if (!seleccion.equals("Selecciona una categoría")) {
                    Toast.makeText(CategoriasActivity.this, "Seleccionaste: " + seleccion, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                imagenCategoria.setVisibility(View.INVISIBLE);
            }
        });

        // Listener del botón VOLVER
        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(CategoriasActivity.this, InicioActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
