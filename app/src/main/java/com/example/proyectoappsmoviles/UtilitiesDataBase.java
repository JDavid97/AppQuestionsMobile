package com.example.proyectoappsmoviles;

public final class UtilitiesDataBase {
    static final String DATABASE_NAME="hola";
    static final int VERSION=1;

    public class TablaPuntaje{
        static final String TABLE_NAME="puntajes";
        static final String TEMA="tema";
        static final String PUNTAJE="puntaje";

        static final String CREATE_TABLE_PUNTAJES="CREATE TABLE "+TABLE_NAME+"("+TEMA+" TEXT PRIMARY KEY, "
                                                                                +PUNTAJE+" INTEGER)";

        static final String CONSULTAR_ALL_TABLE="SELECT * FROM "+TABLE_NAME;
    }

}
