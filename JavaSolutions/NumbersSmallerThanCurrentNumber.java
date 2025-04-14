package JavaSolutions;

import java.util.Arrays;

class NumbersSmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = sortedNums.length - 1;
            int count = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (sortedNums[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            result[i] = left;
        }

        return result;
    }

    public static void main(String[] args) {
        NumbersSmallerThanCurrentNumber solution = new NumbersSmallerThanCurrentNumber();

        int[][] testCases = {
                {8, 1, 2, 2, 3},  // Example 1
                {6, 5, 4, 8},       // Example 2
                {7, 7, 7, 7}        // Example 3
        };

        int[][] expected = {
                {4, 0, 1, 1, 3},
                {2, 1, 0, 3},
                {0, 0, 0, 0}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int[] result = solution.smallerNumbersThanCurrent(nums);
            System.out.println("Teste " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(nums));
            System.out.println("Esperado: " + Arrays.toString(expected[i]));
            System.out.println("Resultado: " + Arrays.toString(result));
            System.out.println(Arrays.equals(result, expected[i]) ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}
