package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long arrayAccesses = 0;

    public void incrementComparisons() { comparisons++; }
    public void incrementArrayAccesses() { arrayAccesses++; }

    public long getComparisons() { return comparisons; }
    public long getArrayAccesses() { return arrayAccesses; }

    public void reset() {
        comparisons = 0;
        arrayAccesses = 0;
    }
}
