package com.example.proyectoappsmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Intent intent = new Intent(this, interfaz_progreso.class);

        Bundle miBundle = new Bundle();
        miBundle.putString("resultado", "Progreso");
        intent.putExtras(miBundle);
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
