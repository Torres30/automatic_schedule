package com.insaj.entidades;
// Generated Apr 19, 2017 9:28:25 PM by Hibernate Tools 4.3.1


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Secciones generated by hbm2java
 */
public class Secciones  implements java.io.Serializable {


     private Integer idSeccion;
     private String especialidad;
     private String anio;
     private String seccion;
     //private Set<Materias> Materiases=new HashSet();
     private List<Materias> Materiases=new ArrayList<Materias>();
     private Set claseses = new HashSet(0);

    public Secciones() {
    }

    public Secciones(Integer idSeccion, String especialidad, String anio, String seccion) {
        this.idSeccion = idSeccion;
        this.especialidad = especialidad;
        this.anio = anio;
        this.seccion = seccion;
    }

    public Secciones(String especialidad, String anio, String seccion) {
       this.especialidad = especialidad;
       this.anio = anio;
       this.seccion = seccion;
    }
   
    public Integer getIdSeccion() {
        return this.idSeccion;
    }
    
    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }
    public String getEspecialidad() {
        return this.especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getAnio() {
        return this.anio;
    }
    
    public void setAnio(String anio) {
        this.anio = anio;
    }
    public String getSeccion() {
        return this.seccion;
    }
    
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public List<Materias> getMateriases() {
        return Materiases;
    }

    public void setMateriases(List<Materias> Materiases) {
        this.Materiases = Materiases;
    }
    
    public Set getClaseses() {
        return this.claseses;
    }
    
    public void setClaseses(Set claseses) {
        this.claseses = claseses;
    }

     @Override
    public String toString(){
    return this.getAnio() +" "+ this.getEspecialidad()+" " + this.getSeccion();
    }


}


