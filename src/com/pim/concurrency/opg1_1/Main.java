package com.pim.concurrency.opg1_1;

import java.util.ArrayList;

public class Main {
	
	private static Generator gen;
	
	public static void main(String[] args) {
		//main method
		gen = new Generator();

//		sort 25k
		ArrayList<Integer> list25 = gen.createRandomArrayList(25000);
		double start = (double)System.currentTimeMillis();
		insertionSort(list25);
		double end = (double)System.currentTimeMillis();
		double totaal = (end - start) / 1000;
		System.out.println("totale duur 25k sorteren: " + totaal + " seconden");
		
//		sort 50k
		ArrayList<Integer> list50 = gen.createRandomArrayList(50000);
		start = (double)System.currentTimeMillis();
		insertionSort(list50);
		end = (double)System.currentTimeMillis();
		totaal = (end - start) / 1000;
		System.out.println("totale duur 50k sorteren: " + totaal + " seconden");
		
//		sort 100k
		ArrayList<Integer> list100 = gen.createRandomArrayList(100000);
		start = (double)System.currentTimeMillis();
		insertionSort(list100);
		end = (double)System.currentTimeMillis();
		totaal = (end - start) / 1000;
		System.out.println("totale duur 100k sorteren: " + totaal + " seconden");
		
//		sort 200k
		ArrayList<Integer> list200 = gen.createRandomArrayList(200000);
		start = (double)System.currentTimeMillis();
		insertionSort(list200);
		end = (double)System.currentTimeMillis();
		totaal = (end - start) / 1000;
		System.out.println("totale duur 200k sorteren: " + totaal + " seconden");
		
//		sort 400k
//		ArrayList<Integer> list400 = gen.createRandomArrayList(400000);
//		insertionSort(list400);
		
//		sort 800k
//		ArrayList<Integer> list800 = gen.createRandomArrayList(800000);
//		insertionSort(list800);
		
//		System.out.println("sorted: \n");
//		for (Integer b : aList) {
//			System.out.println(b);
//		}
	}
	
	public static void insertionSort(ArrayList<Integer> aList) {
		for(int i = 1; i < aList.size(); i++) {
			int temp = aList.get(i);
			int j;
			for( j = i-1; j >= 0 && temp < aList.get(j); j--) {
				aList.set(j+1, aList.get(j));
				aList.set(j, temp);
			}
		}
	}
}
