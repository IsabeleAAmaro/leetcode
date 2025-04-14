package JavaSolutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right on top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom on right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // Traverse from right to left on bottom row
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // Traverse from bottom to top on left column
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();

        int[][][] testCases = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                },
                {
                        {1, 2},
                        {3, 4}
                }
        };

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5));
        expected.add(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
        expected.add(List.of(1, 2, 4, 3));

        for (int i = 0; i < testCases.length; i++) {
            int[][] matrix = testCases[i];
            List<Integer> result = solution.spiralOrder(matrix);
            System.out.println("Teste " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.deepToString(matrix));
            System.out.println("Esperado: " + expected.get(i));
            System.out.println("Resultado: " + result);
            System.out.println(result.equals(expected.get(i)) ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}
