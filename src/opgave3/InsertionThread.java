package opgave3;

import java.util.ArrayList;

public class InsertionThread extends Thread {

	int[] input;
	final int MAX_SIZE = 1000;
	
	public InsertionThread(int[] input) {
		this.input = input;
	}
	
	@Override
	public void run() {
		if(input.length > MAX_SIZE) {
			int[] part1 = new int[input.length/2];
			int[] part2 = new int[input.length/2 + (input.length % 2 == 0 ? 0 : 1)];
			
			System.arraycopy(input, 0, part1, 0, part1.length);
			System.arraycopy(input, part1.length, part2, 0, part2.length);
			
			InsertionThread it1 = new InsertionThread(part1);
			InsertionThread it2 = new InsertionThread(part2);
			
			it1.start();
			it2.start();
			
			try {
				it1.join();
				it2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			input = InserstionSortThreaded.makeArray(it1.getResult(), it2.getResult());
			
			input = InserstionSortThreaded.mergeSort(input);
			
		} else {
			ArrayList<Integer> finalSort = new ArrayList<Integer>();
			long startTime = System.currentTimeMillis();
			//insertionsort
			for (int i = 0; i < input.length; i++) {
				finalSort.ensureCapacity(input.length);
				int temp = input[i];
				int j = i;
				while (j > 0 && input[j - 1] >= temp) {
					// finalSort.add(input[j-1]);
					input[j] = input[j - 1];
					j--;
				}
				input[j] = temp;

			}
		}
		
//		System.out.println("done with " + input.length + " items. In: "	+ totalTime + " ms");

		super.run();
	}
	
	public int[] getResult() {
		return input; 
	}

}
