package JavaSolutions;

import java.util.Arrays;

class MinimumSizeSubarraySum {
    // Solução com Janela Deslizante (O(n))
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }

    // Solução com Busca Binária no Prefixo da Soma (O(n log n))
    public int minSubArrayLenBinarySearch(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int toFind = prefixSum[i] + target;
            int j = lowerBound(prefixSum, toFind);
            if (j != n + 1) {
                minLength = Math.min(minLength, j - i);
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }

    private int lowerBound(int[] prefixSum, int target) {
        int left = 0;
        int right = prefixSum.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();

        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println("Teste 1 (Janela Deslizante): " + solution.minSubArrayLen(target1, nums1));
        System.out.println("Teste 1 (Busca Binária): " + solution.minSubArrayLenBinarySearch(target1, nums1));

        int target2 = 4;
        int[] nums2 = {1, 4, 4};
        System.out.println("Teste 2 (Janela Deslizante): " + solution.minSubArrayLen(target2, nums2));
        System.out.println("Teste 2 (Busca Binária): " + solution.minSubArrayLenBinarySearch(target2, nums2));

        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Teste 3 (Janela Deslizante): " + solution.minSubArrayLen(target3, nums3));
        System.out.println("Teste 3 (Busca Binária): " + solution.minSubArrayLenBinarySearch(target3, nums3));
    }
}
