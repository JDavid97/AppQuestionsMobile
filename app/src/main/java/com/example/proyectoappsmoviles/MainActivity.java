package com.example.proyectoappsmoviles;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public int puntajeGeografia = 0;
    public int puntajeRecorrido = 0;
    public int puntajeMitologia = 0;
    public int puntajeCostumbres = 0;
    ArrayList<Integer> puntajes = new ArrayList<>();



    String cadena = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle miBundle = this.getIntent().getExtras();

        if(miBundle!=null) {
            String mensaje = miBundle.getString("resultado");
            cadena = mensaje;
            /*if(cadena.contains("G0")){
                puntajeGeografia=Integer.parseInt(mensaje.substring(2,cadena.length()));
                puntajes.add(puntajeGeografia);
            }
            if(cadena.contains("R0")){
                puntajeRecorrido=Integer.parseInt(mensaje.substring(2,cadena.length()));
                puntajes.add(puntajeRecorrido);
            }
            if(cadena.contains("M0")){
                puntajeMitologia=Integer.parseInt(mensaje.substring(2,cadena.length()));
                puntajes.add(puntajeMitologia);
            }
            if(cadena.contains("C0")){
                puntajeCostumbres=Integer.parseInt(mensaje.substring(2,cadena.length()));
                puntajes.add(puntajeCostumbres);
            }*/
        }
        else {
            cadena = "no recibi nada";
        }
    }

    public void onclickGeografia(View view){
        Intent intent = new Intent(this, interfazTextoMuisca.class);

        Bundle miBundle = new Bundle();
        miBundle.putString("resultado", "Geografía y politica");
        intent.putExtras(miBundle);
        startActivity(intent);
    }
    public void onclickRecorridoSagrado(View view){
        Intent intent = new Intent(this, interfazTextoMuisca.class);

        Bundle miBundle = new Bundle();
        miBundle.putString("resultado", "Recorrido Sagrado");
        intent.putExtras(miBundle);
        startActivity(intent);
    }
    public void onclickMitologia(View view){
        Intent intent = new Intent(this, interfazTextoMuisca.class);

        Bundle miBundle = new Bundle();
        miBundle.putString("resultado", "Mitología");
        intent.putExtras(miBundle);
        startActivity(intent);
    }
    public void onclickCostumbres(View view){
        Intent intent = new Intent(this, interfazTextoMuisca.class);

        Bundle miBundle = new Bundle();
        miBundle.putString("resultado", "Costumbres");
        intent.putExtras(miBundle);
        startActivity(intent);
    }
    public void onclickProgreso(View view){

        int retenerMensaje = 0;

        if(puntajes.size()>0){
            retenerMensaje = puntajes.get(0);
        }
        String cadena = Integer.toString(retenerMensaje);

        Intent intent = new Intent(this, interfaz_progreso.class);
        float promedio = (puntajeGeografia+puntajeRecorrido+puntajeMitologia+puntajeCostumbres)/4;
        Bundle miBundle2 = new Bundle();
        miBundle2.putString("resultado", "Geografía y politica: "+puntajeGeografia+
                                        "\nRecorrido Sagrado: "+puntajeRecorrido+
                                        "\nMitología: "+puntajeMitologia+
                                        "\nCostumbres: "+puntajeCostumbres+
                                        "\n\nPromedio: "+promedio+
                                        "\nMensaje: "+cadena);
        intent.putExtras(miBundle2);
        startActivity(intent);
    }

    //Cerrar App
    public void cerrarApp(View view) {
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        }
}
