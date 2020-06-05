package com.example.proyectoappsmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public int puntajeGeografia = 100;
    public int puntajeRecorrido = 100;
    public int puntajeMitologia = 100;
    public int puntajeCostumbres = 100;
    ArrayList<Integer> puntajes = new ArrayList<>();

    public String mensaje;


    String cadena = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle miBundle = this.getIntent().getExtras();

        if(miBundle!=null) {
            mensaje = miBundle.getString("resultado");

            //generado = savedInstanceState.getString("generado");
            //cadena = mensaje;
            if(mensaje.contains("G0")){
                System.out.println("YEAAHHHHHH "+ mensaje.substring(2,mensaje.length()));
                puntajeGeografia=Integer.parseInt(mensaje.substring(2,mensaje.length()));
                puntajes.add(puntajeGeografia);
            }
            if(mensaje.contains("R0")){
                puntajeRecorrido=Integer.parseInt(mensaje.substring(2,mensaje.length()));
                puntajes.add(puntajeRecorrido);
            }
            if(mensaje.contains("M0")){
                puntajeMitologia=Integer.parseInt(mensaje.substring(2,mensaje.length()));
                puntajes.add(puntajeMitologia);
            }
            if(mensaje.contains("C0")){
                puntajeCostumbres=Integer.parseInt(mensaje.substring(2,mensaje.length()));
                puntajes.add(puntajeCostumbres);
            }
        }
        else {
            mensaje = "no recibi nada";
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("resultado", mensaje);
        super.onSaveInstanceState(outState);
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

        PuntajeDAO puntajeDAO = new PuntajeDAO(getApplicationContext());
        int puntajeT1 = puntajeDAO.obtenerPuntaje("geografiaypolitica");
        PuntajeDAO puntajeDAO2 = new PuntajeDAO(getApplicationContext());
        int puntajeT2 = puntajeDAO2.obtenerPuntaje("recorrido");
        PuntajeDAO puntajeDAO3 = new PuntajeDAO(getApplicationContext());
        int puntajeT3 = puntajeDAO3.obtenerPuntaje("mitologia");
        PuntajeDAO puntajeDAO4 = new PuntajeDAO(getApplicationContext());
        int puntajeT4 = puntajeDAO4.obtenerPuntaje("costumbres");
        int retenerMensaje = 0;

        if(puntajes.size()>0){
            retenerMensaje = puntajes.get(0);
        }
        //String cadena = Integer.toString(retenerMensaje);

        Intent intent = new Intent(this, interfaz_progreso.class);
        float promedio = (puntajeT1+puntajeT2+puntajeT3+puntajeT4)/4;
        Bundle miBundle2 = new Bundle();
        miBundle2.putString("resultado", "Geografía y politica: "+puntajeT1+
                "\nRecorrido Sagrado: "+puntajeT2+
                "\nMitología: "+puntajeT3+
                "\nCostumbres: "+puntajeT4+
                "\n\nPromedio: "+promedio);
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
