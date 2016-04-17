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
        int res  = 0;
        
        for (int i = 1; i < n; i++) {
            res += Math.max(0, prices[i] - prices[i-1]);
        }
        
        return res;
        
    }
};
