package com.qidi.bootdemo.model.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/** id */
    private Integer id;
	/** 用户名 */
    private String name;
	/** 密码 */
    private String pwd;
	/** 创建时间 */
    private Date createtime;
	
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
	
	public Date getCreatetime(){
		return this.createtime;
	}
	
	public void setCreatetime(Date createtime){
		this.createtime = createtime;
	}
	
	
}
