package com.obss.ramazansakin.second;

@Food(prices=30)
public class Sushi {

	public Sushi(){
		System.out.println("Sushi Class");
	}
	
	@Time(takes=30)
	public void prepare(){
		System.out.println("Preparing Sushi");
	}
	
	
	public void cook(){
		System.out.println("Cooking Sushi");
	}
	
	@Time(takes=20)
	public void send(){
		System.out.println("Sending Sushi");
	}
	
}
