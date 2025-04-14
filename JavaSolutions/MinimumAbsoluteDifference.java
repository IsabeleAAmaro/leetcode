package JavaSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        // Find the minimum absolute difference
        for (int i = 1; i < arr.length; i++) {
            int currentDiff = arr[i] - arr[i - 1];
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }

        // Collect all pairs with the minimum difference
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifference solution = new MinimumAbsoluteDifference();

        int[][] testCases = {
                {4, 2, 1, 3},
                {1, 3, 6, 10, 15},
                {3, 8, -10, 23, 19, -4, -14, 27}
        };

        List<List<List<Integer>>> expected = new ArrayList<>();
        expected.add(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 4)));
        expected.add(Arrays.asList(Arrays.asList(1, 3)));
        expected.add(Arrays.asList(Arrays.asList(-14, -10), Arrays.asList(19, 23), Arrays.asList(23, 27)));

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            List<List<Integer>> result = solution.minimumAbsDifference(arr);
            System.out.println("Test " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(arr));
            System.out.println("Expected: " + expected.get(i));
            System.out.println("Result: " + result);
            System.out.println(result.equals(expected.get(i)) ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}
