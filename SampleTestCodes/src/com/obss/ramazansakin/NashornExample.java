package com.obss.ramazansakin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NashornExample {
	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DDTHH:mm:ss");
		
		
		Date da = new Date("2016-11-15T22:55:40");

		System.out.println("Date : " + da);

		// java.util.Date date = new java.util.Date();

	}
}