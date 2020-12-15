package com.hcw.framework.learn.jdk8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortLambda {


    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1,"jay",20));
        list.add(new Employee(2,"amy",35));
        list.add(new Employee(3,"lily",22));
        list.add(new Employee(4,"mili",27));

        System.out.println(list.stream().max(Comparator.comparing(v -> v.getAge())).get());
    }


}


class Employee {
    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder str = null;
        str = new StringBuilder();
        str.append("Id:- " + getId() + " Name:- " + getName() + " Age:- " + getAge());
        return str.toString();
    }
}
