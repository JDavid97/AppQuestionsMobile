package com.example.proyectoappsmoviles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public void actualizarPuntaje(Puntaje puntajex){
        String temaU = '"'+puntajex.getTema()+'"';
        db.execSQL("UPDATE puntajes SET puntaje = "+puntajex.getPuntaje() +" WHERE tema = "+temaU+"");
        db.close();
    }

    public int obtenerPuntaje(String tema){
        String[] campos = new String[]{UtilitiesDataBase.TablaPuntaje.PUNTAJE};
        String[] parametros = new String[]{UtilitiesDataBase.TablaPuntaje.TEMA};
        String[] argumentos = new String[]{tema};
        Cursor cursor = db.query(UtilitiesDataBase.TablaPuntaje.TABLE_NAME,campos,parametros[0]+"=?",argumentos,null,null,null);
        cursor.moveToFirst();
        int puntaje = cursor.getInt(0);
        db.close();
        return puntaje;
    }



}
