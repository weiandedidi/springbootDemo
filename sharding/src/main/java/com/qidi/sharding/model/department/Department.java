package com.qidi.sharding.model.department;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable {

	/**  */
    private Long id;
	/**  */
    private String departmentname;
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getDepartmentname(){
		return this.departmentname;
	}
	
	public void setDepartmentname(String departmentname){
		this.departmentname = departmentname;
	}
	
	
}
