package com.obss.ramazansakin.second;

@Food(prices=12.5)
public class Kebab {

	public Kebab(){
		System.out.println("Kebab Class");
	}
	
	@Time(takes=12)
	public void prepare(){
		System.out.println("Preparing Kebab");
	}
	
	@Time(takes=20)
	public void cook(){
		System.out.println("Cooking Kebab");
	}
	
	@Time(takes=10)
	public void send(){
		System.out.println("Sending Kebab");
	}
	
}
