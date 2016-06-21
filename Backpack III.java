public class Solution {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        int n = A.length;
        int[] dp = new int[m+1];
        for (int j = 0; j <= m; j++) {
            for (int i = 0; i < n; i++) {
                if (j >= A[i]) {
                    dp[j] = Math.max(dp[j - A[i]] + V[i], dp[j]);
                }
            }
        }
        
        int max = 0;
        for (int j = 0; j <= m; j++) {
            max = Math.max(max, dp[j]);
        }
        return max;
    } 
}
