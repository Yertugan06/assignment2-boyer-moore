package algorithms;

import metrics.PerformanceTracker;

public class BoyerMooreMajority {
    private final PerformanceTracker tracker;

    public BoyerMooreMajority(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public Integer findMajority(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int candidate = 0, count = 0;
        for (int num : nums) {
            tracker.incrementArrayAccesses();
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                tracker.incrementComparisons();
                count++;
            } else {
                tracker.incrementComparisons();
                count--;
            }
        }

        // Verify candidate
        int occurrence = 0;
        for (int num : nums) {
            tracker.incrementArrayAccesses();
            if (num == candidate) {
                occurrence++;
            }
        }
        return (occurrence > nums.length / 2) ? candidate : null;
    }
}
