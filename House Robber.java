public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1)  return A[0];
        int n = A.length;
        long[] dp = new long[n];
        dp[0] = A[0];
        dp[1] = Math.max(dp[0], A[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + A[i]);
        }
        return dp[n-1];
    }
}
