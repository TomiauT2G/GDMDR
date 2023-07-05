package com.example.gdmdr;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;
import java.util.Collection;
import java.util.Collections;

public class QR extends AppCompatActivity {


    private DecoratedBarcodeView barcodeView;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_qr);



            barcodeView = findViewById(R.id.barcodeScannerView);
            barcodeView.setStatusText("Coloca el código QR dentro del área para escanear");

            barcodeView.decodeContinuous(result -> {
                if (result.getText() != null) {
                    String scannedText = result.getText();
                    // Realiza la acción deseada con el código QR escaneado

                    if (scannedText.equals("hola")) {
                        Intent intent = new Intent(QR.this, Menu1.class);
                        startActivity(intent);
                    }
                }
            });

            Collection<BarcodeFormat> formats = Collections.singletonList(BarcodeFormat.QR_CODE);
            barcodeView.getBarcodeView().setDecoderFactory(new DefaultDecoderFactory(formats));
        }

        @Override
        protected void onResume() {
            super.onResume();
            barcodeView.resume();
        }

        @Override
        protected void onPause() {
            super.onPause();
            barcodeView.pause();
        }
    }

