package JavaSolutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        int[][] testCases = {
                {2, 7, 11, 15},  // Example 1
                {3, 2, 4},       // Example 2
                {3, 3}           // Example 3
        };

        int[] targets = {9, 6, 6};

        int[][] expected = {
                {0, 1},
                {1, 2},
                {0, 1}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int target = targets[i];
            int[] result = solution.twoSum(nums, target);
            System.out.println("Teste " + (i + 1) + ":");
            System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);
            System.out.println("Esperado: " + Arrays.toString(expected[i]));
            System.out.println("Resultado: " + Arrays.toString(result));
            System.out.println(Arrays.equals(result, expected[i]) ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}
