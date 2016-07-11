package com.jason.proxy;

public class ActionTwo implements IActionTwo {

	@Override
	public String login(String username, String passwd) {
		System.out.println("#####enter action two");
		return null;
	}

}
