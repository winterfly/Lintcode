public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        int temp1, temp2;
        for (int i = 1; i < n; i++) {
            temp1 = min * nums[i];
            temp2 = max * nums[i];
            min = Math.min(nums[i], Math.min(temp1, temp2));
            max = Math.max(nums[i], Math.max(temp1, temp2));
            res = Math.max(res, max);
        }
        return res;
    }
}
