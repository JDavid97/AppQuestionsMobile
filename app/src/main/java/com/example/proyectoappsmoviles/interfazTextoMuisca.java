package com.example.proyectoappsmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class interfazTextoMuisca extends AppCompatActivity {

    public String mensajeRecibido = "";
    public int numeroDeTexto = 0;

    String estoyEn = "";
    //public TextView texto2 = (TextView) findViewById(R.id.tfTextoMuisca);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_textos);

        TextView texto = (TextView) findViewById(R.id.tfTextoMuisca);
        TextView titulo = (TextView) findViewById(R.id.tfTitulo);

        Bundle miBundle = this.getIntent().getExtras();

        String dondeEstoy = "";
        String[] textoGeografia = getResources().getStringArray(R.array.textoGeografia);
        String[] textoRecorridoSagrado = getResources().getStringArray(R.array.textoRecorridoSagrado);
        String[] textoMitologia = getResources().getStringArray(R.array.textoMitología);
        String[] textoCostumbres = getResources().getStringArray(R.array.textoCostumbres);

        if(miBundle!=null){
            String mensaje = miBundle.getString("resultado");


            dondeEstoy = mensaje;

            if(dondeEstoy.equals("Geografía y politica")) {
                titulo.setText(mensaje.toUpperCase());
                texto.setText(textoGeografia[numeroDeTexto]);
                estoyEn = "Geografia";
            }

            else if(dondeEstoy.equals("Recorrido Sagrado")) {
                titulo.setText(mensaje.toUpperCase());
                texto.setText(textoRecorridoSagrado[numeroDeTexto]);
                estoyEn = "Recorrido Sadrado";
            }

            else if(dondeEstoy.equals("Mitología")) {
                titulo.setText(mensaje.toUpperCase());
                texto.setText(textoMitologia[numeroDeTexto]);
                estoyEn = "Mitologia";
            }
            else if(dondeEstoy.equals("Costumbres")) {
                titulo.setText(mensaje.toUpperCase());
                texto.setText(textoCostumbres[numeroDeTexto]);
                estoyEn = "Costumbres";
            }
            else if(dondeEstoy.equals("G3") || dondeEstoy.equals("G7")){
                if(dondeEstoy.equals("G7")){
                    Intent finGeografia = new Intent(this, MainActivity.class);
                    startActivity(finGeografia);
                }
                else{
                    titulo.setText("GEOGRAFÍA Y POLITICA");
                    numeroDeTexto = (Integer.parseInt(""+mensaje.charAt(mensaje.length()-1)) + 1);
                    texto.setText(textoGeografia[numeroDeTexto]);
                    estoyEn = "Geografia";
                }
            }
            else if(dondeEstoy.equals("R3") || dondeEstoy.equals("R7")){
                if(dondeEstoy.equals("R7")){
                    Intent finGeografia = new Intent(this, MainActivity.class);
                    startActivity(finGeografia);
                }
                else{
                    titulo.setText("RECORRIDO SAGRADO");
                    numeroDeTexto = (Integer.parseInt(""+mensaje.charAt(mensaje.length()-1)) + 1);
                    texto.setText(textoRecorridoSagrado[numeroDeTexto]);
                    estoyEn = "Recorrido Sadrado";
                }
            }
            else if(dondeEstoy.equals("M3") || dondeEstoy.equals("M7")){
                if(dondeEstoy.equals("M7")){
                    Intent finGeografia = new Intent(this, MainActivity.class);
                    startActivity(finGeografia);
                }
                else{
                    titulo.setText("MITOLOGÍA");
                    numeroDeTexto = (Integer.parseInt(""+mensaje.charAt(mensaje.length()-1)) + 1);
                    texto.setText(textoMitologia[numeroDeTexto]);
                    estoyEn = "Mitologia";
                }
            }
            else if(dondeEstoy.equals("C3") || dondeEstoy.equals("C7")){
                if(dondeEstoy.equals("C7")){
                    Intent finGeografia = new Intent(this, MainActivity.class);
                    startActivity(finGeografia);
                }
                else{
                    titulo.setText("COSTUMBRES");
                    numeroDeTexto = (Integer.parseInt(""+mensaje.charAt(mensaje.length()-1)) + 1);
                    texto.setText(textoCostumbres[numeroDeTexto]);
                    estoyEn = "Costumbres";
                }
            }
            else{
                texto.setText("no se que mandaron: "+dondeEstoy);
            }
        }
        else {
            texto.setText("Mensaje vacío");
        }
    }

    public void Siguiente(View view){
        TextView texto2 = (TextView) findViewById(R.id.tfTextoMuisca);
        String[] textoGeografia2 = getResources().getStringArray(R.array.textoGeografia);
        String[] textoRecorridoSagrado2 = getResources().getStringArray(R.array.textoRecorridoSagrado);
        String[] textoMitologia2 = getResources().getStringArray(R.array.textoMitología);
        String[] textoCostumbres2 = getResources().getStringArray(R.array.textoCostumbres);
        Intent intent = new Intent(this, interfaz_preguntas.class);
        numeroDeTexto++;


        if(numeroDeTexto < 8) {

            if (estoyEn.equals("Geografia")) {
                texto2.setText(textoGeografia2[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "G3");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "G7");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
            if (estoyEn.equals("Recorrido Sadrado")) {
                texto2.setText(textoRecorridoSagrado2[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "R3");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "R7");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
            if (estoyEn.equals("Mitologia")) {
                texto2.setText(textoMitologia2[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "M3");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "M7");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
            if (estoyEn.equals("Costumbres")) {
                texto2.setText(textoCostumbres2[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "C3");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "C7");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
        }
        else if(numeroDeTexto > 7){
            Intent siguiente = new Intent(this, MainActivity.class);
            startActivity(siguiente);
        }
    }

    public void actualizarTexto(String texto, TextView tfTexto){
        tfTexto.setText(texto);
    }

    public void Anterior(View view){
        TextView texto3 = (TextView) findViewById(R.id.tfTextoMuisca);
        String[] textoGeografia3 = getResources().getStringArray(R.array.textoGeografia);
        String[] textoRecorridoSagrado3 = getResources().getStringArray(R.array.textoRecorridoSagrado);
        String[] textoMitologia3 = getResources().getStringArray(R.array.textoMitología);
        String[] textoCostumbres3 = getResources().getStringArray(R.array.textoCostumbres);

        Intent preguntaAnterioir = new Intent(this, interfaz_preguntas.class);

        if(numeroDeTexto==0) {
            Intent anterior = new Intent(this, MainActivity.class);
            startActivity(anterior);
        }
        else{
            numeroDeTexto = numeroDeTexto-1;
            if(estoyEn.equals("Geografia")) {
                texto3.setText(textoGeografia3[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "G3");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
            }
            if(estoyEn.equals("Recorrido Sadrado")) {
                texto3.setText(textoRecorridoSagrado3[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "R3");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
            }
            if(estoyEn.equals("Mitologia")) {
                texto3.setText(textoMitologia3[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "M3");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
            }
            if(estoyEn.equals("Costumbres")) {
                texto3.setText(textoCostumbres3[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "C3");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
            }

        }
    }
}
