package sort;

import java.util.List;

public class InsertionSort {
	
	public InsertionSort() {
	}
	
	public List<Integer> sort(List<Integer> toSort) {
		List<Integer> sorted = toSort;
		for(int i = 1; i < sorted.size(); i++) {
			int t = sorted.get(i);
			int j;
			for(j = i-1; j >= 0 && t < sorted.get(j); j--) {
				sorted.set(j+1, sorted.get(j));
			}
			sorted.set(j+1, t);
		}
		return sorted;
	}

}
