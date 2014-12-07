package com.pim.concurrency.opg1_1;

import java.util.ArrayList;

public class Generator {

	public Generator() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Integer> createRandomArrayList(int length) {
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		for (int i = 0; i < length; i++) {
			int random = (int)(Math.random() * length);
			aList.add(random);
		}
		
		return aList;
	}
}
