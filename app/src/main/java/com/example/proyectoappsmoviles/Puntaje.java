package com.example.proyectoappsmoviles;

public class Puntaje {
    private String tema;
    private int puntaje;

    public Puntaje(String tema, int puntaje) {
        this.tema = tema;
        this.puntaje = puntaje;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
