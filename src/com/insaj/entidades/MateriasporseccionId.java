package com.insaj.entidades;
// Generated Apr 19, 2017 9:28:25 PM by Hibernate Tools 4.3.1



/**
 * MateriasporseccionId generated by hbm2java
 */
public class MateriasporseccionId  implements java.io.Serializable {


     private int idMateria;
     private int idSeccion;

    public MateriasporseccionId() {
    }

    public MateriasporseccionId(int idMateria, int idSeccion) {
       this.idMateria = idMateria;
       this.idSeccion = idSeccion;
    }
   
    public int getIdMateria() {
        return this.idMateria;
    }
    
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
    public int getIdSeccion() {
        return this.idSeccion;
    }
    
    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }




}


