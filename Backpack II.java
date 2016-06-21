public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m - A[i]; j >=0; j--) {
                dp[j + A[i]] = Math.max(dp[j + A[i]], dp[j] + V[i]);
            }
        }
        
        int maxVal = 0;
        for (int j = 1; j <= m; j++) {
            maxVal = Math.max(maxVal, dp[j]);
        }
        return maxVal;
    }
}
