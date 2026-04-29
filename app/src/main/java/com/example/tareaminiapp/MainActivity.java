package com.example.tareaminiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtN;
    Button btnGenerar;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generarSerie();
            }
        });
    }

    private void generarSerie() {
        String texto = txtN.getText().toString().trim();

        if (texto.isEmpty()) {
            Toast.makeText(this, "Debe ingresar un valor para n", Toast.LENGTH_SHORT).show();
            lblResultado.setText("Error: el campo está vacío.");
            return;
        }

        int n;

        try {
            n = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese solo números", Toast.LENGTH_SHORT).show();
            lblResultado.setText("Error: valor no numérico.");
            return;
        }

        if (n <= 0) {
            Toast.makeText(this, "n debe ser mayor que 0", Toast.LENGTH_SHORT).show();
            lblResultado.setText("Error: n debe ser mayor que 0.");
            return;
        }

        StringBuilder serie = new StringBuilder();
        double suma = 0;

        for (int i = 1; i <= n; i++) {
            double termino = ((i * i) + 1) / 2.0;

            if (i % 2 == 0) {
                termino *= -1;
            }

            suma += termino;
            serie.append(termino);

            if (i < n) {
                serie.append(", ");
            }
        }

        lblResultado.setText("Serie:\n" + serie + "\n\nSumatoria: " + suma);
    }
}