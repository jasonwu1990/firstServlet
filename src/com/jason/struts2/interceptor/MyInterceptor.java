package com.jason.struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9038066325995532444L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Pre-Processing");
		
		String result = invocation.invoke();
		System.out.println("post-Processing");
		
		return result;
	}
	
	
}
