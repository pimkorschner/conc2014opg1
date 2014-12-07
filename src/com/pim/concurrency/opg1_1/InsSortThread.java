package com.pim.concurrency.opg1_1;

import java.util.ArrayList;

public class InsSortThread extends Thread {

	ArrayList<Integer> arr;
	
	public InsSortThread(ArrayList<Integer> arr) {
		// TODO Auto-generated constructor stub
		this.arr = arr;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
			for(int i = 1; i < arr.size(); i++) {
				int temp = arr.get(i);
				int j;
				for( j = i-1; j >= 0 && temp < arr.get(j); j--) {
					arr.set(j+1, arr.get(j));
					arr.set(j, temp);
				}
			}
	}
}
