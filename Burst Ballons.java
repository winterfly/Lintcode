public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    int[][] dp;
    boolean[][] flag;
    int n;    

    private int search(int i, int j, int[] nums) {
        if (i > j) {
            return 0;
        }
        
        if (flag[i][j]) {
            return dp[i][j];
        }
        
        flag[i][j] = true;
        
        if (i == j) {
            dp[i][j] = (i == 0 ? 1 : nums[i-1]) * nums[i] * (j == n-1 ? 1 : nums[j+1]);
            return dp[i][j];
        }
        
        for (int k = i; k <= j; k++) {
            int left = search(i, k-1, nums);
            int right = search(k+1, j, nums);
            dp[i][j] = Math.max(dp[i][j], left + right + (i == 0 ? 1 : nums[i-1]) * nums[k] * (j == n-1 ? 1 : nums[j+1]));
        }
        
        return dp[i][j];
    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        n = nums.length;
        dp = new int[n][n];
        flag = new boolean[n][n];
        
        return search(0, n-1, nums);
    }
}
