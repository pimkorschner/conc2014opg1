package opgave2;

import java.util.ArrayList;

public class InsertionThread extends Thread {

	int[] input;
	
	public InsertionThread(int[] input) {
		this.input = input;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		ArrayList<Integer> finalSort = new ArrayList<Integer>();
		long startTime = System.currentTimeMillis();
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

			// tijd bijhouden
//			if (i % (input.length / 100) == 0 && input.length >= 1000000) {
//				long endTime = System.currentTimeMillis();
//				long totalTime = endTime - startTime;
//				System.out.println("done with " + i + " items. In: "
//						+ totalTime + " ms");
//			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
//		System.out.println("done with " + input.length + " items. In: "	+ totalTime + " ms");

		super.run();
	}
	
	public int[] getResult() {
		return input; 
	}

}
