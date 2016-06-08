public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int max = Integer.MIN_VALUE;
        int smallest = 0;
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(max, prefixSum[i] - smallest);
            smallest = Math.min(smallest, prefixSum[i]);
        }
        
        return max;
    }
}
