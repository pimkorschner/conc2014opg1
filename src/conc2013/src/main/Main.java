package main;

import java.util.ArrayList;
import java.util.List;

import sort.InsSort;
import sort.MergSort;
import threads.SortThread;

public class Main {

	public static void main(String[] args) {
		InsSort is = new InsSort();
		MergSort ms = new MergSort();
		
		List<Integer> toSort = createArray(50000,1000);
		
//		onePointOne(createArray(25000, 1000), 10);
//		onePointOne(createArray(50000, 1000), 10);
//		onePointOne((ArrayList)createArray(100000, 1000), 10);
//		onePointOne(createArray(200000, 1000), 10);
//		onePointOne(createArray(400000, 1000), 10);
//		onePointOne(createArray(800000, 1000), 10);
		
		onePointTwo(createArray(25000, 1000), 2, 10);
		onePointTwo(createArray(50000, 1000), 2, 10);
		onePointTwo(createArray(100000, 1000), 2, 10);
		onePointTwo(createArray(200000, 1000), 2, 10);
		onePointTwo(createArray(400000, 1000), 2, 10);
		onePointTwo(createArray(800000, 1000), 2, 10);
	}
	
	public static void onePointOne(ArrayList<Integer> toSort, int timesToExecute) {
		System.out.println("Assignment 1.1: Array size = " + toSort.size() + " will be executed " + timesToExecute + " times.");
		InsSort is = new InsSort();
		long totalTime = 0;
		
		for(int i = 0; i < timesToExecute; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp = (ArrayList<Integer>) toSort.clone();
			long startTime = System.currentTimeMillis();
			is.sort(temp);
			long endTime = System.currentTimeMillis();
			long time = endTime - startTime;
			System.out.print(time + "\t");
			totalTime += time;
		}
		long avgTime = totalTime/timesToExecute;
		System.out.println("Average execution time = " + avgTime + "ms");
		
	}
	
	public static void onePointTwo(List<Integer> toSort, int splits, int timesToExecute) {
		System.out.println("Assignment 1.2: Array size = " + toSort.size() + " will be executed " + timesToExecute + " times splitted in " + splits + " threads.");
		int splitPoint = toSort.size()/splits;
		List<Integer> left = toSort.subList(0, splitPoint);
		List<Integer> right = toSort.subList(splitPoint, toSort.size());
		long totalTime = 0;
		List<Integer> finalList = null;
		for(int i = 0; i < timesToExecute; i++) {
			ArrayList<Integer> leftTemp = new ArrayList<Integer>(left);
			ArrayList<Integer> rightTemp = new ArrayList<Integer>(right);
			SortThread l = new SortThread(leftTemp);
			SortThread r = new SortThread(rightTemp);
			
			long startTime = System.currentTimeMillis();
			
			l.start();
			r.start();
			
			try {
				l.join();
				r.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MergSort ms = new MergSort();
			finalList = ms.sort(l.toSort, r.toSort);
			
			long endTime = System.currentTimeMillis();
			long time = endTime - startTime;
			totalTime += time;
			
			System.out.print(time + "ms\t");
		}
		System.out.println("average time = " + totalTime/timesToExecute + "ms");
		boolean correct = checkIfSorted(finalList);
		System.out.println("De grootte van de uiteindelijke array is: " + finalList.size() + "\nStaat de array in de juiste volgorde = " + correct + "\n");
		
//		long start = System.currentTimeMillis();
//		MergSort ms = new MergSort();
//		List<Integer> finalList = ms.sort(left, right);
//		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static List<Integer> createArray(int amount, int max) {
		List<Integer> ar = new ArrayList<Integer>();
		for(int i = 0; i < amount; i++) {
			int random = (int) (Math.random() * max);
			ar.add(random);
		}
		
		return ar;
	}
	
	public static boolean checkIfSorted(List<Integer> input) {
		boolean check = true;
		for(int i = 1; i < input.size(); i++) {
			if(input.get(i-1) > input.get(i)) {
				check = false;
				break;
			}
		}
		return check;
	}
}
