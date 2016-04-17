public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int n = prices.length;
        int[] buyMin = new int[n];
        int[] sellMax = new int[n];
        
        buyMin[0] = prices[0];
        for (int i = 1; i < n; i++) {
            buyMin[i] = Math.min(buyMin[i-1], prices[i]);
        }
        
        sellMax[n-1] = prices[n-1];
        for (int i = n-2; i >= 0; i--) {
            sellMax[i] = Math.max(sellMax[i+1], prices[i]);
        }
        
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            res = Math.max(res, sellMax[i+1] - buyMin[i]);
        }
        
        return res;
        
    }
}
