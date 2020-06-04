package com.example.proyectoappsmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class interfaz_preguntas extends AppCompatActivity {

    public int id_opciones[] = {R.id.opcion1, R.id.opcion2, R.id.opcion3, R.id.opcion4};

    int correctaPrimeraGeografia = id_opciones[2]; //C Respuesta correcta a la primer pregunta de geografía
    int correctaSegundaGeografia = id_opciones[0]; //A
    int correctaTerceraGeografia = id_opciones[0]; //A
    int correctaPrimeraRecorrido = id_opciones[0]; //A
    int correctaSegundaRecorrido = id_opciones[2]; //C
    int correctaTerceraRecorrido = id_opciones[2]; //C
    int correctaPrimeraMitologia = id_opciones[1]; //B
    int correctaSegundaMitologia = id_opciones[0]; //A
    int correctaTerceraMitologia = id_opciones[2]; //C
    int correctaPrimeraCostumbres = id_opciones[0]; //A
    int correctaSegundaCostumbres = id_opciones[0]; //A
    int correctaTerceraCostumbres = id_opciones[2]; //C

    int puntajeGeografia = 100;

    int puntajeAux = 0;

    ArrayList<Integer> puntajes = new ArrayList<>();

    String mensajeEnviar = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_preguntas);

        Bundle miBundle = this.getIntent().getExtras();

        TextView tfPregunta = (TextView) findViewById(R.id.tfTextoPregunta);

        //Geografia
        //Se guardan las tres preguntas de geografia en una String[]
        String[] preguntasGeografia = getResources().getStringArray(R.array.preguntasGeografia);
        //Se guardan las opciones de respuesta en arreglos
        String[] opcionesPrimerPreguntaGeografia = getResources().getStringArray(R.array.repuestasPrimeraPreguntaGeografia);
        String[] opcionesSegundaPreguntaGeografia = getResources().getStringArray(R.array.repuestasSegundaPreguntaGeografia);
        String[] opcionesTerceraPreguntaGeografia = getResources().getStringArray(R.array.repuestasTerceraPreguntaGeografia);

        //Recorrido Sagrado
        String[] preguntasRecorridoSagrado = getResources().getStringArray(R.array.preguntasRecorridoSagrado);

        String[] opcionesPrimerPreguntaRecorridoSagrado = getResources().getStringArray(R.array.repuestasPrimeraPreguntaRecorridoSagrado);
        String[] opcionesSegundaPreguntaRecorridoSagrado = getResources().getStringArray(R.array.repuestasSegundaPreguntaRecorridoSagrado);
        String[] opcionesTerceraPreguntaRecorridoSagrado = getResources().getStringArray(R.array.repuestasTerceraPreguntaRecorridoSagrado);

        //Mitologia
        String[] preguntasMitologia = getResources().getStringArray(R.array.preguntasMitologia);

        String[] opcionesPrimerPreguntaMitologia = getResources().getStringArray(R.array.repuestasPrimeraPreguntaMitologia);
        String[] opcionesSegundaPreguntaMitologia = getResources().getStringArray(R.array.repuestasSegundaPreguntaMitologia);
        String[] opcionesTerceraPreguntaMitologia = getResources().getStringArray(R.array.repuestasTerceraPreguntaMitologia);

        //Costumbres
        String[] preguntasCostumbres = getResources().getStringArray(R.array.preguntasCostumbres);

        String[] opcionesPrimerPreguntaCostumbres = getResources().getStringArray(R.array.repuestasPrimeraPreguntaCostumbres);
        String[] opcionesSegundaPreguntaCostumbres = getResources().getStringArray(R.array.repuestasSegundaPreguntaCostumbres);
        String[] opcionesTerceraPreguntaCostumbres = getResources().getStringArray(R.array.repuestasTerceraPreguntaCostumbres);

        if (miBundle != null) {
            String mensaje = miBundle.getString("resultado");
            mensajeEnviar = mensaje;
            if(mensaje.contains("G3")){
                tfPregunta.setText(preguntasGeografia[0]);

                for(int i=0; i<opcionesPrimerPreguntaGeografia.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesPrimerPreguntaGeografia[i]);
                }
            }
            if(mensaje.contains("G7")){
                tfPregunta.setText(preguntasGeografia[1]);

                for(int i=0; i<opcionesSegundaPreguntaGeografia.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesSegundaPreguntaGeografia[i]);
                }
            }
            if(mensaje.contains("G0")){
                tfPregunta.setText(preguntasGeografia[2]);

                for(int i=0; i<opcionesTerceraPreguntaGeografia.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesTerceraPreguntaGeografia[i]);
                }
            }
            if(mensaje.contains("R3")){
                tfPregunta.setText(preguntasRecorridoSagrado[0]);

                for(int i=0; i<opcionesPrimerPreguntaRecorridoSagrado.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesPrimerPreguntaRecorridoSagrado[i]);
                }
            }
            if(mensaje.contains("R7")){
                tfPregunta.setText(preguntasRecorridoSagrado[1]);

                for(int i=0; i<opcionesSegundaPreguntaRecorridoSagrado.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesSegundaPreguntaRecorridoSagrado[i]);
                }
            }
            if(mensaje.contains("R0")){
                tfPregunta.setText(preguntasRecorridoSagrado[2]);

                for(int i=0; i<opcionesTerceraPreguntaRecorridoSagrado.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesTerceraPreguntaRecorridoSagrado[i]);
                }
            }
            if(mensaje.contains("M3")){
                tfPregunta.setText(preguntasMitologia[0]);

                for(int i=0; i<opcionesPrimerPreguntaMitologia.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesPrimerPreguntaMitologia[i]);
                }
            }
            if(mensaje.contains("M7")){
                tfPregunta.setText(preguntasMitologia[1]);

                for(int i=0; i<opcionesSegundaPreguntaMitologia.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesSegundaPreguntaMitologia[i]);
                }
            }
            if(mensaje.contains("M0")){
                tfPregunta.setText(preguntasMitologia[2]);

                for(int i=0; i<opcionesTerceraPreguntaMitologia.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesTerceraPreguntaMitologia[i]);
                }
            }
            if(mensaje.contains("C3")){
                tfPregunta.setText(preguntasCostumbres[0]);

                for(int i=0; i<opcionesPrimerPreguntaCostumbres.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesPrimerPreguntaCostumbres[i]);
                }
            }
            if(mensaje.contains("C7")){
                tfPregunta.setText(preguntasCostumbres[1]);

                for(int i=0; i<opcionesSegundaPreguntaCostumbres.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesSegundaPreguntaCostumbres[i]);
                }
            }
            if(mensaje.contains("C0")){
                tfPregunta.setText(preguntasCostumbres[2]);

                for(int i=0; i<opcionesTerceraPreguntaCostumbres.length; i++){
                    RadioButton rb = (RadioButton) findViewById(id_opciones[i]);
                    rb.setText(opcionesTerceraPreguntaCostumbres[i]);
                }
            }
        }
    }

    public void enviarRespuesta(View view){

        RadioGroup rgOpciones = (RadioGroup) findViewById(R.id.radioGroup);
        Bundle miBundle2 = this.getIntent().getExtras();
        String mensaje = miBundle2.getString("resultado");
        //mensajeEnviar = mensaje;
        puntajes.add(0);
        puntajes.add(0);
        puntajes.add(0);
        puntajes.add(0);


        //Si no elige ninguna opción
        if(rgOpciones.getCheckedRadioButtonId() == -1){
            Toast toast1 = Toast.makeText(getApplicationContext(),"Por favor, seleccione una opción", Toast.LENGTH_SHORT);
            toast1.show();
        }

        else{

            int id = rgOpciones.getCheckedRadioButtonId();
            if(mensaje.contains("G3")){

                if(id == correctaPrimeraGeografia) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    System.out.println("asd: "+puntajeGeografia);
                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    puntajeAux++;
                    System.out.println("El puntaje: "+puntajeAux*10);
                    Toast toast3 = Toast.makeText(getApplicationContext(), "-10", Toast.LENGTH_SHORT);
                    toast3.show();
                }
            }
            if(mensaje.contains("G7")){
                System.out.println("PRUEBA1: "+mensaje);
                if(id == correctaSegundaGeografia) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    System.out.println("asd: "+mensajeEnviar+" "+puntajeGeografia);
                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    puntajeAux++;
                    System.out.println("El puntaje: "+puntajeAux*10);
                    Toast toast3 = Toast.makeText(getApplicationContext(), "-10", Toast.LENGTH_SHORT);
                    toast3.show();
                }
            }
            if(mensaje.contains("G0")){
                System.out.println("PRUEBA2: "+mensaje);
                if(id == correctaTerceraGeografia) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();


                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);

                    /*Intent finGeografia = new Intent(this, MainActivity.class);
                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeGeografia);
                    finGeografia.putExtras(miBundle);
                    startActivity(finGeografia);*/
                }
                else{
                    puntajeAux++;
                    System.out.println("El puntaje: "+puntajeAux);
                    Toast toast3 = Toast.makeText(getApplicationContext(), "-10", Toast.LENGTH_SHORT);
                    toast3.show();
                }
            }
            if(mensaje.contains("R3")){
                if(id == correctaPrimeraRecorrido){
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    puntajeAux++;
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT);
                    toast3.show();
                }
            }
            if(mensaje.contains("R7")){
                if(id == correctaSegundaRecorrido) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    puntajeAux++;
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT);
                    toast3.show();
                }
            }
            if(mensaje.contains("R0")){
                if(id == correctaTerceraRecorrido) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    puntajeAux++;
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT);
                    toast3.show();
                }
            }
            if(mensaje.contains("M3")){
                if(id == correctaPrimeraMitologia) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT);
                    toast3.show();
                    puntajeAux++;
                }
            }
            if(mensaje.contains("M7")){
                if(id == correctaSegundaMitologia) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT);
                    toast3.show();
                    puntajeAux++;
                }
            }
            if(mensaje.contains("M0")){
                if(id == correctaTerceraMitologia) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT);
                    toast3.show();
                    puntajeAux++;
                }
            }
            if(mensaje.contains("C3")){
                if(id == correctaPrimeraCostumbres) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT);
                    toast3.show();
                    puntajeAux++;
                }
            }
            if(mensaje.contains("C7")){
                if(id == correctaSegundaCostumbres) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT);
                    toast3.show();
                    puntajeAux++;
                }
            }
            if(mensaje.contains("C0")){
                if(id == correctaTerceraCostumbres) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta correcta", Toast.LENGTH_SHORT);
                    toast2.show();

                    Intent despuesDePregunta = new Intent(this, interfazTextoMuisca.class);

                    Bundle miBundle = new Bundle();
                    miBundle.putString("resultado", mensajeEnviar+puntajeAux);
                    despuesDePregunta.putExtras(miBundle);
                    startActivity(despuesDePregunta);
                }
                else{
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT);
                    toast3.show();
                    puntajeAux++;
                }
            }
        }
    }
}
