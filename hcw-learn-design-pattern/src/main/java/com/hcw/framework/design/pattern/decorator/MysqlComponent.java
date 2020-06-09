package com.hcw.framework.design.pattern.decorator;

import java.util.ArrayList;
import java.util.List;

public class MysqlComponent implements Component{
    @Override
    public List<Object> queryList() {

        System.out.println("query data from db");
        
		return new ArrayList<>();
	}
}