package com.example.proyectoappsmoviles;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class PuntajeDAO {
    private DataBaseOpenHelper dataBaseOpenHelper;
    private SQLiteDatabase db;

    public PuntajeDAO(Context context){
        dataBaseOpenHelper = new DataBaseOpenHelper(context);
        db = dataBaseOpenHelper.getWritableDatabase();
    }

    public void insertarPuntaje(Puntaje puntaje){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDataBase.TablaPuntaje.TEMA,puntaje.getTema());
        registro.put(UtilitiesDataBase.TablaPuntaje.PUNTAJE,puntaje.getPuntaje());
        db.close();
    }

    public void actualizarPuntaje(Puntaje puntaje){
        db.execSQL("UPDATE puntajes SET Puntaje="+puntaje.getPuntaje()+" WHERE tema="+puntaje.getTema());;
        db.close();
    }



}
