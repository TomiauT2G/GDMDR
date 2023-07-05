package com.example.gdmdr;

import android.annotation.SuppressLint;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class CarritoActivity extends AppCompatActivity {

    private List<String> carrito;
    private double precioTotal;

    private TextView textViewCarrito;
    private TextView textViewPrecioTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        carrito = getIntent().getStringArrayListExtra("carrito");
        precioTotal = getIntent().getDoubleExtra("precioTotal", 0.0);

        textViewCarrito = findViewById(R.id.textViewCarrito);
        textViewPrecioTotal = findViewById(R.id.textViewPrecioTotal);

        mostrarCarrito();
        mostrarPrecioTotal();
    }

    private void mostrarCarrito() {
        StringBuilder sb = new StringBuilder();
        for (String item : carrito) {
            sb.append(item).append("\n");
        }
        textViewCarrito.setText(sb.toString());
    }

    @SuppressLint("SetTextI18n")
    private void mostrarPrecioTotal() {
        @SuppressLint("DefaultLocale") String precio = String.format("%.2f", precioTotal);
        textViewPrecioTotal.setText("Precio Total: $" + precio);
    }
}


