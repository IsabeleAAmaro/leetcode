package JavaSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Mark each number's presence by negating the value at its corresponding index
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Collect all indices that still have positive values
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[][] testCases = {
                {4, 3, 2, 7, 8, 2, 3, 1},  // Example 1
                {1, 1},                     // Example 2
                {1, 2, 3},                  // No missing numbers
                {2, 2, 2},                  // All same number
                {1}                         // Single element
        };

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(5, 6));
        expected.add(List.of(2));
        expected.add(List.of());
        expected.add(List.of(1, 3));
        expected.add(List.of());

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            List<Integer> result = solution.findDisappearedNumbers(nums);
            System.out.println("Teste " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(nums));
            System.out.println("Esperado: " + expected.get(i));
            System.out.println("Resultado: " + result);
            System.out.println(result.equals(expected.get(i)) ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}
