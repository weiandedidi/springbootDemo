package com.qidi.sharding.model.employee;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

	/**  */
    private Long id;
	/**  */
    private String lastname;
	/**  */
    private Long gender;
	/**  */
    private String email;
	/**  */
    private Long dId;
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getLastname(){
		return this.lastname;
	}
	
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	public Long getGender(){
		return this.gender;
	}
	
	public void setGender(Long gender){
		this.gender = gender;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public Long getDId(){
		return this.dId;
	}
	
	public void setDId(Long dId){
		this.dId = dId;
	}
	
	
}
