package com.jason.proxy;

public class ActionOne implements IActionOne {

	@Override
	public String login(String username, String passwd, String gender) {
		System.out.println("#####enter action one");
		return null;
	}

}
