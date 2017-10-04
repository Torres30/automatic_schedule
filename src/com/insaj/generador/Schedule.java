
package com.insaj.generador;

import com.insaj.entidades.Aulas;
import java.util.ArrayList;
import com.insaj.entidades.Secciones;
import com.insaj.entidades.Clases;
import com.insaj.entidades.Docentes;
import com.insaj.entidades.Hora_Aula;
import com.insaj.entidades.Horas;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Schedule {
    
    int temp_cont = 0; //borrar temporal
    ArrayList<Clases> classes;
    boolean isFitnessChanged = true;
    double fitness = -1;
    int classNumb=0;
   int numbOfConflicts =0 ;
    Data data;
    public Data getData() {return data;}
    public Schedule(Data data) {
        this.data = data;
        classes = new ArrayList<Clases>(data.getNumberOfClasses());  
    }
    public Schedule initialize(){
        //System.out.println( "inicializando............");
        ArrayList<Hora_Aula> horas_aulas = new ArrayList<>(data.getHora_aula());//data.getHora_aula();
        //  horas_aulas = data.getHora_aula();
        new ArrayList<Secciones>(data.getDepts()).forEach(dept ->{
            dept.getMateriases().forEach(course ->{
                //generando combinaciones horas-aulas
                int hora_aula_index = (int)(horas_aulas.size()*Math.random());//indice del objeto a guardar
                Hora_Aula hora_aula = horas_aulas.get(hora_aula_index);//guarda el objeto
                //termina combinacion
                Clases newClass = new Clases(dept,course);
                // newClass.setHoras(data.getMeetingTimes().get((int)(data.getMeetingTimes().size()*Math.random())));
                // newClass.setAulas(data.getRooms().get((int)(data.getRooms().size()* Math.random())));
                newClass.setHoras(data.getMeetingTimes().get(hora_aula.getIndex_hora()));
                newClass.setAulas(data.getRooms().get(hora_aula.getIndex_aula()));
                newClass.setDocentes(course.getDocentesList().get((int)(course.getDocentes().size()*Math.random())));
                classes.add(newClass); 
                horas_aulas.remove(hora_aula_index);
                //System.out.println( "Numero de horas-aulas: "+horas_aulas.size());
                // System.out.println("Numero de clases ingresadas: "+classes.size());
            });
        });
    
    return this;
} 

    public int getNumbOfConflicts() {
        return numbOfConflicts;
    }

    public double getFitness() {
        if(isFitnessChanged == true){
         fitness = calculateFitness();
         isFitnessChanged = false;
        }
        return fitness;
    }
    public ArrayList<Clases> getClasses(){
        isFitnessChanged = true;
        return classes;
    }
    private double calculateFitness(){
        System.out.println("Calculandoooooo fitness");
        numbOfConflicts = 0;
       //INICIA CODIGO NUEVO
       List<Horas> Horas = data.getMeetingTimes();
       List<Aulas> Aulas = data.getRooms();
       Horas.forEach(h->{
           Aulas.forEach(a->{
            long numero = classes.stream().filter(c->c.getHoras().getIdHora().equals(h.getIdHora()) && c.getAulas().getIdAula().equals(a.getIdAula())).count();
            //JOptionPane.showMessageDialog(null, numero);
            List<Clases> clasesError = classes.stream().filter(c->c.getHoras().getIdHora().equals(h.getIdHora()) && c.getAulas().getIdAula().equals(a.getIdAula())).collect(Collectors.toList());
             //System.out.println("numero de clases en misma hora-aula: "+numero + " Hora: "+h.getIdHora()+" Aula "+a.getIdAula());
             
            if(numero > 1){
              //   JOptionPane.showMessageDialog(null, classes.stream().filter(c->c.getHoras().getIdHora().equals(h.getIdHora()) && c.getAulas().getIdAula().equals(a.getIdAula())).count();
            numbOfConflicts++;
            
            for(int i = 0 ; i<clasesError.size();i++){
                System.out.println("Clases error "+i+": " +clasesError.get(i).toString());
          
            }
            }
           });
          
       });
       //TERMINA CODIGO NUEVO
        
        
        
       /* classes.forEach(xi->{
            //validando horas clases matutinas
            
 //DESCOMENTAR           if(xi.getMaterias().getTipo().equals("BASICA") && !(xi.getHoras().getTurno().equals("AM"))){
 //DESCOMENTAR               numbOfConflicts++;
 //DESCOMENTAR            }
            //TERMINA VALIDAR MATERIAS BASICAS MATUTINAS
            //Descomentar para validar horarios de plazas
           /* if((xi.getDocentes().getContrato().equals("PLAZA")) && !(xi.getHoras().getTurno().equals("AM"))){
                numbOfConflicts++;
               // JOptionPane.showMessageDialog(null, "PLAZA: "+xi.getDocentes().getContrato()+" Y "+xi.getHoras().getTurno() +" CON PM");
            }*/
            //Descomentar linea siguiente para validar los topes de numeros de clases
            //if(getNumofClass(xi.getDocentes())<xi.getDocentes().getNumHorasPlanta())numbOfConflicts++;
            
     /* long clas = classes.stream().filter(y->classes.indexOf(y)>=classes.indexOf(xi)).count();/*.forEach(y->{
 
        if( xi.getHoras().equals(y.getHoras()) && !(xi.equals(y))){
             // JOptionPane.showMessageDialog(null, "Compara hora: "+xi.getHoras().getHora()+" con "+y.getHoras().getHora()+ " y "+xi+" dif "+ y);
            if(xi.getAulas().equals(y.getAulas())){
                numbOfConflicts++;
              //  JOptionPane.showMessageDialog(null, "Compara Aula: "+xi.getAulas().toString()+" con "+y.getAulas().toString());
            }
            if(xi.getDocentes().equals(y.getDocentes())){
                numbOfConflicts++;
             //  JOptionPane.showMessageDialog(null, "Compara Docente: "+xi.getDocentes()+" con "+y.getDocentes());
            }
           
        }
       
        });*/
          
       // });
        return 1/(double)(numbOfConflicts+1);
    }
    public String toString(){
        
    String returnvalue = new String();
        for (int x = 0; x < classes.size()-1; x++) {
            returnvalue+=classes.get(x)+",";
        }
        returnvalue += classes.get(classes.size()-1);
        return returnvalue;
    }
    public int getNumofClass(Docentes doc){
        int numbOfClass=0;
        for (int i = 0; i < classes.size(); i++) {
            if(classes.get(i).getDocentes().equals(doc))
                numbOfClass++;
        }
        return numbOfClass;
    }
}
