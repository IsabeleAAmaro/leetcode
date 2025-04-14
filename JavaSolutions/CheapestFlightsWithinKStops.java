package JavaSolutions;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize the price array with infinity (1e9 as a safe upper bound)
        int[] prices = new int[n];
        Arrays.fill(prices, 1_000_000_000);
        prices[src] = 0; // Cost to reach source is 0

        // Iterate for k+1 stops (k+1 edges allowed)
        for (int i = 0; i < k + 1; i++) {
            // Create a copy of the current prices to avoid overwriting in the same iteration
            int[] tempPrices = Arrays.copyOf(prices, n);

            // Check all flights
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                // If the current flight's source is reachable, update the destination's cost
                if (prices[from] != 1_000_000_000) {
                    // Relax the edge: compare new cost with existing temp price
                    if (tempPrices[to] > prices[from] + cost) {
                        tempPrices[to] = prices[from] + cost;
                    }
                }
            }

            // Update prices to the new state after this iteration
            prices = tempPrices;
        }

        // If destination is unreachable, return -1; otherwise, return the computed price
        return prices[dst] == 1_000_000_000 ? -1 : prices[dst];
    }
}