package edu.desu.timingevaluation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MergeSortTimingTest {

    private String originalProperty;

    @BeforeEach
    void setUp() {
        originalProperty = System.getProperty("is.student.test.run");
        System.setProperty("is.student.test.run", "true");
    }

    @AfterEach
    void tearDown() {
        if (originalProperty != null) {
            System.setProperty("is.student.test.run", originalProperty);
        } else {
            System.clearProperty("is.student.test.run");
        }
    }

    @Test
    @DisplayName("Test MergeSortTest.TimingTestRun with sample parameters")
    void testTimingTestRun() {
        assertDoesNotThrow(() -> MergeSortTest.TimingTestRun(50, 100, 5));
    }

    @Test
    @DisplayName("Test MergeSortTest.main method")
    void testMainMethod() {
        assertDoesNotThrow(() -> MergeSortTest.main(new String[0]));
    }
}
