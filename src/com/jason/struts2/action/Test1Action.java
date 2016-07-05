package com.jason.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class Test1Action extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7650243672624043417L;

	private String name;

	public String execute() throws Exception {
		System.out.println("Inside action...");
		
//		if("SECRET".endsWith(name)) {
			return SUCCESS;
//		}else {
//			return ERROR;
//		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
