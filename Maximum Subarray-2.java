public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // function: local[i] = max(local[i-1]+nums[i], nums[i]);
        //           res = max(local[i])  over i
        // initialization: local[0] = nums[0];
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        
        int res = nums[0];
        int local = nums[0];
        for (int i = 1; i < n; i++) {
            local = Math.max(nums[i], local + nums[i]);
            res = Math.max(local, res);
        }
        return res;
    }
}
