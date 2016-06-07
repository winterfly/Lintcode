public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] dp = new int[A.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(dp[i], max);
            } else {
                dp[i] = 1;
            }
        }
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(dp[i], max);
            } else {
                dp[i] = 1;
            }
        }
        
        
        return max;
    }
}
