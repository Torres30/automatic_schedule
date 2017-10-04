/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.generador;

import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class Driver {
    public static final int POPULATION_SIZE = 9; 
    public static final double  MUTATION_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMB_OF_ELITE_SCHEDULES = 1;
    private Data data;
    private int classNumb= 1;
    private int scheduleNumb=0;
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.data = new Data(); 
        driver.printAvailableData();
        int generatioNumber = 0;
        System.out.println("> gneration # "+generatioNumber);
        System.out.print("Schedules # |                                         ");
        System.out.print("Classes [dept,class,room,instructor,mettime]    ");
        System.out.println("                                    | fitness | conflicts");
         System.out.print("----------------------------main------------------------------------------");
        System.out.println("----------------------------main------------------------------------------");
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
        Population population = new Population(driver.POPULATION_SIZE, driver.data).sortByFitness();
        population.getSchedules().forEach(Schedule -> System.out.println("             "+driver.scheduleNumb++ +
                "        |  "+Schedule + " | "+
                String.format("%.5f", Schedule.getFitness())+
                " | "+Schedule.getNumbOfConflicts()));
        
        driver.printScheduleAsTable(population.getSchedules().get(0), generatioNumber);
        driver.classNumb = 1;
        while (population.getSchedules().get(0).getFitness() !=1.0) {
            System.out.println(">Generation # "+ ++generatioNumber);
            System.out.print(" Schedule  #  |                                          ");
            System.out.print(" Classes [dep,class,room,instructor,meeting-time]        ");
            System.out.println("                                  | Fitness | conflicts");
            System.out.print("---------------------------------------------------astable-------------------");
            System.out.println("--------------------------------------------------asctable--------------------");
            population = geneticAlgorithm.evolve(population).sortByFitness();
            driver.scheduleNumb = 0;
            population.getSchedules().forEach(schedule -> System.out.println("          "+driver.scheduleNumb++ +
                                                                             "     | " + schedule + " | "+
                                                                             String.format("%.5f", schedule.getFitness())+
                                                                             " | " + schedule.getNumbOfConflicts()));
            driver.printScheduleAsTable(population.getSchedules().get(0), generatioNumber);
            driver.classNumb = 1;
        }
    }
    private void printScheduleAsTable(Schedule schedule, int generation){
      /*  ArrayList<Class> classes = schedule.getClasses();
        System.out.print("\n                         ");
        System.out.println("Class #  | Dept  | Course (Number, max # of students) | RoomCap  | Instructor | Meetingtime ");
        System.out.print("                       ");
        System.out.print("------------------------------------");
        System.out.println("----------------------------------------");
        classes.forEach(x->{
        int majorIndex = data.getDepts().indexOf(x.getDept());
        int coursesIndex = data.getCourses().indexOf(x.getCourse());
        int roomindex = data.getRooms().indexOf(x.getRoom());
        int instrctorIndex = data.getInstructors().indexOf(x.getInstructor());
        int meetingTimeIndex = data.getMeetingTimes().indexOf(x.getMeetingTime());
            System.out.print("                        ");
            System.out.print(String.format(" %1$02d ", classNumb)+ "   |   ");
            System.out.print(String.format("%1$4s", data.getDepts().get(majorIndex).getName())+" | ");
            System.out.print(String.format("%1$21s", data.getCourses().get(coursesIndex).getName())+
                    " ( "+data.getCourses().get(coursesIndex).getNumber()+ ", "+
                    x.getCourse().getMaxNumbOfStudents()+")     | ");
            System.out.print(String.format("%1$10s", data.getRooms().get(roomindex).getNumber()+
                    " ("+x.getRoom().getSeatingCapacity())+ ")   | ");
            System.out.print(String.format("%1$15s", data.getInstructors().get(instrctorIndex).getName()+
                    " ("+data.getInstructors().get(instrctorIndex).getId()+ ")")+ " | ");
            System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getTime()+
                    " ("+data.getMeetingTimes().get(meetingTimeIndex).getId()+")");
            
            classNumb++;
        });*/
    }
    private  void printAvailableData(){
        /*
       System.out.println("Available Departments ==>");
       data.getDepts().forEach(x->System.out.println("name:"+x.getName()+", courses:"+x.getCourses()));
        System.out.println("Available Couses ==>");
       data.getCourses().forEach(x->System.out.println("Courses:"+x.getNumber()+", name:"+x.getName()+"MaxofStudent:"
                                    +x.getMaxNumbOfStudents()+", Instructors"+x.getInstructor()));
        System.out.println("Available Rooms ==>");
       data.getRooms().forEach(x->System.out.println("room #:"+x.getNumber()+", maxCapacitiy:"+x.getSeatingCapacity()));
        System.out.println("Available Instructors ==>");
       data.getInstructors().forEach(x->System.out.println("ID:"+x.getId()+(",name:"+x.getName())));
        System.out.println("Available MeetingTime ==>");
       data.getMeetingTimes().forEach(x->System.out.println("id:"+x.getId()+", MeetTime:"+x.getTime()));
       System.out.print("-----------------------------------------------------------------printAvaiData------------------");
       System.out.println("---------------------------------------------------------------printAvaiData--------------------");
*/   
}
}
