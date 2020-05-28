package com.hcw.framework.design.pattern.decorator;

import java.util.ArrayList;
import java.util.List;

public class RedisComponent implements Component{
    public List<Object> queryList() {

        System.out.println("query data from redis");
        
		return new ArrayList<>();
	}
}