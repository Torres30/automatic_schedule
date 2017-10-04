
package com.insaj.entidades;

import java.io.Serializable;


public class Hora_Aula implements Serializable{
    private int index_hora;
    private int index_aula;

    public Hora_Aula(int index_hora, int index_aula) {
        this.index_hora = index_hora;
        this.index_aula = index_aula;
    }

    public int getIndex_hora() {
        return index_hora;
    }

    public void setIndex_hora(int index_hora) {
        this.index_hora = index_hora;
    }

    public int getIndex_aula() {
        return index_aula;
    }

    public void setIndex_aula(int index_aula) {
        this.index_aula = index_aula;
    }
    
    
}
