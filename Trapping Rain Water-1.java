public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        int[] maxRight = new int[n];
        maxRight[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], heights[i]);
        }
        int maxLeft = heights[0];
        int res = Math.min(0, maxRight[0] - heights[0]); 
        for (int i = 1; i < n; i++) {
            maxLeft = Math.max(maxLeft, heights[i]);
            res += Math.min(maxLeft, maxRight[i]) - heights[i];
        }
        return res;
    }
}
