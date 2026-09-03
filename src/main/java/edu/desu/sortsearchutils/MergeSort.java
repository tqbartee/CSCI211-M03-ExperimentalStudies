package edu.desu.sortsearchutils;

import edu.desu.helperstaticmethods.HelperStaticMethods;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Description of what this utility class does.
 * Follows Effective Java item 4: Enforce noninstantiability with a private constructor.
 */
public final class MergeSort {

    // 1. Private constructor prevents instantiation from within and outside the class
    private MergeSort() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    // 2. Static Utility Methods here; can duplicate
    // Perform selection sort on an array of int
    /** Merge contents of arrays S1 and S2 into properly sized array S. */
    // From book
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i + j] = S1[i++];               // copy ith element of S1 and increment i
            else
                S[i + j] = S2[j++];               // copy jth element of S2 and increment j
        }
    }

    /**Merge-sort contents of array S. */
    // From book
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) return;                              // array is trivially sorted
        // divide
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);         // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n);         // copy of second half
        // conquer (with recursion)
        mergeSort(S1, comp);                            // sort copy of first half
        mergeSort(S2, comp);                            // sort copy of second half
        // merge results
        merge(S1, S2, S, comp);              // merge sorted halves back into original
    }

    public static void main(String[] args) {
        int[] testArray = HelperStaticMethods.generateScrambledIntArray(8);
        System.out.println(Arrays.toString(testArray));
        Integer [] testArrayInteger = HelperStaticMethods.convertintArrayToInteger(testArray);
        // Now print the array
        System.out.println("The unsorted array is: ");
        System.out.println(Arrays.toString(testArrayInteger));
        // Now sort the array
        mergeSort(testArrayInteger, new HelperStaticMethods.DefaultComparator());
        // Now print the sorted
        System.out.println("The sorted array is: ");
        System.out.println(Arrays.toString(testArrayInteger));
    }
}
