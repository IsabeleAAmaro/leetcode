package JavaSolutions;

import java.util.Arrays;

class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];

            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);

            totalTime += Math.max(dx, dy);
        }
        return totalTime;
    }

    public static void main(String[] args) {
        MinimumTimeVisitingAllPoints solution = new MinimumTimeVisitingAllPoints();

        int[][][] testCases = {
                {{1, 1}, {3, 4}, {-1, 0}},  // Example 1
                {{3, 2}, {-2, 2}},           // Example 2
                {{0, 0}, {1, 1}, {2, 2}}     // Additional test case
        };

        int[] expected = {7, 5, 2};

        for (int i = 0; i < testCases.length; i++) {
            int[][] points = testCases[i];
            int result = solution.minTimeToVisitAllPoints(points);
            System.out.println("Teste " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.deepToString(points));
            System.out.println("Esperado: " + expected[i]);
            System.out.println("Resultado: " + result);
            System.out.println(result == expected[i] ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}
