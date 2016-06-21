public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */

    int[][] dp;
    int[][] sum;
    boolean[][] flag;

    private int minScore(int i, int j, int[] A) {
        if (flag[i][j]) {
            return dp[i][j];
        }
        if (i != j) {
            dp[i][j] = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
                dp[i][j] = Math.min(dp[i][j], minScore(i, k, A) + minScore(k+1, j, A) + sum[i][j]);
            }
        }
        flag[i][j] = true;
        return dp[i][j];
    }

    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        dp = new int[n][n];
        sum = new int[n][n];
        flag = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            sum[i][i] = A[i];
            for (int j = i+1; j < n; j++) {
                sum[i][j] = sum[i][j-1] + A[j];
            }
        }
        
        return minScore(0, n-1, A);
    }
}
