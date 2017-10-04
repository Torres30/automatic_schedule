
package com.insaj.generador;

import com.insaj.entidades.Aulas;
import com.insaj.entidades.Clases;
import com.insaj.entidades.Docentes;
import com.insaj.entidades.Hora_Aula;
import com.insaj.entidades.Horas;
import com.insaj.entidades.Materias;
import com.insaj.entidades.Secciones;
import java.util.ArrayList;
import java.util.List;

public class Data {
    List<Aulas> rooms;
    List<Docentes> instructors;
    List<Materias> courses;
    List<Secciones> depts;
    List<Horas> meetingTimes;
    ArrayList<Hora_Aula> hora_aula; //para no repetir las combinaciones
    private int numberOfClasses = 0;
    public Data(){
     Initializate();
    }
    private Data Initializate(){
        //todo en constructor
       
        return this;
    }

    public Data(List<Aulas> rooms, List<Docentes> instructors, List<Materias> courses, List<Secciones> depts, List<Horas> meetingTimes) {
        this.rooms = rooms;
        this.instructors = instructors;
        this.courses = courses;
        this.depts = depts;
        this.meetingTimes = meetingTimes;
        this.hora_aula = new ArrayList<>();
        depts.forEach(x -> numberOfClasses+= x.getClaseses().size());
        for (int i = 0; i < this.rooms.size(); i++) {
            for (int j = 0; j < this.meetingTimes.size(); j++) {
              hora_aula.add(new Hora_Aula(j,i));
                //System.out.println("Imprimiendo hora-aulas: "+ j+" "+i);
            }
        }
    }

    public List<Aulas> getRooms() {
        return rooms;
    }

    public void setRooms(List<Aulas> rooms) {
        this.rooms = rooms;
    }

    public List<Docentes> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Docentes> instructors) {
        this.instructors = instructors;
    }

    public List<Materias> getCourses() {
        return courses;
    }

    public void setCourses(List<Materias> courses) {
        this.courses = courses;
    }

    public List<Secciones> getDepts() {
        return depts;
    }

    public void setDepts(List<Secciones> depts) {
        this.depts = depts;
    }

    public List<Horas> getMeetingTimes() {
        return meetingTimes;
    }

    public void setMeetingTimes(List<Horas> meetingTimes) {
        this.meetingTimes = meetingTimes;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }
    //AGREGADO PARA NO REPETIR COMBINACIONES 29-09-2007
    public ArrayList<Hora_Aula> getHora_aula() {
        return hora_aula;
    }

    public void setHora_aula(ArrayList<Hora_Aula> hora_aula) {
        this.hora_aula = hora_aula;
    }
    
}
