package opgave3;

import java.util.ArrayList;

public class InserstionSortThreaded {

	public static void main(String[] args) {
		
		sort(1000, 2);
		sort(10000, 2);
		sort(100000, 2);
		sort(1000000, 2);
		sort(10000000, 2);
		//sort(100000000, 2);
	}

	private static int[] generateNumbers(int amount) {
		int[] array = new int[amount];
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) (Math.random() * amount));
		}

		return array;
	}

	private static void sort(int amount, int threads) {

		int[] array = generateNumbers(amount);

		ArrayList<InsertionThread> threadList = new ArrayList<InsertionThread>();

		long startTime = System.currentTimeMillis();
		int subSize = amount / threads;
		for (int i = 0; i < threads; i++) {
			int[] part = new int[subSize];
			System.arraycopy(array, subSize * i, part, 0, subSize);
			InsertionThread thread = new InsertionThread(part);
			threadList.add(thread);
			thread.start();
		}

		for (InsertionThread t : threadList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int[] finalArray = new int[0];
		for (InsertionThread t : threadList) {
			finalArray = makeArray(finalArray, t.getResult());
		}
		finalArray = mergeSort(finalArray);
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("finished with: " + amount + " numbers in: " + totalTime + "ms");
		
		
	}

	public static int[] makeArray(int[] a, int[] b) {
		int[] finalArray = new int[a.length + b.length];
		System.arraycopy(a, 0, finalArray, 0, a.length);
		System.arraycopy(b, 0, finalArray, a.length, b.length);
		return finalArray;
	}
	
	public static int[] mergeSort(int array[])
	{
		if (array.length > 1) {
			int elementsInA1 = array.length / 2;
			int elementsInA2 = elementsInA1;

			if ((array.length % 2) == 1)
				elementsInA2 += 1;

			int arr1[] = new int[elementsInA1];
			int arr2[] = new int[elementsInA2];

			for (int i = 0; i < elementsInA1; i++)
				arr1[i] = array[i];
			for (int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
				arr2[i - elementsInA1] = array[i];

			arr1 = mergeSort(arr1);
			arr2 = mergeSort(arr2);

			int i = 0, j = 0, k = 0;
			while (arr1.length != j && arr2.length != k) {
				if (arr1[j] < arr2[k]) {
					array[i] = arr1[j];
					i++;
					j++;
				}
				else {
					array[i] = arr2[k];
					i++;
					k++;
				}
			}

			while (arr1.length != j) {
				array[i] = arr1[j];
				i++;
				j++;
			}
			while (arr2.length != k) {
				array[i] = arr2[k];
				i++;
				k++;
			}
		}

		return array;
	}
}
