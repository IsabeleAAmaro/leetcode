package JavaSolutions;
import java.util.Arrays;

class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray solution = new SquaresOfSortedArray();

        int[][] testCases = {
                {-4, -1, 0, 3, 10},
                {-7, -3, 2, 3, 11},
                {-5, -3, -2, -1},
                {0, 2, 3, 4, 5},
                {-1, 0, 1}
        };

        int[][] expected = {
                {0, 1, 9, 16, 100},
                {4, 9, 9, 49, 121},
                {1, 4, 9, 25},
                {0, 4, 9, 16, 25},
                {0, 1, 1}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int[] result = solution.sortedSquares(nums);
            System.out.println("Test " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(nums));
            System.out.println("Expected: " + Arrays.toString(expected[i]));
            System.out.println("Result: " + Arrays.toString(result));
            System.out.println(Arrays.equals(result, expected[i]) ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}
