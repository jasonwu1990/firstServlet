package com.jason.struts2.action;


/**
 * 
 * @author wufan
 *
 */
public class Struts2TestAction {

	private String name;

	 public String execute() throws Exception {
	      return "success";
	   } 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
