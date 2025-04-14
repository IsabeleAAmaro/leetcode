package JavaSolutions;

import java.util.*;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  // Sort to enable two-pointer and handle duplicates

        for (int i = 0; i < nums.length - 2; i++) {  // Leave room for left/right
            // Skip duplicates for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    // Sum too small; move left pointer to increase sum
                    left++;
                } else if (sum > 0) {
                    // Sum too large; move right pointer to decrease sum
                    right--;
                } else {
                    // Found a valid triplet
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;  // Move to next unique element

                    // Skip duplicates for the right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;  // Move to next unique element
                }
            }
        }
        return res;
    }
}