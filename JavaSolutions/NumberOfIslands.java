package JavaSolutions;

import java.util.Arrays;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // Mark the cell as visited

        // Explore all four directions
        dfs(grid, i + 1, j, rows, cols);
        dfs(grid, i - 1, j, rows, cols);
        dfs(grid, i, j + 1, rows, cols);
        dfs(grid, i, j - 1, rows, cols);
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][][] testCases = {
                {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                },
                {
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                }
        };

        int[] expected = {1, 3};

        for (int i = 0; i < testCases.length; i++) {
            char[][] grid = testCases[i];
            int result = solution.numIslands(grid);
            System.out.println("Test " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.deepToString(grid));
            System.out.println("Expected: " + expected[i]);
            System.out.println("Result: " + result);
            System.out.println(result == expected[i] ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}
