class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        
        
        for (int i = 1; i < n; i++) {
            dp[i+1] = dp[i];
            for (int j = 0; j < i; j++) {
                dp[i+1] = Math.max(dp[i+1], Math.max(prices[i]-prices[j], 0) + dp[j]);
            }
        }
        
        return dp[n];
        
    }
};
