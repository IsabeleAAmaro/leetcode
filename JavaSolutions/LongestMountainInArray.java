package JavaSolutions;

import java.util.Arrays;

class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLength = 0;
        int i = 1;

        while (i < n - 1) {
            // Check if current element is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                int right = i + 1;
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                int currentLength = right - left + 1;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }

                i = right; // Move to the end of the current mountain
            } else {
                i++;
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }

    public static void main(String[] args) {
        LongestMountainInArray solution = new LongestMountainInArray();

        int[][] testCases = {
                {2, 1, 4, 7, 3, 2, 5},
                {2, 2, 2},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {1, 2, 3, 2, 1},
                {1, 2, 2, 1},
                {1, 2, 3, 2, 1, 0, -1}
        };

        int[] expected = {5, 0, 0, 0, 5, 0, 7};

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            int result = solution.longestMountain(arr);
            System.out.println("Test " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(arr));
            System.out.println("Expected: " + expected[i]);
            System.out.println("Result: " + result);
            System.out.println(result == expected[i] ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}
