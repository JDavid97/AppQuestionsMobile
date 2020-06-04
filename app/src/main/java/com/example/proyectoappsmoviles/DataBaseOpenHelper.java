package com.example.proyectoappsmoviles;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseOpenHelper extends SQLiteOpenHelper {

    public DataBaseOpenHelper(@Nullable Context context) {
        super(context,UtilitiesDataBase.DATABASE_NAME,null, UtilitiesDataBase.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UtilitiesDataBase.TablaPuntaje.CREATE_TABLE_PUNTAJES);

        insert(db,"geografiaypolitica",0);
        insert(db, "recorrido", 0);
        insert(db,"mitologia",0);
        insert(db, "costumbres", 0);
    }

    private void insert(SQLiteDatabase db, String tema, int puntaje){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDataBase.TablaPuntaje.TEMA,tema);
        registro.put(UtilitiesDataBase.TablaPuntaje.PUNTAJE,puntaje);

        db.insert(UtilitiesDataBase.TablaPuntaje.TABLE_NAME,null,registro);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS "+UtilitiesDataBase.TablaPuntaje.TABLE_NAME);
       onCreate(db);
    }
}
