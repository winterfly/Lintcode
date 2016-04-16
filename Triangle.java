public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        int n = triangle.length;
        int[] dp = new int[n];
        
        for (int j = 0; j < n; j++) {
            dp[j] = triangle[n-1][j];
        }
        
        for (int i = n-1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle[i-1][j];
            }
        }
        
        return dp[0];
    }
}
