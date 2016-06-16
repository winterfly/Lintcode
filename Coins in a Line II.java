public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        if (n <= 2) {
            return true;
        }
        
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = values[n - 1];
        dp[n - 2] = values[n - 2] + values[n - 1];
        dp[n - 3] = values[n - 3] + values[n - 2];
        for (int i = n - 4; i >= 0; i--) {
            dp[i] = Math.max(values[i] + Math.min(dp[i + 2], dp[i + 3]), values[i] + values[i + 1] + Math.min(dp[i + 3], dp[i + 4]));
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += values[i];
        }
        
        return dp[0] > sum - dp[0];
    }
}
