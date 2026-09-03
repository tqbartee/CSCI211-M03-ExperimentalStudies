package edu.desu.timingevaluation;

public class TimingInterpretation {
    // Input size N for first and planned second test runs
    // Usually N2 for tests will be double N1
    int N1;
    int N2;
    int numberOfRuns;
    // Test result in seconds for test run 1
    double elapsedTimeTest1Seconds;
    // Computed values based on input sizes
    // Multiplier is proportion of inputs - N2/N1
    double multiplier;
    // Figure out growth factors
    double logN1;
    double logN2;
    double growthLogN;
    // growthN is growth from N factor
    double growthN;
    // Now NlogN calculations
    double nLogN1;
    double nLogN2;
    double growthNLogN;
    // Growth for quadratic factor
    double N1Squared;
    double N2Squared;
    double growthNSquaredQuadratic;
    // Growth for cubic factor
    double N1Cubed;
    double N2Cubed;
    double growthNCubed;
    // Exponential
    double N1Exponential;
    double N2Exponential;
    double growthExponential;

    // String representations of these for reporting
    // Only need for the float/double
    String formattedLogN1;
    String formattedLogN2;
    String formattedGrowthLogN;
    String formattedGrowthN;
    String formattedNLogN1;
    String formattedNLogN2;
    String formattedGrowthNLogN;
    String formattedN1Squared;
    String formattedN2Squared;
    String formattedGrowthNSquaredQuadratic;
    String formattedN1Cubed;
    String formattedN2Cubed;
    String formattedGrowthNCubed;

    // Expected times for the second run (seconds)
    double growthLogNExpectedTime;
    double growthNExpectedTime;
    double growthNLogNExpectedTime;
    double growthNSquaredQuadraticExpectedTime;
    double growthNCubedExpectedTime;

    // String representations of these for reporting
    String formattedGrowthLogNExpectedTime;
    String formattedGrowthNExpectedTime;
    String formattedGrowthNLogNExpectedTime;
    String formattedGrowthNSquaredQuadraticExpectedTime;
    String formattedGrowthNCubedExpectedTime;

    // Now the variables associated with the second time
    // First the elapsed time for the second run
    double elapsedTimeTest2Seconds;
    // Now compute the percentage of expected times
    double percentOfLogNExpectedTime;
    double percentOfGrowthNExpectedTime;
    double percentOfGrowthNLogNExpectedTime;
    double percentOfGrowthNSquaredQuadraticExpectedTime;
    double percentOfGrowthNCubedExpectedTime;
    private String className;

    public void setClassName(String className) {
        this.className = className;
    }

    //public void TimingEvaluation() {
    //    System.out.println("A new one");
    //}

    public void generatePredictionValues(int inputN1, int inputN2, int runs, double inputElapsedSeconds) {
        System.out.println("Now generating prediction values...");
        N1 = inputN1;
        N2 = inputN2;
        numberOfRuns = runs;
        elapsedTimeTest1Seconds = inputElapsedSeconds;

        // Now make predictions for second run times
        multiplier = this.N2/this.N1;
        // Now compute expected values based on input size
        logN1 =  Math.log(N1) / Math.log(2);
        logN2 =  Math.log(N2) / Math.log(2);
        growthLogN = logN2/logN1;
        growthN = N2/N1;
        nLogN1 = N1*logN1;
        nLogN2 = N2*logN2;
        growthNLogN = nLogN2/nLogN1;
        N1Squared = Math.pow(N1,2);
        N2Squared = Math.pow(N2,2);
        growthNSquaredQuadratic = N2Squared/N1Squared;
        N1Cubed = Math.pow(N1,3);
        N2Cubed = Math.pow(N2,3);
        growthNCubed = N2Cubed/N1Cubed;
        // Now computed expected running times based on algorithm
        // growth rates
        growthLogNExpectedTime = growthLogN*elapsedTimeTest1Seconds;
        growthNExpectedTime = growthN*elapsedTimeTest1Seconds;
        growthNLogNExpectedTime = growthNLogN*elapsedTimeTest1Seconds;
        growthNSquaredQuadraticExpectedTime = growthNSquaredQuadratic*elapsedTimeTest1Seconds;
        growthNCubedExpectedTime = growthNCubed*elapsedTimeTest1Seconds;
    }

    public void printPredictionReport() {
        System.out.println("... Predictions for Trial 2 have been calculated.");
    }

    public void generatePostTestValues(double inputElapsedSeconds) {
        // Now calculate the percentages
        elapsedTimeTest2Seconds = inputElapsedSeconds;
        percentOfLogNExpectedTime = (elapsedTimeTest2Seconds/growthLogNExpectedTime)*100;
        percentOfGrowthNExpectedTime = (elapsedTimeTest2Seconds/growthNExpectedTime)*100;
        percentOfGrowthNLogNExpectedTime = (elapsedTimeTest2Seconds/growthNLogNExpectedTime)*100;
        percentOfGrowthNSquaredQuadraticExpectedTime = (elapsedTimeTest2Seconds/growthNSquaredQuadraticExpectedTime)*100;
        percentOfGrowthNCubedExpectedTime = (elapsedTimeTest2Seconds/growthNCubedExpectedTime)*100;
    }

    public void printPostTestReport() {
        double actualTimeGrowth = elapsedTimeTest2Seconds / elapsedTimeTest1Seconds;

        System.out.println("\n===================================================================");
        System.out.println("                   Timing Evaluation Results");
        if (this.className != null) {
            String classLine = "Class " + this.className;
            int centerOfTitle = 19 + 25 / 2; // "Timing Evaluation Results"
            int paddingSize = centerOfTitle - (classLine.length() / 2);
            paddingSize = Math.max(0, paddingSize);
            StringBuilder padding = new StringBuilder();
            for (int i = 0; i < paddingSize; i++) {
                padding.append(" ");
            }
            System.out.println(padding.toString() + classLine);
        }
        System.out.println("===================================================================");

        System.out.printf("\n--- Trial 1 ---\n");
        System.out.printf("Input Size (N1):      %,d\n", N1);
        System.out.printf("Number of Runs:       %,d\n", numberOfRuns);
        System.out.printf("Execution Time (T1):  %.4f seconds\n", elapsedTimeTest1Seconds);

        System.out.printf("\n--- Trial 2 ---\n");
        System.out.printf("Input Size (N2):      %,d\n", N2);
        System.out.printf("Number of Runs:       %,d\n", numberOfRuns);
        System.out.printf("Execution Time (T2):  %.4f seconds\n", elapsedTimeTest2Seconds);

        System.out.printf("\n--- Growth Analysis ---\n");
        System.out.printf("Input Size Growth (N2/N1):      %.2fx\n", multiplier);
        System.out.printf("Actual Time Growth (T2/T1):     %.2fx\n", actualTimeGrowth);

        System.out.println("\n--- Big-O Prediction vs. Actual for Trial 2 ---");
        String headerFormat = "| %-16s | %-16s | %-16s | %-11s |\n";
        String rowFormat = "| %-16s | %-16.4f | %-16.4f | %-10.2f%% |\n";
        String border = "+------------------+------------------+------------------+-------------+\n";

        System.out.print(border);
        System.out.printf(headerFormat, "Growth Function", "Predicted Time", "Actual Time", "% of Pred.");
        System.out.print(border);

        System.out.printf(rowFormat, "O(log N)", growthLogNExpectedTime, elapsedTimeTest2Seconds, percentOfLogNExpectedTime);
        System.out.printf(rowFormat, "O(N)", growthNExpectedTime, elapsedTimeTest2Seconds, percentOfGrowthNExpectedTime);
        System.out.printf(rowFormat, "O(N log N)", growthNLogNExpectedTime, elapsedTimeTest2Seconds, percentOfGrowthNLogNExpectedTime);
        System.out.printf(rowFormat, "O(N^2)", growthNSquaredQuadraticExpectedTime, elapsedTimeTest2Seconds, percentOfGrowthNSquaredQuadraticExpectedTime);
        System.out.printf(rowFormat, "O(N^3)", growthNCubedExpectedTime, elapsedTimeTest2Seconds, percentOfGrowthNCubedExpectedTime);
        System.out.print(border);

        // Simple conclusion logic
        double[] differences = {
                Math.abs(100 - percentOfLogNExpectedTime),
                Math.abs(100 - percentOfGrowthNExpectedTime),
                Math.abs(100 - percentOfGrowthNLogNExpectedTime),
                Math.abs(100 - percentOfGrowthNSquaredQuadraticExpectedTime),
                Math.abs(100 - percentOfGrowthNCubedExpectedTime)
        };
        String[] bigO = {"O(log N)", "O(N)", "O(N log N)", "O(N^2)", "O(N^3)"};
        int minIndex = 0;
        for (int i = 1; i < differences.length; i++) {
            if (differences[i] < differences[minIndex]) {
                minIndex = i;
            }
        }

        System.out.println("\n--- Conclusion ---");
        System.out.printf("The actual execution time for Trial 2 was closest to the prediction for %s.\n", bigO[minIndex]);
        System.out.println("This suggests the algorithm exhibits this time complexity for the given inputs.");
        System.out.println("===================================================================");
    }

}
