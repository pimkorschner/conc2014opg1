package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	
	public MergeSort() {
	}
	
	public List<Integer> mergeSort(List<Integer> input) {
		if(input.size() > 1) {
			int middle = input.size()/2;
			
			List<Integer> left = input.subList(0, middle);
			List<Integer> right = input.subList(middle, input.size());
			mergeSort(left);
			mergeSort(right);
			input = sort(left, right);
		}
		
		return null;
	}
	
	public List<Integer> sort(List<Integer> left, List<Integer> right) {
		left = new ArrayList<Integer>(left);
		right = new ArrayList<Integer>(right);
		List<Integer> result = new ArrayList<Integer>();
		while( left.size() > 0 || right.size() > 0 ) {
			if(left.size() > 0 && right.size() > 0) {
				if(left.get(0) <= right.get(0)) {
					result.add(left.get(0));
					left.remove(0);
				} else {
					result.add(right.get(0));
					right.remove(0);
				}
			} else if (left.size() > 0) {
				result.add(left.get(0));
				left.remove(0);
			} else if (right.size() > 0) {
				result.add(right.get(0));
				right.remove(0);
			}
		}
		return result;
	}

}
