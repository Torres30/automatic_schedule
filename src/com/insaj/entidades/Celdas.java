
package com.insaj.entidades;

import java.awt.Color;


public class Celdas {
    private int fila;
    private int columna;
    private String data;
    Docentes docente;

    public Celdas(int fila, int columna, String data, Docentes docente) {
        this.fila = fila;
        this.columna = columna;
        this.data = data;
        this.docente = docente;
    }

    
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Docentes getDocente() {
        return docente;
    }

    public void setDocente(Docentes docente) {
        this.docente = docente;
    }
   
    @Override
    public String toString(){
    return this.getData();
    }
    
}
