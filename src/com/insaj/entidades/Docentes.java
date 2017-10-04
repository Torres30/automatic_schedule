package com.insaj.entidades;
// Generated Apr 19, 2017 9:28:25 PM by Hibernate Tools 4.3.1


import java.awt.Color;
import java.util.HashSet;
import java.util.Set;


public class Docentes  implements java.io.Serializable {


     private Integer idDocente;
     private String nombres;
     private String apellidos;
     private String contrato;
     private Integer numHorasPlanta;
     private Integer numHorasClases;
     private Set<Materias> Materias=new HashSet<Materias>();
     private Set claseses = new HashSet(0);
     private Integer r;
     private Integer g;
     private Integer b;
    public Docentes() {
    }

    public Docentes(String nombres, String apellidos, String contrato, Integer numHorasPlanta, Integer numHorasClases, Integer r, Integer g, Integer b) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contrato = contrato;
        this.numHorasPlanta = numHorasPlanta;
        this.numHorasClases = numHorasClases;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    

    public Docentes(Integer idDocente, String nombres, String apellidos, String contrato, Integer numHorasPlanta, Integer numHorasClases, Integer r, Integer g, Integer b) {
        this.idDocente = idDocente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contrato = contrato;
        this.numHorasPlanta = numHorasPlanta;
        this.numHorasClases = numHorasClases;
        this.r = r;
        this.g = g;
        this.b = b;
    }
   
    public Integer getIdDocente() {
        return this.idDocente;
    }
    
    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getContrato() {
        return this.contrato;
    }
    
    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
    public Integer getNumHorasPlanta() {
        return this.numHorasPlanta;
    }
    
    public void setNumHorasPlanta(Integer numHorasPlanta) {
        this.numHorasPlanta = numHorasPlanta;
    }
    public Integer getNumHorasClases() {
        return this.numHorasClases;
    }
    
    public void setNumHorasClases(Integer numHorasClases) {
        this.numHorasClases = numHorasClases;
    }
    public Set<Materias> getMaterias() {
        return this.Materias;
    }
    
    public void setMaterias(Set<Materias> Materias) {
        this.Materias = Materias;
    }
    public Set getClaseses() {
        return this.claseses;
    }
    
    public void setClaseses(Set claseses) {
        this.claseses = claseses;
    }
     @Override
    public String toString(){
    return this.nombres +" "+ this.getApellidos();
    }

    public Color getColor() {
        return new Color(r, g, b);
    }

    public void setColor(Color color) {
        this.r = color.getRed();
        this.g = color.getGreen();
        this.b = color.getBlue();
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
    


}


