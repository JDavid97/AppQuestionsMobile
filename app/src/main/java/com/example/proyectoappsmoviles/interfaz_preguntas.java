package com.example.proyectoappsmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class interfaz_preguntas extends AppCompatActivity {

    String mensajeEnviar = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_preguntas);

        Bundle miBundle = this.getIntent().getExtras();

        TextView tfPregunta = (TextView) findViewById(R.id.tfTextoPregunta);

        String mensajeRecibido ="";

        if (miBundle != null) {
            String mensaje = miBundle.getString("resultado");
            mensajeEnviar = mensaje;
            if(mensaje.equals("G3") || mensaje.equals("G7")) {
                tfPregunta.setText("Pregunta del tema: Geografía");
            }
            if(mensaje.equals("R3") || mensaje.equals("R7")) {
                tfPregunta.setText("Pregunta del tema: Recorrido Sagrado");
            }
            if(mensaje.equals("M3") || mensaje.equals("M7")) {
                tfPregunta.setText("Pregunta del tema: Mitología");
            }
            if(mensaje.equals("C3") || mensaje.equals("C7")) {
                tfPregunta.setText("Pregunta del tema: Costumbres");
            }
        }
    }

    public void enviarRespuesta(View view){
        Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

        Bundle miBundle = new Bundle();
        miBundle.putString("resultado", mensajeEnviar);
        despuesDePregunta.putExtras(miBundle);
        startActivity(despuesDePregunta);
    }
}
