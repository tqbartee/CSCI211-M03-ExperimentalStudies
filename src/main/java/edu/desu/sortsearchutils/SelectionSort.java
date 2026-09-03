package edu.desu.sortsearchutils;

/**
 * Description of what this utility class does.
 * Follows Effective Java item 4: Enforce noninstantiability with a private constructor.
 */
public final class SelectionSort {

    // 1. Private constructor prevents instantiation from within and outside the class
    private SelectionSort() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    // 2. Static Utility Methods here; can duplicate
    // Perform selection sort on an array of int
    public static void selectionSort(int[] data) {

        // Throws NullPointerException immediately if data is null, matching Arrays.sort()
        if (data == null) {
            throw new NullPointerException("The input array cannot be null");
        }

        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
			// Perform the swap here
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
		
    }
}
