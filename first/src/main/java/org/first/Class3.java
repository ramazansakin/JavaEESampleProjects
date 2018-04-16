package org.first;

public class Class3 {
		
	public Class3() {
		// default constructor
	}
	
	public void method3() {
		Class2 c2 = new Class2();
		try{	
			c2.method2();
		} catch (CustomException e) {
			e.printStackTrace();
			System.out.println("Got Exception : "+ e.getMessage());
		}
	}
	
}
