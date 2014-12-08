package threads;

import java.util.List;

import sort.InsSort;

public class SortThread extends Thread{
	
	public List<Integer> toSort;
	
	public SortThread(List<Integer> toSort) {
		this.toSort = toSort;
	}
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		InsSort is = new InsSort();
		is.sort(toSort);
	}
	
}
