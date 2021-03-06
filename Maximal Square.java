public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix[0].length;
        
        int[][] dp = new int[n][m];
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
            res = Math.max(res, dp[i][0]);
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
            res = Math.max(res, dp[0][j]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        
        return res*res;
        
    }
}
