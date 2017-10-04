package com.insaj.entidades;
// Generated Apr 19, 2017 9:28:25 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

public class Aulas  implements java.io.Serializable {


     private Integer idAula;
     private String numero;
     private int capacidad;
     private Set claseses = new HashSet(0);

    public Aulas() {
    }

	
    public Aulas(String numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }

    public Aulas(Integer idAula, String numero, int capacidad) {
        this.idAula = idAula;
        this.numero = numero;
        this.capacidad = capacidad;
    }
    
   
    public Integer getIdAula() {
        return this.idAula;
    }
    
    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public int getCapacidad() {
        return this.capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Set getClaseses() {
        return this.claseses;
    }
    
    public void setClaseses(Set claseses) {
        this.claseses = claseses;
    }
     @Override
  public String toString(){
  return this.idAula + " " + this.numero;
  }



}


