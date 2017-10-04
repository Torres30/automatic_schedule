/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.generador;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 *
 * @author Luis
 */
public class Population {
    ArrayList<Schedule> schedules;
    public Population(int size, Data data){
     schedules = new ArrayList<Schedule>(size);
     IntStream.range(0, size).forEach(x-> schedules.add(new Schedule(data).initialize()));
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }
    public Population sortByFitness(){
       schedules.sort((schedule1,eschedule2)->{
       int returnValue = 0;
       if(schedule1.getFitness()> eschedule2.getFitness())  returnValue = -1;
       else if (schedule1.getFitness()<eschedule2.getFitness()) returnValue=1;
       return returnValue;
       });
       return this;
    }
}
