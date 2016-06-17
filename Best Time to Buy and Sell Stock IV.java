class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */

    private int maxProfit0(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i-1]);
        }
        return res;
    }
    
    public int maxProfit(int k, int[] prices) {
        if (2 * k >= prices.length) {
            return maxProfit0(prices);    
        }
        
        int n = prices.length;
        int[][] global = new int[n][k+1];
        int[][] local = new int[n][k+1];
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < n; i++) {
                int diff = prices[i] - prices[i-1];
                local[i][j] = Math.max(local[i-1][j] + diff, global[i-1][j-1] + diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        
        return global[n-1][k];
    }
};
