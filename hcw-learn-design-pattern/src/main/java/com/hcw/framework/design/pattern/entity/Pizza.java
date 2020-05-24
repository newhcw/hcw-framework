package com.hcw.framework.design.pattern.entity;

import lombok.ToString;

@ToString
public class Pizza implements Bean{

    private String name;

    private PizzaSize SIZE;
    
}

enum PizzaSize{
    BIG,MEDIUM,SMALL;
}