public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        if (heights == null || heights.length <= 1) {
            return 0;
        }
        int left = 0, right = heights.length - 1;
        int res = Math.min(heights[left], heights[right]) * (right - left);
        while (left < right) {
            int leftH = heights[left];
            int rightH = heights[right];
            if (leftH < rightH) {
                while (left < right && heights[left] <= leftH) {
                    left++;
                }
            } else {
                while (left < right && heights[right] <= rightH) {
                    right--;
                }
            }
            
            if (left < right) {
                res = Math.max(res, Math.min(heights[left], heights[right]) * (right - left));
            }
        }
        
        return res;
        
    }
}
