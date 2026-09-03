package edu.desu.sortsearchutils;

/**
 * Description of what this utility class does.
 * Follows Effective Java item 4: Enforce noninstantiability with a private constructor.
 */
public final class InsertionSort {

    // 1. Private constructor prevents instantiation from within and outside the class
    private InsertionSort() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    // 2. Static Utility Methods here; can duplicate
    // Perform selection sort on an array of int
    public static void insertionSort(int[] data) {

		// Throws NullPointerException immediately if data is null, matching Arrays.sort()
		if (data == null) {
			throw new NullPointerException("The input array cannot be null");
		}
	}

	/** Insertion-sort of an array of characters into nondecreasing order */
	public static void insertionSort(char[] data) {
		int n = data.length;
		for (int k=1; k < n; k++) {                   // begin with second character
			char cur = data[k];                       // time to insert cur=data[k]
			int j = k;                                // find correct index j for cur
			while (j > 0 && data[j-1] > cur) {        // thus, data[j-1] must go after cur
				data[j] = data[j-1];                   // slide data[j-1] rightward
				j--;                                  // and consider previous j for cur
			}
			data[j] = cur;                            // this is the proper place for cur
		}
	}
}
