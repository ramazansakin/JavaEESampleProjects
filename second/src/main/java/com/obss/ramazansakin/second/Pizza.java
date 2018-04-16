package com.obss.ramazansakin.second;

@Food(prices=22.5)
public class Pizza {
	
	public Pizza(){
		System.out.println("Pizza Class");
	}
	
	@Time(takes=10)
	public void prepare(){
		System.out.println("Preparing Pizza");
	}
	
	@Time(takes=20)
	public void cook(){
		System.out.println("Cooking Pizza");
	}
	
	@Time(takes=15)
	public void send(){
		System.out.println("Sending Pizza");
	}
	
}
