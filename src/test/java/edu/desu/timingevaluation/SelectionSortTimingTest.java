package edu.desu.timingevaluation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SelectionSortTimingTest {

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
    @DisplayName("Test SelectionSortTest.TimingTestRun with sample parameters")
    void testTimingTestRun() {
        assertDoesNotThrow(() -> SelectionSortTest.TimingTestRun(50, 100, 5));
    }

    @Test
    @DisplayName("Test SelectionSortTest.main method")
    void testMainMethod() {
        assertDoesNotThrow(() -> SelectionSortTest.main(new String[0]));
    }
}
