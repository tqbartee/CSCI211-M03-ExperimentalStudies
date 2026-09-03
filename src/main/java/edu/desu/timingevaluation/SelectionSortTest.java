package edu.desu.timingevaluation;

import edu.desu.sortsearchutils.SelectionSort;
import edu.desu.helperstaticmethods.HelperStaticMethods;

public class SelectionSortTest {

    // Default template
    // Steps for test run

    // 1 Ensure base method defined for test (likely a static method)

    // 2 Define code to build the data structures for the test
    // Usually from HelperStaticMethods

    // Next parts to be defined in method TimingTestRun
    // 3 Define test run parameters
    // Make these pass-in for the timing test
    public static void TimingTestRun(int n1, int n2, int timesToRun) {

        int inputArraySize1 = n1;
        int inputArraySize2 = n2;

        // 4 Build data structures to support the test
        int[] originalInputArray1, originalInputArray2, currentArray1, currentArray2;

        // --- NEW: JVM WARM-UP PHASE ---
        // Warm up the JVM to trigger JIT compilation before timing begins.
        // We only warm up if running the heavy benchmark to save time during quick tests.
        if (!"true".equals(System.getProperty("is.student.test.run"))) {
            System.out.println("Warming up JVM to trigger JIT compilation (15k iterations)...");
            int warmUpSize = 500; // Small enough to be fast, large enough to simulate sorting
            int[] warmUpArray = HelperStaticMethods.generateScrambledIntArray(warmUpSize);
            for (int i = 0; i < 15000; i++) { // 15,000 is the standard Tier 4 JIT invocation threshold
                int[] temp = warmUpArray.clone();
                SelectionSort.selectionSort(temp);
            }
            System.out.println("Warm-up complete. JVM optimized.");
        }
        // ------------------------------

        System.out.println("Building main and test array...");
        // //TODO: Set inputArray and testValues
        // // See slides for directions

        // 5 Timestamp first run
        System.out.println("Running selectionSort...");
        long startTime = System.currentTimeMillis();

        // 6 Make first run
        for (int i = 0; i < timesToRun; i++) {
            // Clone operation here may impact test - ignore for now and let JMH handle
            currentArray1 = originalInputArray1.clone(); // Clone for each run
            SelectionSort.selectionSort(currentArray1);
        }

        // 7 Timestamp completion - calculate time
        double endTime = System.currentTimeMillis();
        double elapsed = endTime - startTime;
        String outputString = new String(Double.toString(elapsed));
        System.out.println(outputString);
        double elapsedseconds = (double) elapsed/1000;
        outputString = ("Time in seconds is: " +
                String.format("%.5f", elapsedseconds));
        System.out.println(outputString);

        // 8. Make predictions for second run times - from Timing Evaluation
        TimingInterpretation ourTimingEvaluation = new TimingInterpretation();
        ourTimingEvaluation.setClassName(SelectionSortTest.class.getSimpleName());
        ourTimingEvaluation.generatePredictionValues(inputArraySize1,
                inputArraySize2, timesToRun, elapsedseconds);
        ourTimingEvaluation.printPredictionReport();

        // 9 Build data structures for second test
        System.out.println("Building main and test array...");
        originalInputArray2 = HelperStaticMethods.generateScrambledIntArray(inputArraySize2);

        // 10 Timestamp second run start
        System.out.println("Running selectionSort...");
        startTime = System.currentTimeMillis();

        // 11 Make second run
        for (int i = 0; i < timesToRun; i++) {
            // Clone operation here may impact test for repeated trials - ignore for now
            currentArray2 = originalInputArray2.clone(); // Clone for each run
            SelectionSort.selectionSort(currentArray2);
        }

        // 12 Timestamp completion - calculate time
        endTime = System.currentTimeMillis();
        elapsed = endTime - startTime;
        outputString = new String(Double.toString(elapsed));
        System.out.println(outputString);
        elapsedseconds = (double) elapsed/1000;
        outputString = ("Time in seconds is: " +
                String.format("%.5f", elapsedseconds));
        System.out.println(outputString);

        // 13 Post-test analysis
        // Now call the post-test analysis to compare the
        // two times
        ourTimingEvaluation.generatePostTestValues(elapsedseconds);
        ourTimingEvaluation.printPostTestReport();
    }

    public static void main(String[] args) {
        System.out.println("Main called");
        int inputArraySize1;
        int inputArraySize2;
        int timesToRun;

        // When run by the verifier test, use small values for a quick test.
        // Otherwise, use the original large values for a full benchmark.
        if ("true".equals(System.getProperty("is.student.test.run"))) {
            inputArraySize1 = 100;
            inputArraySize2 = 200;
            timesToRun = 10;
        } else {
            inputArraySize1 = 131072;
            inputArraySize2 = 262144;
            timesToRun = 1;
        }
        TimingTestRun(inputArraySize1, inputArraySize2, timesToRun);
    }

}
