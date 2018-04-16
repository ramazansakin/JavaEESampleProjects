package com.obss.ramazansakin.second;

import java.io.Serializable;

public class MenuItemBean implements Serializable {
	
	private static final long serialVersionUID = 1241212312412312312L;
	private String name;
	private Double prices;
	private int time;
	
	public MenuItemBean(){
		//default constructor
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrices() {
		return prices;
	}
	
	public void setPrices(double prices) {
		this.prices = prices;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Item : name = "+name+" price = "+prices+" time = "+time;
	}

}

