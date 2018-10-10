package com.qidi.moredatasource.model.user;

import java.io.Serializable;

public class User implements Serializable {

	/** id */
//	@JsonIgnore
    private Integer id;
	/** 用户名 */
    private String name;
	/** 密码 */
    private String pwd;

	public Integer getId(){
		return this.id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getPwd(){
		return this.pwd;
	}
	
	public void setPwd(String pwd){
		this.pwd = pwd;
	}

	public User() {
	}
}
