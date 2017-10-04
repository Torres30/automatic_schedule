
package com.insaj.entidades;


public class DiasSemana {
    int dia;
    String nombre;

    public DiasSemana(int dia, String nombre) {
        this.dia = dia;
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString(){
     return this.nombre;
    }
    
}
