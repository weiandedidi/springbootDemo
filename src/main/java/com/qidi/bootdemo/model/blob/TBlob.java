package com.qidi.bootdemo.model.blob;

import java.io.Serializable;

public class TBlob implements Serializable {

	/** id */
    private Long id;
	/** 文档 */
    private String data;
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getData(){
		return this.data;
	}
	
	public void setData(String data){
		this.data = data;
	}
	
	
}
