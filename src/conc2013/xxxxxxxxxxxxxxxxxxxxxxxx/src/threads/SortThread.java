package threads;

import java.util.List;

import sort.InsertionSort;

public class SortThread extends Thread{
	
	public List<Integer> toSort;
	
	public SortThread(List<Integer> toSort) {
		this.toSort = toSort;
	}
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		InsertionSort is = new InsertionSort();
		is.sort(toSort);
	}
	
}
