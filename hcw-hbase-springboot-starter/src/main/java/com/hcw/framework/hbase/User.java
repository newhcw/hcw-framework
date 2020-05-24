package com.hcw.framework.hbase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class User {

    
	private String name;
	private String email;
	private String password;
	
	
    
}