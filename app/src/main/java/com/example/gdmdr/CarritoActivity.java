package com.example.gdmdr;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.List;

public class CarritoActivity extends AppCompatActivity {

    private List<String> carrito;
    private double precioTotal;

    private TextView textViewCarrito;
    private TextView textViewPrecioTotal;
    private static final int REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE = 1;
    String username = getIntent().getStringExtra("username");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        carrito = getIntent().getStringArrayListExtra("carrito");
        precioTotal = getIntent().getDoubleExtra("precioTotal", 0.0);

        textViewCarrito = findViewById(R.id.textViewCarrito);
        textViewPrecioTotal = findViewById(R.id.textViewPrecioTotal);
        Button Boleta = findViewById(R.id.ButtonBoleta);
        mostrarCarrito();
        mostrarPrecioTotal();
        Boleta.setOnClickListener(v -> verificarPermisoEscritura());
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
        precioTotal = Double.parseDouble(precio);
    }

    @SuppressLint("DefaultLocale")
    private void verificarPermisoEscritura() {
        int permissionResult = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionResult == PackageManager.PERMISSION_GRANTED) {
            //generarBoleta();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //generarBoleta();
            } else {
                Toast.makeText(this, "Permiso de escritura en almacenamiento externo denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }



}
