package com.hcw.framework.learn.jdk14;

public class SwithExpressions {

    int a =1;
    //jdk14
    int b = switch(a){
        case 0,3->1;
        case 1->3;
        default->-1;
    };

    
}