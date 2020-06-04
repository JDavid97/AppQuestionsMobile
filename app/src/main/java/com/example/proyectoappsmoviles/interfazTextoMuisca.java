package com.example.proyectoappsmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class interfazTextoMuisca extends AppCompatActivity {

    public int numeroDePagina = 1; //Para mostrar el numero de pagina en la parte superior de la aplicación
    public int numeroDeTexto = 0;  //Para saber en que parte del texto va la aplicación
    //Se guardan las imagenes en un arreglo
    public int[] numeroDeImagenGeografia = {R.drawable.img1, R.drawable.img2, R.drawable.img3,0, R.drawable.img4, R.drawable.img5, R.drawable.img6, 0,
            R.drawable.img2, R.drawable.img8, R.drawable.img9, 0};
    public int[] numeroDeImagenRecorrido = {R.drawable.img10, R.drawable.img11, R.drawable.img12,0, R.drawable.img13, R.drawable.img14, R.drawable.img15, 0,
            R.drawable.img16, R.drawable.img10, R.drawable.img18, 0};
    public int[] numeroDeImagenMitologia = {R.drawable.img19, R.drawable.img20, R.drawable.img21,0, R.drawable.img22, R.drawable.img23, R.drawable.img24, 0,
            R.drawable.img25, R.drawable.img26, R.drawable.img27, 0};
    public int[] numeroDeImagenCostumbres = {R.drawable.img28, R.drawable.img29, R.drawable.img30,0, R.drawable.img31, R.drawable.img32, R.drawable.img33, 0,
            R.drawable.img34, R.drawable.img35, R.drawable.img36, 0};

    int puntajeGeografia = 100;
    int puntajeRecorrido = 100;
    int puntajeMitologia = 100;
    int puntajeCostumbres = 100;

    MainActivity p = new MainActivity();

    int acumuladoG = 0;
    String estoyEn = "";  //Variable para indicar en que tema esta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_textos);

        TextView nroPagina = (TextView) findViewById(R.id.tfNumeroDePagina);
        TextView score = (TextView) findViewById(R.id.tfScore);
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

            if(dondeEstoy.contains("Geografía y politica")) {

                titulo.setText(mensaje.toUpperCase());
                nroPagina.setText(numeroDePagina+"/9");
                score.setText("Puntuación: "+puntajeGeografia);
                imagenTextoMuisca.setImageResource(numeroDeImagenGeografia[numeroDeTexto]);
                texto.setText(textoGeografia[numeroDeTexto]);
                estoyEn = "Geografia";
            }

            else if(dondeEstoy.contains("Recorrido Sagrado")) {
                titulo.setText(mensaje.toUpperCase());
                nroPagina.setText(numeroDePagina+"/9");
                score.setText("Puntuación: "+puntajeRecorrido);
                imagenTextoMuisca.setImageResource(numeroDeImagenRecorrido[numeroDeTexto]);
                texto.setText(textoRecorridoSagrado[numeroDeTexto]);
                estoyEn = "Recorrido Sadrado";
            }

            else if(dondeEstoy.contains("Mitología")) {
                titulo.setText(mensaje.toUpperCase());
                nroPagina.setText(numeroDePagina+"/9");
                score.setText("Puntuación: "+puntajeMitologia);
                imagenTextoMuisca.setImageResource(numeroDeImagenMitologia[numeroDeTexto]);
                texto.setText(textoMitologia[numeroDeTexto]);
                estoyEn = "Mitologia";
            }
            else if(dondeEstoy.contains("Costumbres")) {
                titulo.setText(mensaje.toUpperCase());
                nroPagina.setText(numeroDePagina+"/9");
                score.setText("Puntuación: "+puntajeCostumbres);
                imagenTextoMuisca.setImageResource(numeroDeImagenCostumbres[numeroDeTexto]);
                texto.setText(textoCostumbres[numeroDeTexto]);
                estoyEn = "Costumbres";
            }
            else if(dondeEstoy.contains("G3") || dondeEstoy.contains("G7") || dondeEstoy.contains("G0")){

                acumuladoG = acumuladoG+(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length())));
                if(dondeEstoy.contains("G0")){

                    puntajeGeografia -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                    Intent finGeografia = new Intent(this, MainActivity.class);
                    Bundle miBundle2 = new Bundle();
                    miBundle2.putString("resultado", "G0"+Integer.toString(puntajeGeografia));
                    finGeografia.putExtras(miBundle2);
                    startActivity(finGeografia);
                    Puntaje puntajeTema1 = new Puntaje("geografiaypolitica",puntajeGeografia);
                    PuntajeDAO puntajeDAO = new PuntajeDAO(getBaseContext());
                    puntajeDAO.actualizarPuntaje(puntajeTema1);
                }
                else{
                    titulo.setText("GEOGRAFÍA Y POLITICA");
                    if(dondeEstoy.contains("G3")){
                        System.out.println("g3: "+dondeEstoy);
                        puntajeGeografia -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                        numeroDeTexto = 4;
                    }
                    if(dondeEstoy.contains("G7")) {
                        System.out.println("g7: "+dondeEstoy);
                        puntajeGeografia -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                        //puntajeGeografia = puntajeGeografia-(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                        numeroDeTexto = 8;
                    }
                    if(dondeEstoy.contains("G3")){
                        numeroDePagina = numeroDeTexto;
                    }
                    else {
                        numeroDePagina = numeroDeTexto - 1;
                    }
                    nroPagina.setText(numeroDePagina+"/9");
                    //puntajeGeografia = puntajeGeografia-(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                    // System.out.println("tt2: "+dondeEstoy+" ll: "+dondeEstoy.substring(2,dondeEstoy.length()));
                    score.setText("Puntuación: "+puntajeGeografia);
                    imagenTextoMuisca.setImageResource(numeroDeImagenGeografia[numeroDeTexto]);
                    texto.setText(textoGeografia[numeroDeTexto]);
                    estoyEn = "Geografia";
                }
            }
            else if(dondeEstoy.contains("R3") || dondeEstoy.contains("R7") || dondeEstoy.contains("R0")){

                acumuladoG = acumuladoG+(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length())));
                if(dondeEstoy.contains("R0")){
                    puntajeRecorrido -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                    Intent finRecorrido = new Intent(this, MainActivity.class);
                    Bundle miBundle2 = new Bundle();
                    miBundle2.putString("resultado", "R0"+Integer.toString(puntajeRecorrido));
                    finRecorrido.putExtras(miBundle2);
                    startActivity(finRecorrido);
                }
                else{
                    titulo.setText("RECORRIDO SAGRADO");
                    if(dondeEstoy.contains("R3")){
                        puntajeRecorrido -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                        numeroDeTexto = 4;
                    }
                    if(dondeEstoy.contains("R7")) {
                        puntajeRecorrido -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                        numeroDeTexto = 8;
                    }
                    if(dondeEstoy.contains("R3")){
                        numeroDePagina = numeroDeTexto;
                    }
                    else {
                        numeroDePagina = numeroDeTexto - 1;
                    }
                    nroPagina.setText(numeroDePagina+"/9");
                    score.setText("Puntuación: "+puntajeRecorrido);
                    imagenTextoMuisca.setImageResource(numeroDeImagenRecorrido[numeroDeTexto]);
                    texto.setText(textoRecorridoSagrado[numeroDeTexto]);
                    estoyEn = "Recorrido Sadrado";
                }
            }
            else if(dondeEstoy.contains("M3") || dondeEstoy.contains("M7") || dondeEstoy.contains("M0")){
                acumuladoG = acumuladoG+(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length())));
                if(dondeEstoy.contains("M0")){
                    puntajeMitologia -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                    Intent finRecorrido = new Intent(this, MainActivity.class);
                    Bundle miBundle2 = new Bundle();
                    miBundle2.putString("resultado", "M0"+Integer.toString(puntajeMitologia));
                    finRecorrido.putExtras(miBundle2);
                    startActivity(finRecorrido);
                }
                else{
                    titulo.setText("MITOLOGÍA");
                    if(dondeEstoy.contains("M3")){
                        puntajeMitologia -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                        numeroDeTexto = 4;
                    }
                    if(dondeEstoy.contains("M7")) {
                        puntajeMitologia -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                        numeroDeTexto = 8;
                    }
                    if(dondeEstoy.contains("M3")){
                        numeroDePagina = numeroDeTexto;
                    }
                    else {
                        numeroDePagina = numeroDeTexto - 1;
                    }
                    nroPagina.setText(numeroDePagina+"/9");
                    score.setText("Puntuación: "+puntajeMitologia);
                    imagenTextoMuisca.setImageResource(numeroDeImagenMitologia[numeroDeTexto]);
                    texto.setText(textoMitologia[numeroDeTexto]);
                    estoyEn = "Mitologia";
                }
            }
            else if(dondeEstoy.contains("C3") || dondeEstoy.contains("C7") || dondeEstoy.contains("C0")){
                acumuladoG = acumuladoG+(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length())));
                if(dondeEstoy.contains("C0")){
                    puntajeCostumbres -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                    Intent finRecorrido = new Intent(this, MainActivity.class);
                    Bundle miBundle2 = new Bundle();
                    miBundle2.putString("resultado", "C0"+Integer.toString(puntajeCostumbres));
                    finRecorrido.putExtras(miBundle2);
                    startActivity(finRecorrido);
                }
                else{
                    titulo.setText("COSTUMBRES");
                    if(dondeEstoy.contains("C3")){
                        puntajeCostumbres -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                        numeroDeTexto = 4;
                    }
                    if(dondeEstoy.contains("C7")) {
                        puntajeCostumbres -= sumarDigitos(Integer.parseInt(dondeEstoy.substring(2,dondeEstoy.length()))*10);
                        numeroDeTexto = 8;
                    }
                    if(dondeEstoy.contains("C3")){
                        numeroDePagina = numeroDeTexto;
                    }
                    else {
                        numeroDePagina = numeroDeTexto - 1;
                    }
                    nroPagina.setText(numeroDePagina+"/9");
                    score.setText("Puntuación: "+puntajeCostumbres);
                    imagenTextoMuisca.setImageResource(numeroDeImagenCostumbres[numeroDeTexto]);
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

    public int sumarDigitos(int num){
        int d = Integer.toString(num).length();
        int suma = 0;

        for (int i = 0; i < d; i++) {
            String n = String.valueOf(Integer.toString(num).charAt(i));
            suma+=Integer.parseInt(n);
        }
        return suma*10;
    }

    //AL PULSAR SIGUIENTE ------------------------------------------------------------------------------------
    public void Siguiente(View view){
        TextView texto2 = (TextView) findViewById(R.id.tfTextoMuisca);
        ImageView imagenTextoMuisca = (ImageView) findViewById(R.id.imageTextoMuisca);
        TextView nroPagina = (TextView) findViewById(R.id.tfNumeroDePagina);
        TextView score = (TextView) findViewById(R.id.tfScore);

        String[] textoGeografia2 = getResources().getStringArray(R.array.textoGeografia);
        String[] textoRecorridoSagrado2 = getResources().getStringArray(R.array.textoRecorridoSagrado);
        String[] textoMitologia2 = getResources().getStringArray(R.array.textoMitología);
        String[] textoCostumbres2 = getResources().getStringArray(R.array.textoCostumbres);
        Intent intent = new Intent(this, interfaz_preguntas.class);

        numeroDePagina++;
        numeroDeTexto++;

        if(numeroDeTexto < 12) {

            if (estoyEn.contains("Geografia")) {
                nroPagina.setText(numeroDePagina+"/9");
                score.setText("Puntuación: "+puntajeGeografia);
                imagenTextoMuisca.setImageResource(numeroDeImagenGeografia[numeroDeTexto]);
                texto2.setText(textoGeografia2[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "G3");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "G7"+acumuladoG);
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 11){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "G0"+acumuladoG);
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
            if (estoyEn.contains("Recorrido Sadrado")) {
                score.setText("Puntuación: "+puntajeRecorrido);
                nroPagina.setText(numeroDePagina+"/9");
                System.out.println("numero de imagen: "+numeroDeTexto);
                imagenTextoMuisca.setImageResource(numeroDeImagenRecorrido[numeroDeTexto]);
                texto2.setText(textoRecorridoSagrado2[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "R3");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "R7"+acumuladoG);
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 11){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "R0"+acumuladoG);
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
            if (estoyEn.contains("Mitologia")) {
                nroPagina.setText(numeroDePagina+"/9");
                score.setText("Puntuación: "+puntajeMitologia);
                imagenTextoMuisca.setImageResource(numeroDeImagenMitologia[numeroDeTexto]);
                texto2.setText(textoMitologia2[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "M3");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "M7"+acumuladoG);
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 11){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "M0"+acumuladoG);
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
            }
            if (estoyEn.contains("Costumbres")) {
                nroPagina.setText(numeroDePagina+"/9");
                score.setText("Puntuación: "+puntajeCostumbres);
                imagenTextoMuisca.setImageResource(numeroDeImagenCostumbres[numeroDeTexto]);
                texto2.setText(textoCostumbres2[numeroDeTexto]);
                if(numeroDeTexto == 3){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "C3");
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 7){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "C7"+acumuladoG);
                    intent.putExtras(miBundle);
                    startActivity(intent);
                }
                if(numeroDeTexto == 11){

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", "C0"+acumuladoG);
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

            if(estoyEn.contains("Geografia")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagenGeografia[numeroDeTexto]);
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
            if(estoyEn.contains("Recorrido Sadrado")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagenRecorrido[numeroDeTexto]);
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
            if(estoyEn.contains("Mitologia")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagenMitologia[numeroDeTexto]);
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
            if(estoyEn.contains("Costumbres")) {
                nroPagina.setText(numeroDePagina+"/9");
                imagenTextoMuisca.setImageResource(numeroDeImagenCostumbres[numeroDeTexto]);
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
