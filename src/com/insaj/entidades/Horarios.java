package com.insaj.entidades;
// Generated Apr 19, 2017 9:28:25 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;


public class Horarios  implements java.io.Serializable {


     private Integer idHorario;
     private Usuarios usuarios;
     private String anio;
     private Set<Clases> Claseses =new HashSet();

    public Horarios() {
    }

	
    public Horarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public Horarios(Usuarios usuarios, String anio) {
       this.usuarios = usuarios;
       this.anio = anio;
      
    }
   
    public Integer getIdHorario() {
        return this.idHorario;
    }
    
    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public String getAnio() {
        return this.anio;
    }
    
    public void setAnio(String anio) {
        this.anio = anio;
    }
   

    public Set<Clases> getClaseses() {
        return Claseses;
    }

    public void setClaseses(Set<Clases> Claseses) {
        this.Claseses = Claseses;
    }


}


