package cli;

import algorithms.BoyerMooreMajority;
import metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {

    private static final Random random = new Random();

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java BenchmarkRunner <size> <distribution>");
            System.out.println("Distributions: random, sorted, reverse, majority, none");
            return;
        }

        int size = Integer.parseInt(args[0]);
        String distribution = args[1];

        int[] input = generateArray(size, distribution);

        PerformanceTracker tracker = new PerformanceTracker();
        BoyerMooreMajority algo = new BoyerMooreMajority(tracker);

        long start = System.nanoTime();
        Integer majority = null;
        try {
            majority = algo.findMajority(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        long end = System.nanoTime();

        System.out.println("Input size: " + size);
        System.out.println("Distribution: " + distribution);
        System.out.println("Majority element: " + majority);
        System.out.println("Comparisons: " + tracker.getComparisons());
        System.out.println("Array accesses: " + tracker.getArrayAccesses());
        System.out.println("Execution time (ms): " + (end - start) / 1_000_000.0);
    }

    private static int[] generateArray(int size, String type) {
        int[] arr = new int[size];

        switch (type.toLowerCase()) {
            case "random":
                for (int i = 0; i < size; i++) arr[i] = random.nextInt(100);
                break;

            case "sorted":
                for (int i = 0; i < size; i++) arr[i] = i;
                break;

            case "reverse":
                for (int i = 0; i < size; i++) arr[i] = size - i;
                break;

            case "majority":
                int majorityElement = 42;
                int majorityCount = size / 2 + 1;
                Arrays.fill(arr, 0, majorityCount, majorityElement);
                for (int i = majorityCount; i < size; i++) arr[i] = random.nextInt(100);
                break;

            case "none":
                for (int i = 0; i < size; i++) arr[i] = i % 2;
                break;

            default:
                throw new IllegalArgumentException("Unknown distribution type: " + type);
        }

        return arr;
    }
}

