public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        if (A[0] == 0) { // if A[0] is 0, then there is no chance to jump to the last index when A has a length greater than 1.
            return A.length == 1; // Attention here!
        }
        int n = A.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (j + A[j] >= i && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}
