package org.first;

public class Class2 {

	public Class2() {
		// default constructor
	}
	
	public void method2() throws CustomException {
		Class1 c1 = new Class1();
		c1.method1();
	}
	
}
