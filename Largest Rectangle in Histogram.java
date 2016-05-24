public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <=  height.length; i++) {
            int curH = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curH <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, h*w);
            }
            stack.push(i);
        }
        return area;
    }
}
