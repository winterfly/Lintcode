public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */

    public int backPack(int m, int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        boolean[] dp = new boolean[m+1];
        dp[0] = true;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            int size = A[i];
            for (int j = m - size; j >=0; j--) {
                if (dp[j]) {
                    dp[j + size] = true;
                    maxSize = Math.max(maxSize, j + size);
                }
            }
        }
        
        return maxSize;
    }
}
