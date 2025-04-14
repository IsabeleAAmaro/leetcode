package JavaSolutions;

import java.util.Arrays;
import java.util.HashMap;

class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate solution = new ContainsNearbyDuplicate();

        int[][] testCases = {
                {1, 2, 3, 1},
                {1, 0, 1, 1},
                {1, 2, 3, 1, 2, 3}
        };

        int[] kValues = {3, 1, 2};
        boolean[] expected = {true, true, false};

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int k = kValues[i];
            boolean result = solution.containsNearbyDuplicate(nums, k);
            System.out.println("Test " + (i + 1) + ":");
            System.out.println("Input: nums = " + Arrays.toString(nums) + ", k = " + k);
            System.out.println("Expected: " + expected[i]);
            System.out.println("Result: " + result);
            System.out.println(result == expected[i] ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}