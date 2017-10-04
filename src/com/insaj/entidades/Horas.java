package com.insaj.entidades;



import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Horas  implements java.io.Serializable {


     private Integer idHora;
     private String hora;
     private String turno;
     private int dias;
     private Set claseses = new HashSet(0);

    public Horas() {
    }

	
    public Horas(String hora, String turno, int dia) {
        this.hora = hora;
        this.turno = turno;
        this.dias = dia;
    }

    public Horas(Integer idHora, String hora, String turno, int dia) {
        this.idHora = idHora;
        this.hora = hora;
        this.turno = turno;
        this.dias = dia;
    }
   
   
    public Integer getIdHora() {
        return this.idHora;
    }
    
    public void setIdHora(Integer idHora) {
        this.idHora = idHora;
    }
    public String getHora() {
        return this.hora;
    }
    public String getHoraTurno() {
        return this.hora + " "+ this.turno;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getTurno() {
        return this.turno;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public Set getClaseses() {
        return this.claseses;
    }
    
    public void setClaseses(Set claseses) {
        this.claseses = claseses;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dia) {
        this.dias = dia;
    }
    public String getDayofWeek(int num){
     Locale sp =new Locale("es", "ES");
     DayOfWeek dayOfWeek = DayOfWeek.of(num);
     return dayOfWeek.getDisplayName(TextStyle.FULL, sp);
    }
     @Override
     public String toString(){
       return getDayofWeek(getDias());
     }
    public String getDiasToString(){
     return String.valueOf(this.dias);
    }

}


