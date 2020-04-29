package com.example.proyectoappsmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class interfazTextoMuisca extends AppCompatActivity {

    public int numeroDePagina = 1; //Para mostrar el numero de pagina en la parte superior de la aplicación
    public int numeroDeTexto = 0;  //Para saber en que parte del texto va la aplicación
    //Se guardan las imagenes en un arreglo
    public int[] numeroDeImagen = {R.drawable.img1, R.drawable.img2, R.drawable.img3,0, R.drawable.img4, R.drawable.img5, R.drawable.img6, 0,
                                    R.drawable.img2, R.drawable.img8, R.drawable.img9, 0};

    String estoyEn = "";  //Variable para indicar en que tema esta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_textos);

        TextView nroPagina = (TextView) findViewById(R.id.tfNumeroDePagina);
        TextView texto = (TextView) findViewById(R.id.tfTextoMuisca);
        TextView titulo = (TextView) findViewById(R.id.tfTitulo);
        ImageView imagenTextoMuisca = (ImageView) findViewById(R.id.imageTextoMuisca);

        Bundle miBundle = this.getIntent().getExtras();

        String dondeEstoy = "";

        //Accedemos a los textos de cada tema, guardado en Strings
        String[] textoGeografia = getResources().getStringArray(R.array.textoGeografia);
        String[] textoRecorridoSagrado = getResources().getStringArray(R.array.textoRecorridoSagrado);
        String[] textoMitologia = getResources().getStringArray(R.array.textoMitología);
        String[] textoCostumbres = getResources().getStringArray(R.array.textoCostumbres);


        if(miBundle!=null){
            String mensaje = miBundle.getString("resultado");


            dondeEstoy = mensaje;

            if(dondeEstoy.equals("Geografía y politica")) {
                titulo.setText(mensaje.toUpperCase());
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                texto.setText(textoGeografia[numeroDeTexto]);
                estoyEn = "Geografia";
            }

            else if(dondeEstoy.equals("Recorrido Sagrado")) {
                titulo.setText(mensaje.toUpperCase());
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                texto.setText(textoRecorridoSagrado[numeroDeTexto]);
                estoyEn = "Recorrido Sadrado";
            }

            else if(dondeEstoy.equals("Mitología")) {
                titulo.setText(mensaje.toUpperCase());
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                texto.setText(textoMitologia[numeroDeTexto]);
                estoyEn = "Mitologia";
            }
            else if(dondeEstoy.equals("Costumbres")) {
                titulo.setText(mensaje.toUpperCase());
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                texto.setText(textoCostumbres[numeroDeTexto]);
                estoyEn = "Costumbres";
            }
            else if(dondeEstoy.equals("G3") || dondeEstoy.equals("G7") || dondeEstoy.equals("G0")){
                if(dondeEstoy.equals("G0")){
                    Intent finGeografia = new Intent(this, MainActivity.class);
                    startActivity(finGeografia);
                }
                else{
                    titulo.setText("GEOGRAFÍA Y POLITICA");
                    if(dondeEstoy.equals("G3")){
                        numeroDeTexto = 4;
                    }
                    if(dondeEstoy.equals("G7")) {
                        numeroDeTexto = 8;
                    }
                    if(dondeEstoy.equals("G3")){
                        numeroDePagina = numeroDeTexto;
                    }
                    else {
                        numeroDePagina = numeroDeTexto - 1;
                    }
                    nroPagina.setText(numeroDePagina+"/9");
                    imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                    texto.setText(textoGeografia[numeroDeTexto]);
                    estoyEn = "Geografia";
                }
            }
            else if(dondeEstoy.equals("R3") || dondeEstoy.equals("R7") || dondeEstoy.equals("R0")){
                if(dondeEstoy.equals("R0")){
                    Intent finGeografia = new Intent(this, MainActivity.class);
                    startActivity(finGeografia);
                }
                else{
                    titulo.setText("RECORRIDO SAGRADO");
                    if(dondeEstoy.equals("R3")){
                        numeroDeTexto = 4;
                    }
                    if(dondeEstoy.equals("R7")) {
                        numeroDeTexto = 8;
                    }
                    if(dondeEstoy.equals("R3")){
                        numeroDePagina = numeroDeTexto;
                    }
                    else {
                        numeroDePagina = numeroDeTexto - 1;
                    }
                    nroPagina.setText(numeroDePagina+"/9");
                    imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                    texto.setText(textoRecorridoSagrado[numeroDeTexto]);
                    estoyEn = "Recorrido Sadrado";
                }
            }
            else if(dondeEstoy.equals("M3") || dondeEstoy.equals("M7") || dondeEstoy.equals("M0")){
                if(dondeEstoy.equals("M0")){
                    Intent finGeografia = new Intent(this, MainActivity.class);
                    startActivity(finGeografia);
                }
                else{
                    titulo.setText("MITOLOGÍA");
                    if(dondeEstoy.equals("M3")){
                        numeroDeTexto = 4;
                    }
                    if(dondeEstoy.equals("M7")) {
                        numeroDeTexto = 8;
                    }
                    if(dondeEstoy.equals("M3")){
                        numeroDePagina = numeroDeTexto;
                    }
                    else {
                        numeroDePagina = numeroDeTexto - 1;
                    }
                    nroPagina.setText(numeroDePagina+"/9");
                    imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                    texto.setText(textoMitologia[numeroDeTexto]);
                    estoyEn = "Mitologia";
                }
            }
            else if(dondeEstoy.equals("C3") || dondeEstoy.equals("C7") || dondeEstoy.equals("C0")){
                if(dondeEstoy.equals("C0")){
                    Intent finGeografia = new Intent(this, MainActivity.class);
                    startActivity(finGeografia);
                }
                else{
                    titulo.setText("COSTUMBRES");
                    if(dondeEstoy.equals("C3")){
                        numeroDeTexto = 4;
                    }
                    if(dondeEstoy.equals("C7")) {
                        numeroDeTexto = 8;
                    }
                    if(dondeEstoy.equals("C3")){
                        numeroDePagina = numeroDeTexto;
                    }
                    else {
                        numeroDePagina = numeroDeTexto - 1;
                    }
                    nroPagina.setText(numeroDePagina+"/9");
                    imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
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

    //AL PULSAR SIGUIENTE ------------------------------------------------------------------------------------
    public void Siguiente(View view){
        TextView texto2 = (TextView) findViewById(R.id.tfTextoMuisca);
        ImageView imagenTextoMuisca = (ImageView) findViewById(R.id.imageTextoMuisca);
        TextView nroPagina = (TextView) findViewById(R.id.tfNumeroDePagina);

        String[] textoGeografia2 = getResources().getStringArray(R.array.textoGeografia);
        String[] textoRecorridoSagrado2 = getResources().getStringArray(R.array.textoRecorridoSagrado);
        String[] textoMitologia2 = getResources().getStringArray(R.array.textoMitología);
        String[] textoCostumbres2 = getResources().getStringArray(R.array.textoCostumbres);
        Intent intent = new Intent(this, interfaz_preguntas.class);

        numeroDePagina++;
        numeroDeTexto++;

        if(numeroDeTexto < 12) {

            if (estoyEn.equals("Geografia")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
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
                if(numeroDeTexto == 11){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "G0");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
            if (estoyEn.equals("Recorrido Sadrado")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
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
                if(numeroDeTexto == 11){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "R0");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
            if (estoyEn.equals("Mitologia")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
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
                if(numeroDeTexto == 11){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "M0");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
            if (estoyEn.equals("Costumbres")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
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
                if(numeroDeTexto == 11){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "C0");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
        }
        else if(numeroDeTexto > 11){
            Intent siguiente = new Intent(this, MainActivity.class);
            startActivity(siguiente);
        }
    }

    //AL PULSAR ANTERIOR ------------------------------------------------------------------------------------
    public void Anterior(View view){
        TextView texto3 = (TextView) findViewById(R.id.tfTextoMuisca);
        ImageView imagenTextoMuisca = (ImageView) findViewById(R.id.imageTextoMuisca);
        TextView nroPagina = (TextView) findViewById(R.id.tfNumeroDePagina);

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
            numeroDePagina = numeroDePagina-1;
            numeroDeTexto = numeroDeTexto-1;

            if(estoyEn.equals("Geografia")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                texto3.setText(textoGeografia3[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "G3");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "G7");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
            }
            if(estoyEn.equals("Recorrido Sadrado")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                texto3.setText(textoRecorridoSagrado3[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "R3");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "R7");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
            }
            if(estoyEn.equals("Mitologia")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                texto3.setText(textoMitologia3[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "M3");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "M7");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
            }
            if(estoyEn.equals("Costumbres")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagen[numeroDeTexto]);
                texto3.setText(textoCostumbres3[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "C3");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "C7");
                    preguntaAnterioir.putExtras(miBundle);
                    startActivity(preguntaAnterioir);
                }
            }

        }
    }
}
