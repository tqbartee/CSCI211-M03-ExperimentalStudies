package edu.desu.sortsearchutils;

/**
 * Description of what this utility class does.
 * Follows Effective Java item 4: Enforce noninstantiability with a private constructor.
 */
public final class BinarySearch {

    // 1. Private constructor prevents instantiation from within and outside the class
    private BinarySearch() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    // 2. Static Utility Methods here; can duplicate
    // Performs a binary search bounded by low and high
    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high)
            return false;                                          // interval empty; no match
        else {
            int mid = (low + high) / 2;                            // truncating division
            if (target == data[mid])
                return true;                                       // found a match
            else if (target < data[mid])
                return binarySearch(data, target, low, mid - 1);   // recur left of the middle
            else
                return binarySearch(data, target, mid + 1, high);  // recur right of the middle
        }
    }
	
	// This method calls binary search for the entire array
	public static boolean binarySearch(int[] data, int target) {
		// Start recursive binary search with the entire array
		int low = 0;
        int high = data.length - 1;
        return binarySearch(data, target, low, high);
	}

}




