package com.example.tres_en_raya;

import android.graphics.Color; // Importa esta clase
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private String player1 = "x";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicialización de los botones
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
    }

    // Método llamado cuando se presiona un botón
    public void presion(View v) {
        Button b = (Button) v;

        // Solo cambia el texto si el botón está vacío
        if (b.getText().toString().equals("")) {
            b.setText(player1);
            cambiarColor(b); // Cambiar color según el jugador
            if (!verificarGanador(player1)) {
                if (verificarEmpate()) {
                    Toast.makeText(this, "¡Empate!", Toast.LENGTH_LONG).show();
                } else {
                    cambiarPlayer();
                }
            }
        }
    }

    // Método para cambiar el color de fondo del botón dependiendo del player
    public void cambiarColor(View v) {
        if (player1.equals("x")) {
            v.setBackgroundColor(Color.parseColor("#779ecb")); // Color para jugador X
        } else {
            v.setBackgroundColor(Color.parseColor("#ff6961")); // Color para jugador O
        }
    }

    // Método para verificar si hay un ganador
    private boolean verificarGanador(String turno) {
        String boton1 = b1.getText().toString();
        String boton2 = b2.getText().toString();
        String boton3 = b3.getText().toString();
        String boton4 = b4.getText().toString();
        String boton5 = b5.getText().toString();
        String boton6 = b6.getText().toString();
        String boton7 = b7.getText().toString();
        String boton8 = b8.getText().toString();
        String boton9 = b9.getText().toString();

        // Comprobaciones para ver si hay tres en raya
        if (boton1.equals(turno) && boton2.equals(turno) && boton3.equals(turno) ||
                boton4.equals(turno) && boton5.equals(turno) && boton6.equals(turno) ||
                boton7.equals(turno) && boton8.equals(turno) && boton9.equals(turno) ||
                boton1.equals(turno) && boton4.equals(turno) && boton7.equals(turno) ||
                boton2.equals(turno) && boton5.equals(turno) && boton8.equals(turno) ||
                boton3.equals(turno) && boton6.equals(turno) && boton9.equals(turno) ||
                boton1.equals(turno) && boton5.equals(turno) && boton9.equals(turno) ||
                boton3.equals(turno) && boton5.equals(turno) && boton7.equals(turno)) {
            gano(turno);
            return true;
        }
        return false; // No hay ganador
    }

    // Método para verificar si hay un empate
    private boolean verificarEmpate() {
        return !b1.getText().toString().equals("") &&
                !b2.getText().toString().equals("") &&
                !b3.getText().toString().equals("") &&
                !b4.getText().toString().equals("") &&
                !b5.getText().toString().equals("") &&
                !b6.getText().toString().equals("") &&
                !b7.getText().toString().equals("") &&
                !b8.getText().toString().equals("") &&
                !b9.getText().toString().equals("");
    }

    // Método llamado cuando un jugador gana
    private void gano(String player1) {
        Toast.makeText(this, "¡¡El jugador " + player1 + " hizo un tres en raya!!", Toast.LENGTH_LONG).show();

        // Deshabilitar todos los botones después de la victoria
        deshabilitarBotones();
    }

    private void deshabilitarBotones() {
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }

    // Método para cambiar el jugador después de cada turno
    private void cambiarPlayer() {
        if (player1.equals("x")) {
            player1 = "o";
        } else {
            player1 = "x";
        }
    }

    public void salir(View v) {
        finish();
    }
}
