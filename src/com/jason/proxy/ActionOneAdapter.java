package com.jason.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActionOneAdapter implements InvocationHandler {

	private IActionOne actionOne;
	
	public ActionOneAdapter(IActionOne actionOne) {
		this.actionOne = actionOne;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		if("login2".equals(methodName)) {
			String username = (String) args[0];
			String passwd = (String) args[1];
			String gender = searchGender(username);
			try{
				Method method1 = ActionOne.class.getMethod("login", new Class<?>[]{String.class, String.class, String .class});
				return method1.invoke(actionOne, new Object[]{username, passwd, gender});
			}catch (InvocationTargetException e) {
//				Throwable cause = e.getCause();
//				if(cause != null && cause instanceof)
				throw e;
			}
		}else {
			return method.invoke(actionOne, args);
		}
		
	}

	private String searchGender(String username) {
		return "male";
	}

}
