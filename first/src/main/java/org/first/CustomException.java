package org.first;

public class CustomException extends Exception{
	
	public CustomException() {
		super("Custom Exception!");
	}
	
	@Override
	public String getMessage() {
		return "Customized Exception Message!";
	}

}
