package JavaSolutions;

import java.util.Arrays;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int[][] testCases = {
                {3, 0, 1},          // Caso 1: Falta o 2
                {0, 1},             // Caso 2: Falta o 2 (n=2)
                {9, 6, 4, 2, 3, 5, 7, 0, 1}, // Caso 3: Falta o 8
                {0},                // Caso extremo: Falta o 1 (n=1)
                {1},                // Caso extremo: Falta o 0 (n=1)
                {1, 2, 3}           // Caso adicional: Falta o 0 (n=3)
        };
        int[] expected = {2, 2, 8, 1, 0, 0};

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int result = MissingNumber.missingNumber(nums);
            System.out.println("Teste " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(nums));
            System.out.println("Esperado: " + expected[i]);
            System.out.println("Resultado: " + result);
            System.out.println(result == expected[i] ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }

}
