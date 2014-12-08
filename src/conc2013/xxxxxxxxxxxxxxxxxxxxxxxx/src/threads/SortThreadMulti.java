package threads;

import java.util.ArrayList;
import java.util.List;

import sort.InsertionSort;
import sort.MergeSort;

public class SortThreadMulti extends Thread{
	
	public List<Integer> toSort;
	private int maxSize;
	
	public SortThreadMulti(List<Integer> toSort, int maxSize) {
		this.toSort = toSort;
		this.maxSize = maxSize;
	}
	
	@Override
	public void run() {
		int currentSize = toSort.size();
		if(currentSize > maxSize) {
			int splitPoint = toSort.size()/2;
			List<Integer> left = new ArrayList<Integer>(toSort.subList(0, splitPoint));
			List<Integer> right = new ArrayList<Integer>(toSort.subList(splitPoint, toSort.size()));
			
			SortThreadMulti tLeft = new SortThreadMulti(left, maxSize);
			SortThreadMulti tRight = new SortThreadMulti(right, maxSize);
			tLeft.start();
			tRight.start();
			
			try {
				tLeft.join();
				tRight.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MergeSort ms = new MergeSort();
			toSort = ms.sort(tLeft.toSort, tRight.toSort);
		} else {
			InsertionSort is = new InsertionSort();
			is.sort(toSort);
		}
			
	}
	
}