public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    
    int[][] dp;
    boolean[][] flag;
    
    private int search(int i, int j, int[] values) {
        if (i > j) {
            return 0;
        }
        if (flag[i][j]) {
            return dp[i][j];
        }
        if (i == j) {
            dp[i][j] = values[i];
        } else if (i + 1 == j) {
            dp[i][j] = Math.max(values[i], values[i+1]);
        } else {
            int left = values[i] + Math.min(search(i+2, j, values), search(i+1, j-1, values));
            int right = values[j] + Math.min(search(i+1, j-1, values), search(i, j-2, values));
            dp[i][j] = Math.max(left, right);
        }
        flag[i][j] = true;
        
        return dp[i][j];
    }
    
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += values[i];
        }
        
        dp = new int[n][n];
        flag = new boolean[n][n];
        
        return search(0, n-1, values) > sum / 2;
    }
    
    
    
}
