package com.example.gdmdr;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gdmdr.databinding.ActivityQrBinding;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class QR extends AppCompatActivity {

    ActivityQrBinding binding;
    String M ;



        private DecoratedBarcodeView barcodeView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_qr);

            barcodeView = findViewById(R.id.barcodeScannerView);
            barcodeView.setStatusText("Coloca el código QR dentro del área para escanear");

            barcodeView.decodeContinuous(new BarcodeCallback() {
                @Override
                public void barcodeResult(BarcodeResult result) {
                    if (result.getText() != null) {
                        String scannedText = result.getText();
                        // Realiza la acción deseada con el código QR escaneado

                        if (scannedText.equals("A")) {
                            Intent intent = new Intent(QR.this, Menu1.class);
                            startActivity(intent);
                        }
                    }
                }

                @Override
                public void possibleResultPoints(List<ResultPoint> resultPoints) {
                    // No se necesita implementar en este caso
                }
            });

            // Configura los formatos de códigos de barras que se deben escanear
            Collection<BarcodeFormat> formats = Arrays.asList(BarcodeFormat.QR_CODE);
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

