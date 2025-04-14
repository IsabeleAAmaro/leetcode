package JavaSolutions;

import java.util.Arrays;

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int currentProfit = prices[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        int[][] testCases = {
                {7, 1, 5, 3, 6, 4},
                {7, 6, 4, 3, 1},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1}
        };

        int[] expected = {5, 0, 4, 0};

        for (int i = 0; i < testCases.length; i++) {
            int[] prices = testCases[i];
            int result = solution.maxProfit(prices);
            System.out.println("Teste " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(prices));
            System.out.println("Esperado: " + expected[i]);
            System.out.println("Resultado: " + result);
            System.out.println(result == expected[i] ? "✅ PASS" : "❌ FAIL");
            System.out.println("----------------------");
        }
    }
}
