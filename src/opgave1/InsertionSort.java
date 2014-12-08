package opgave1;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class InsertionSort {

	public static void main(String[] args) {
		 insertionSort(generateNumbers(10000));
		 insertionSort(generateNumbers(100000));
		 insertionSort(generateNumbers(1000000));
	}

	private static int[] generateNumbers(int amount) {
		int[] array = new int[amount];
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) (Math.random() * 10 * amount));
		}

		return array;

	}

	private static void insertionSort(int[] input) {

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
			if (i % (input.length / 100) == 0 && input.length >= 1000000) {
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				System.out.println("done with " + i + " items. In: " + totalTime + " ms");
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("finished with " + input.length + " items. In: "
				+ totalTime + " ms");
	}

}
