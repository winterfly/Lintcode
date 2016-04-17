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
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i-1], prices[i] - min);
        }
        
        right[n-1] = 0;
        int max = prices[n-1];
        for (int i = n-2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i+1], max - prices[i]);
        }
        
        int res = Math.max(left[n-1], right[0]);
        for (int i = 1; i < n; i++) {
            res = Math.max(res, left[i-1] + right[i]);
        }
        return res;
        
    }
};
