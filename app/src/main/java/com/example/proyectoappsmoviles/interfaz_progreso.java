package com.example.proyectoappsmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class interfaz_progreso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_progreso);

        TextView textoProgreso = (TextView) findViewById(R.id.tfDescripcionProgreso);

        Bundle miBundle = this.getIntent().getExtras();

        if(miBundle!=null){
            String mensaje = miBundle.getString("resultado");
            textoProgreso.setText(mensaje);
        }
        else {
            textoProgreso.setText("Mensaje vacío");
        }
    }

    public void atras(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
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

