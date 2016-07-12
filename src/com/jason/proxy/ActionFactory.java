package com.jason.proxy;

import java.lang.reflect.Proxy;

public class ActionFactory {

	public static IActionTwo adaptAction(IActionOne actionOne) {
		ActionOneAdapter adapter = new ActionOneAdapter(actionOne);
		ClassLoader cl = actionOne.getClass().getClassLoader();
		return (IActionTwo)Proxy.newProxyInstance(cl, new Class<?>[]{IActionTwo.class}, adapter);
	}
	
	
	
	public static void main(String[] args) {
		IActionOne actionOne = new ActionOne();
		actionOne.login("test1", "test11", "female");
		
		IActionTwo actionTwo = new ActionTwo();
		actionTwo.login2("test2", "test22");
		
		IActionTwo proxyActionTwo = ActionFactory.adaptAction(actionOne);
		// 实际上调用的还是actionOne的
		proxyActionTwo.login2("test3", "test33");
	}
}
