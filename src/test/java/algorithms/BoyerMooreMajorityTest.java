package algorithms;

import algorithms.BoyerMooreMajority;
import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoyerMooreMajorityTest {

    @Test
    void testEmptyArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajority algo = new BoyerMooreMajority(tracker);
        assertThrows(IllegalArgumentException.class, () -> algo.findMajority(new int[]{}));
    }

    @Test
    void testSingleElement() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajority algo = new BoyerMooreMajority(tracker);
        assertEquals(7, algo.findMajority(new int[]{7}));
    }

    @Test
    void testMajorityExists() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajority algo = new BoyerMooreMajority(tracker);
        assertEquals(3, algo.findMajority(new int[]{3, 3, 4, 2, 3, 3, 5, 3}));
    }

    @Test
    void testNoMajority() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajority algo = new BoyerMooreMajority(tracker);
        assertNull(algo.findMajority(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void testAllSameElement() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajority algo = new BoyerMooreMajority(tracker);
        assertEquals(9, algo.findMajority(new int[]{9, 9, 9, 9, 9}));
    }

    @Test
    void testSortedInput() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajority algo = new BoyerMooreMajority(tracker);
        assertNull(algo.findMajority(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    void testReverseSortedInput() {
        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajority algo = new BoyerMooreMajority(tracker);
        assertNull(algo.findMajority(new int[]{6, 5, 4, 3, 2, 1}));
    }
}
