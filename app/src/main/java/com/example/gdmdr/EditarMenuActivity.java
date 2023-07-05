package com.example.gdmdr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EditarMenuActivity extends AppCompatActivity {

    private EditText editTextPasta;
    private EditText editTextPizza;
    private EditText editTextBurger;
    private EditText editTextEnsalada;
    private Button buttonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_editor);

        editTextPasta = findViewById(R.id.editTextPasta);
        editTextPizza = findViewById(R.id.editTextPizza);
        editTextBurger = findViewById(R.id.editTextBurger);
        editTextEnsalada = findViewById(R.id.editTextEnsalada);
        buttonGuardar = findViewById(R.id.buttonGuardar);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCambios();
            }
        });
    }

    private void guardarCambios() {
        String pasta = editTextPasta.getText().toString().trim();
        String pizza = editTextPizza.getText().toString().trim();
        String burger = editTextBurger.getText().toString().trim();
        String ensalada = editTextEnsalada.getText().toString().trim();

        Toast.makeText(EditarMenuActivity.this, "Cambios guardados", Toast.LENGTH_SHORT).show();
    }
}
