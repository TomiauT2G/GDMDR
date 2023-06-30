package com.example.gdmdr;

import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu1 extends AppCompatActivity {

    private Button buttonPasta;
    private Button buttonPizza;
    private Button buttonBurger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        buttonPasta = findViewById(R.id.buttonPasta);
        buttonPizza = findViewById(R.id.buttonPizza);
        buttonBurger = findViewById(R.id.buttonBurger);

        buttonPasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Menu1.this, "Pasta seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Menu1.this, "Pizza seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Menu1.this, "Burger seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

    }
}