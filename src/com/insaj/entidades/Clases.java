package com.insaj.entidades;


import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;


public class Clases  implements java.io.Serializable {


     private Integer idClase;
     private Aulas aulas;
     private Docentes docentes;
     private Horas horas;
     private Secciones secciones;
     private Materias materias;
     private Set<Horarios> Horarios = new HashSet();

    public Clases() {
    }

    public Clases(Secciones secciones, Materias materias) {
        this.secciones = secciones;
        this.materias = materias;
    }

	
    public Clases(Aulas aulas, Docentes docentes, Horas horas, Secciones secciones) {
        this.aulas = aulas;
        this.docentes = docentes;
        this.horas = horas;
        this.secciones = secciones;
    }
    public Clases(Aulas aulas, Docentes docentes, Horas horas, Secciones secciones, Set detallehorarios) {
       this.aulas = aulas;
       this.docentes = docentes;
       this.horas = horas;
       this.secciones = secciones;
       this.Horarios = detallehorarios;
    }
   
    public Integer getIdClase() {
        return this.idClase;
    }
    
    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }
    public Aulas getAulas() {
        return this.aulas;
    }
    
    public void setAulas(Aulas aulas) {
        this.aulas = aulas;
    }
    public Docentes getDocentes() {
        return this.docentes;
    }
    
    public void setDocentes(Docentes docentes) {
        this.docentes = docentes;
    }
    public Horas getHoras() {
        return this.horas;
    }
    
    public void setHoras(Horas horas) {
        this.horas = horas;
    }
    public Secciones getSecciones() {
        return this.secciones;
    }
    
    public void setSecciones(Secciones secciones) {
        this.secciones = secciones;
    }

    public Set<Horarios> getHorarios() {
        return Horarios;
    }

    public void setHorarios(Set<Horarios> Horarios) {
        this.Horarios = Horarios;
    }
    

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }
     
     @Override
    public String toString(){
         
        return this.horas.getDiasToString()+" "+ this.horas.getHora()+" "+ this.horas.getTurno()+" "+ this.idClase+ " "+this.aulas.getNumero() + " "+this.docentes.toString() + " "+this.materias.getNombre() + " "+this.secciones.getSeccion();
    }
    


}


