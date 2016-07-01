package com.jason.struts2.action;

import com.jason.struts2.constants.ServletConstants;


/**
 * 
 * @author wufan
 *
 */
public class Struts2TestAction {

	private String name;

	public String execute() throws Exception {
		return ServletConstants.SUCC;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
