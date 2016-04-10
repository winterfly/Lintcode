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
        int left = 0, right = n - 1;
        int minVal;
        int res = 0;
        while (left < right) {
            if (heights[left] < heights[right]) {
                minVal = heights[left];
                left++;
                while (heights[left] < minVal) {
                    res += minVal - heights[left];
                    left++;
                }
            } else {
                minVal = heights[right];
                right--;
                while (heights[right] < minVal) {
                    res += minVal - heights[right];
                    right--;
                }
            }
        }
        return res;
    }
}
