package com.hcw.framework.design.pattern.principle;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪米特法则实例
 */
public class DemeterLow {


    
}

class Teacher{

    public void command(Grouper grouper){
        var  students = new ArrayList<Student>();
        for(int i=0;i<20;i++){
            students.add(new Student());
        }
        grouper.count(students);
    }

    public void commandDemeter(Grouper grouper){
        grouper.countDemeter();
    }
}

class Grouper{

    public void count(List<Student> students) {
        System.out.println("now student total num is "+ students.size());
    }

    public void countDemeter() {
        var  students = new ArrayList<Student>();
        for(int i=0;i<20;i++){
            students.add(new Student());
        }
    }

}

class Student{
   
}