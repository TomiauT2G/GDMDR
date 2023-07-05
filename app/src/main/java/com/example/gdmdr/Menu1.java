package com.example.gdmdr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Menu1 extends AppCompatActivity {

    private List<String> carrito;
    private double precioTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        carrito = new ArrayList<>();
        precioTotal = 0.0;

        Button buttonPasta = findViewById(R.id.buttonPasta);
        Button buttonPizza = findViewById(R.id.buttonPizza);
        Button buttonBurger = findViewById(R.id.buttonBurger);
        Button buttonEnsalada = findViewById(R.id.buttonEnsalada);
        Button buttonVerCarrito =  findViewById(R.id.buttonVerCarrito);

        buttonPasta.setOnClickListener(v -> {
            agregarAlCarrito("Pasta", 3580);
            Toast.makeText(Menu1.this, "Pasta seleccionada", Toast.LENGTH_SHORT).show();
        });

        buttonPizza.setOnClickListener(v -> {
            agregarAlCarrito("Pizza", 8500);
            Toast.makeText(Menu1.this, "Pizza seleccionada", Toast.LENGTH_SHORT).show();
        });

        buttonBurger.setOnClickListener(v -> {
            agregarAlCarrito("Hamburguesa", 4980);
            Toast.makeText(Menu1.this, "Hamburguesa seleccionada", Toast.LENGTH_SHORT).show();
        });

        buttonEnsalada.setOnClickListener(v -> {
            agregarAlCarrito("Ensalada", 1500);
            Toast.makeText(Menu1.this, "Ensalada seleccionada", Toast.LENGTH_SHORT).show();
        });
        buttonVerCarrito.setOnClickListener(v -> {
            Intent intent = new Intent(Menu1.this, CarritoActivity.class);
            intent.putStringArrayListExtra("carrito", new ArrayList<>(carrito));
            intent.putExtra("precioTotal", precioTotal);
            startActivity(intent);
        });
    }

    private void agregarAlCarrito(String nombreItem, double precioItem) {
        carrito.add(nombreItem);
        precioTotal += precioItem;
    }


}


