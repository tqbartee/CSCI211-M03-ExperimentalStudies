package edu.desu.sortsearchutils;

/**
 * Description of what this utility class does.
 * Follows Effective Java item 4: Enforce noninstantiability with a private constructor.
 */
public final class LinearSearch {

    // 1. Private constructor prevents instantiation from within and outside the class
    private LinearSearch() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    // 2. Static Utility Methods here; can duplicate
    // Performs a linear search for 1 if answer == true, or 0 if answer == false.
    public static boolean linearSearch(int[] data, int target) {

        for (int index = 0; index < data.length; index++) {
            if (data[index] == target) {
                return true;
            }
        }
        return false;

    }

}
