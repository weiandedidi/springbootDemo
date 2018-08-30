package com.qidi.sharding.model.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/** id */
    private Integer id;
	/** 用户名 */
    private String name;
	/** 密码 */
    private String pwd;

	private String DGroup;
	
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

	public String getDGroup() {
		return DGroup;
	}

	public void setDGroup(String DGroup) {
		this.DGroup = DGroup;
	}
}
