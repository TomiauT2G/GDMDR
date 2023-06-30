package com.example.gdmdr;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gdmdr.databinding.ActivityMainBinding;
import com.example.gdmdr.databinding.ActivityQrBinding;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import com.journeyapps.*;
public class QR extends AppCompatActivity {

    ActivityQrBinding binding;
    String M ;

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() == null) {
            Toast.makeText(this, "CANCELADO", Toast.LENGTH_SHORT).show();
        } else {

            String menu = result.getContents().toString();
            if (menu == "A"){
                Intent m = new Intent(QR.this,Menu1.class);
                startActivity(m);

            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQrBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BotonQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escanear();

            }
        });
    }
    public void C( ){

    }

    public void escanear() {
        ScanOptions options = new ScanOptions();
        options.setDesiredBarcodeFormats(ScanOptions.ALL_CODE_TYPES);
        options.setPrompt("ESCANEAR CODIGO");
        options.setCameraId(0);
        options.setOrientationLocked(false);
        options.setBeepEnabled(false);
        options.setBarcodeImageEnabled(false);

        barcodeLauncher.launch(options);
    }
}