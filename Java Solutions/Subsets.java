import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n; // Calculate 2^n using bit shift

        // Iterate through all possible subset masks
        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<>();
            // Check each bit in the mask to build the subset
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) { // Check if the j-th bit is set
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }

        return result;
    }
}